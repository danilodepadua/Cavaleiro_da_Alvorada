package com.daniel.View;

import com.daniel.Controller.JogoFachada;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Exceptions.*;
import com.daniel.Model.Dados.RepositorioTaverna.Baralho;
import com.daniel.Model.Taverna.Carta;
import com.daniel.Model.Dados.RepositorioTaverna.Mão;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.game.Main;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.daniel.View.Utilidades.*;
import static com.daniel.View.Utilidades.definirBackground;

public class VinteUmController implements Initializable{

    private Baralho baralho;
    private Mão jogador;
    private Mão dealer;
    private final JogoFachada jogoFachada = JogoFachada.getInstance();

    @FXML
    private GridPane GridPaneDealer;

    @FXML
    private GridPane GridPanePlayer;

    @FXML
    private AnchorPane PanePrincipal;

    @FXML
    private AnchorPane boxMensagem;

    @FXML
    private Button btnApostar;

    @FXML
    private Button btnManter;

    @FXML
    private Button btnPuxar;

    @FXML
    private Button btnVoltar;

    @FXML
    private TextField textFieldAposta;

    @FXML
    private Text txtInsira;

    @FXML
    private Text txtMensagem;

    @FXML
    private Text txtPontosDaCasa;

    @FXML
    private Text txtSeuSaldo;

    @FXML
    private Text txtSeusPontos;

    @FXML
    private Text txtVoceGanhou;

    @FXML
    private VBox vboxBaralho;

    @FXML
    private VBox vboxCaixinha;

    @FXML
    private VBox vboxTextos;

