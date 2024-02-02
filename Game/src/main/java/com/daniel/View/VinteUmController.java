package com.daniel.View;

import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Exceptions.*;
import com.daniel.Model.Dados.CassinoRepositorio.Baralho;
import com.daniel.Model.Cassino.Carta;
import com.daniel.Model.Dados.CassinoRepositorio.Mão;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.game.Main;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
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
    void onClickManter(ActionEvent event) throws BaralhoVazioException {
        determinarVencedor();
    }
    @FXML
    void onClickPuxar(ActionEvent event) throws BaralhoVazioException {
        adicionarCarta(GridPanePlayer, jogador, 2);
        txtSeusPontos.setText("Seus Pontos: "+ jogador.getPontos());
        determinarVencedor();

    }
    public void determinarVencedor() throws BaralhoVazioException {
        String valorStr = textFieldAposta.getText(); //Pega o valor da aposta no textField
        int valorAposta = Integer.parseInt(valorStr);  //Armazenando em uma variável inteira

        //Chamar o método de adicionar carta aos jogadores
        adicionarCarta(GridPaneDealer, dealer, 0);
        adicionarCarta(GridPaneDealer, dealer, 1);
        txtPontosDaCasa.setText("Pontos da Casa: " + dealer.getPontos()); //Setar o texto para uma imersão maior

        //Criar um pause pra determinar o vencedor
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(e -> {
            try {
                processarVencedor(valorAposta);
            } catch (PlayerInexistenteException | RemoverCoinsException ex) {
                throw new RuntimeException(ex);
            }
        });
        pause.play();

        btnManter.setDisable(true); //Desabilita os botões
        btnPuxar.setDisable(true);
    }

    private void processarVencedor(int valorAposta) throws PlayerInexistenteException, RemoverCoinsException {
        int pontosJogador = jogador.getPontos();
        int pontosDealer = dealer.getPontos();

        // Se o dealer tem menos de 14 pontos, ele puxa uma carta
        if (pontosDealer <= 14 || pontosDealer <= pontosJogador) {
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
            handleResultado("Você perdeu!");
            Player.getPlayer().removerCoins(valorAposta);
            txtSeuSaldo.setText("Seu saldo: " + Player.getPlayer().getCoins() + " Moedas");
        } else if (pontosDealer > 21 && pontosJogador <= 21) {
            handleResultado("Você venceu!");
            Player.getPlayer().ganhaCoins(valorAposta);
            txtSeuSaldo.setText("Seu saldo: " + Player.getPlayer().getCoins() + " Moedas");
        } else {
                determinarVencedorSemEstouro(pontosJogador, pontosDealer, valorAposta);
        }
    }
    private void determinarVencedorSemEstouro(int pontosJogador, int pontosDealer, int valorAposta) throws PlayerInexistenteException, RemoverCoinsException {
        // Verifica quem tem mais pontos sem ultrapassar 21
        if (pontosJogador > pontosDealer) {
            handleResultado("Você venceu!");
            Player.getPlayer().ganhaCoins(valorAposta);
            mostrarResultado("VITÓRIA");
            txtSeuSaldo.setText("Seu saldo: " + Player.getPlayer().getCoins() + " Moedas");
        } else if (pontosDealer > pontosJogador) {
            handleResultado("Você perdeu!");
            Player.getPlayer().removerCoins(valorAposta);
            mostrarResultado("DERROTA!");
            txtSeuSaldo.setText("Seu saldo: " + Player.getPlayer().getCoins() + " Moedas");
        } else {
            handleResultado("Empate!");
            txtSeuSaldo.setText("Seu saldo: " + Player.getPlayer().getCoins() + " Moedas");
            mostrarResultado("Empate!");

        }
    }
    private void handleResultado(String mensagem) {
        txtVoceGanhou.setText(mensagem);
        try {
            txtSeuSaldo.setText("Seu saldo: " + Player.getPlayer().getCoins() + " Moedas");
        } catch (PlayerInexistenteException ex) {
            throw new RuntimeException(ex);
        }
        btnApostar.setDisable(false);
        btnVoltar.setDisable(false);
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
    private void mostrarResultado(String mensagem) {
        txtMensagem.setText(mensagem);

        // Animação de fade-in
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), boxMensagem);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);

        // Animação de fade-out
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), boxMensagem);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setDelay(Duration.seconds(2));

        // Combinação das animações
        SequentialTransition sequence = new SequentialTransition(fadeIn, fadeOut);

        // Inicia a sequência de animação
        sequence.play();
    }
}