    @FXML
    void onClickManter(ActionEvent event) throws BaralhoVazioException, PlayerInexistenteException {
        determinarVencedor();
    }
    @FXML
    void onClickPuxar(ActionEvent event) throws BaralhoVazioException, PlayerInexistenteException {
        adicionarCarta(GridPanePlayer, jogador, 2);
        txtSeusPontos.setText("Seus Pontos: "+ jogador.getPontos());
        determinarVencedor();

    }
    public void determinarVencedor() throws PlayerInexistenteException, BaralhoVazioException {
        String valorStr = textFieldAposta.getText();
        int valorAposta = Integer.parseInt(valorStr);

        adicionarCarta(GridPaneDealer, dealer, 0);
        adicionarCarta(GridPaneDealer, dealer, 1);
        txtPontosDaCasa.setText("Pontos da Casa: " + dealer.getPontos());
        //Criar um pause pra imersão
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(e -> {
            int pontosJogador = jogador.getPontos();
            int pontosDealer = dealer.getPontos();
            // Se o dealer tem menos de 15 pontos, ele puxa uma carta
            if (pontosDealer <= 15 || pontosDealer < pontosJogador) {
                try {
                    adicionarCarta(GridPaneDealer, dealer, 2);
                } catch (BaralhoVazioException ex) {
                    throw new RuntimeException(ex);
                }
                pontosDealer = dealer.getPontos();
                txtPontosDaCasa.setText("Pontos da Casa: " + dealer.getPontos());
            }
            // Verifica se alguém ultrapassou 21 (bust)
            if (pontosJogador > 21 && pontosDealer <= 21) {
                try {
                    txtVoceGanhou.setText("Você perdeu!");
                    mostrarResultado("Você perdeu!", txtMensagem, boxMensagem);
                    Player.getPlayer().removerCoins(valorAposta);
                    configBotoes();
                } catch (PlayerInexistenteException | RemoverCoinsException ex) {
                    throw new RuntimeException(ex);
                }
            } else if (pontosDealer > 21 && pontosJogador <= 21) {
                try {
                    txtVoceGanhou.setText("Você venceu!");
                    mostrarResultado("Você venceu!", txtMensagem, boxMensagem);
                    Player.getPlayer().ganharCoins(valorAposta );
                    configBotoes();
                } catch (PlayerInexistenteException ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                // Verifica quem tem mais pontos sem ultrapassar 21
                if (pontosJogador > pontosDealer) {
                    txtVoceGanhou.setText("Você venceu!");
                    mostrarResultado("Você venceu!", txtMensagem, boxMensagem);
                    try {
                        Player.getPlayer().ganharCoins(valorAposta );
                        configBotoes();
                    } catch (PlayerInexistenteException ex) {
                        throw new RuntimeException(ex);
                    }

                } else if (pontosDealer > pontosJogador) {
                    try {
                        txtVoceGanhou.setText("Você perdeu!");
                        mostrarResultado("Você perdeu!", txtMensagem, boxMensagem);
                        Player.getPlayer().removerCoins(valorAposta);
                        configBotoes();
                    } catch (PlayerInexistenteException | RemoverCoinsException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    try {
                        mostrarResultado("EMPATE!", txtMensagem, boxMensagem);
                        txtVoceGanhou.setText("Empate!");
                        configBotoes();
                    } catch (PlayerInexistenteException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        pause.play();
        btnManter.setDisable(true);
        btnPuxar.setDisable(true);

    }

    @FXML
    void Apostar(ActionEvent event) throws PlayerInexistenteException {
        resetarJogo();
        String valorStr = textFieldAposta.getText();
        try {
            int valorAposta = Integer.parseInt(valorStr);

            if (valorAposta > Player.getPlayer().getCoins() ) {
                throw new SemMoedasCassino();
            } else {
                adicionarCartaCostas(GridPaneDealer, 0);
                adicionarCartaCostas(GridPaneDealer, 1);
                // Distribuir cartas iniciais
                adicionarCarta(GridPanePlayer, jogador, 0);
                adicionarCarta(GridPanePlayer, jogador, 1);
                txtSeusPontos.setText("Seus Pontos: "+ jogador.getPontos());
                // Habilitar os botões após o botão "Apostar" ser clicado
                btnPuxar.setDisable(false);
                btnManter.setDisable(false);
                btnApostar.setDisable(true);
                btnVoltar.setDisable(true);
            }
        } catch (NumberFormatException | BaralhoVazioException e) {
            System.out.println("Valor de aposta inválido");
        } catch (SemMoedasCassino e) {
            throw new RuntimeException(e);
        }
    }
    private void adicionarCartaCostas(GridPane gridPane, int coluna) {
        // Crie uma carta de costas com valor 0
        Carta cartaCostas = new Carta("Costas", "", 0, "/com.daniel.Images/Cartas/backside.png");
        // Crie uma ImageView para a carta de costas
        ImageView imageView = new ImageView(cartaCostas.getImage());
        imageView.setFitWidth(106);
        imageView.setFitHeight(150);
        // Adicione a imagem da carta de costas ao GridPane na coluna especificada
        gridPane.add(imageView, coluna, 0);
    }
    @FXML
    void Voltar(ActionEvent event) throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCassino.fxml")).load());
    }
    private void configBotoes() throws PlayerInexistenteException {
        btnApostar.setDisable(false);
        btnVoltar.setDisable(false);
        txtSeuSaldo.setText("Carteira: "+Player.getPlayer().getCoins()+ " Moedas");
    }
    private void adicionarCarta(GridPane gridPane, Mão mao, int coluna) throws BaralhoVazioException {
        Carta carta = baralho.pegarCarta();
        if (carta != null) {
            ImageView imageView = new ImageView(carta.getImage());
            imageView.setFitWidth(106);
            imageView.setFitHeight(150);
            // Adiciona a imagem da carta ao GridPane na coluna especificada
            gridPane.add(imageView, coluna, 0);
            // Adiciona a carta à mão do jogador ou dealer
            mao.addCarta(carta);
            // Verifica se a pontuação ultrapassou 21 e ajusta se necessário
            verificarEstouro(mao);
        }
    }
    private void verificarEstouro(Mão mao) {
        while (mao.getPontos() > 21 && mao.temAs()) {
            mao.converterAs();
        }
    }
    private void resetarJogo() {
        //Definir os textos para algo vazio
        txtVoceGanhou.setText("");
        txtSeusPontos.setText("");
        txtPontosDaCasa.setText("");
        // Limpar as GridPanes
        GridPaneDealer.getChildren().clear();
        GridPanePlayer.getChildren().clear();
        // Resetar as variáveis do jogo
        jogador.limparMao();
        dealer.limparMao();
        // Resetar os pontos do jogador e do dealer
        jogador.setPontos(0);
        dealer.setPontos(0);
        //Resetar o baralho se acabar as cartas
        if (baralho.vazio()){
            baralho.reiniciarBaralho();
            baralho.embaralhar();
        }
        // Desabilitar os botões novamente
        btnPuxar.setDisable(true);
        btnManter.setDisable(true);

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        identificarTextos(PanePrincipal);
        // Centraliza o VBox verticalmente
        configurarBotoes(btnApostar);
        configurarBotoes(btnManter);
        configurarBotoes(btnPuxar);
        contornarBotaoVoltar(btnVoltar);
        vboxBaralho.setAlignment(Pos.CENTER);
        vboxTextos.setAlignment(Pos.CENTER);
        vboxTextos.setSpacing(10);
        vboxCaixinha.setSpacing(10);
        // Ajusta o tamanho do TextField
        textFieldAposta.setPrefColumnCount(5);

        // Desabilitar os botões no início
        btnPuxar.setDisable(true);
        btnManter.setDisable(true);

        this.baralho = new Baralho();
        this.baralho.criarBaralho("hearts");
        this.baralho.criarBaralho("clubs");
        this.baralho.criarBaralho("spades");
        this.baralho.criarBaralho("diamonds");
        this.baralho.embaralhar();
        this.jogador = new Mão();
        this.dealer = new Mão();

        try {
            txtSeuSaldo.setText("Seu saldo: " + Player.getPlayer().getCoins() + " Moedas");
        } catch (PlayerInexistenteException e) {
            throw new RuntimeException(e);
        }

        definirBackground(PanePrincipal, "/com.daniel.Images/Cartas/MesaTaverna.jpeg");
    }

}
