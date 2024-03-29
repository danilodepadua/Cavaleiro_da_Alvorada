package com.daniel.View;
import com.daniel.Controller.JogoFachada;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Dados.Textos.TextosInterface;
import com.daniel.Model.Taverna.Carta;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Exceptions.BaralhoVazioException;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Exceptions.SemMoedasCassino;
import com.daniel.Model.Dados.RepositorioTaverna.Baralho;
import com.daniel.Model.Dados.RepositorioTaverna.Mão;
import com.daniel.game.Main;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.daniel.View.Utilidades.*;

public class PokerController implements Initializable {
    private Baralho baralho;
    private Mão jogador;
    private Mão casa;
    private Mão cartasCentro;
    @FXML
    private AnchorPane boxMensagem;

    @FXML
    private Button btnApostar;

    @FXML
    private Button btnContinuar;

    @FXML
    private Button btnDesistir;

    @FXML
    private Button btnVoltar;

    @FXML
    private GridPane gridCartasNoCentro;

    @FXML
    private GridPane gridDealer;

    @FXML
    private GridPane gridJogador;

    @FXML
    private AnchorPane panePrincipal;

    @FXML
    private TextField textFieldAposta;

    @FXML
    private Text txtInsira;
    @FXML
    private Text txtAposta;
    @FXML
    private Text txtResultadoCasa;

    @FXML
    private Text txtSeuResultado;
    @FXML
    private Text txtMensagem;

    @FXML
    private VBox vboxTextos;
    private int aposta;
    private int rodada = 2;
    private int coluna = 3;
    private boolean tresCartas = true;
    private boolean continuar = false;
    private JogoFachada jogoFachada;
    @FXML
    void Apostar(ActionEvent event) throws PlayerInexistenteException {
        limparMesa();
        String valorStr = textFieldAposta.getText();
        btnVoltar.setDisable(true);

        try {
            int valorAposta = Integer.parseInt(valorStr);
            int saldoDisponivel = Player.getPlayer().getCoins();
            aposta = valorAposta;
            if (valorAposta > saldoDisponivel) {
                btnApostar.setDisable(false);
                throw new SemMoedasCassino();
            } else {
                mostrarResultado(TextosInterface.getRodade()+": 1");
                txtAposta.setText(TextosInterface.getAposta()+": "+ aposta);
                btnContinuar.setDisable(false);
                try {
                    adicionarCarta(gridJogador, jogador, 0);
                    adicionarCarta(gridJogador, jogador, 1);
                    adicionarCarta(gridDealer, casa, 0);
                    adicionarCarta(gridDealer, casa, 1);


                    adicionarCartaCostas(gridDealer, 0); //substituir as cartas inicias
                    adicionarCartaCostas(gridDealer, 1);

                    btnApostar.setDisable(true);
                    textFieldAposta.setText(null);
                } catch (BaralhoVazioException e) {
                    throw new RuntimeException(e);
                }

            }
        } catch (NumberFormatException e) {
            System.out.println(new TextoNode("Valor de aposta inválido","Invalid bet value").getTexto());
        } catch (SemMoedasCassino e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void Desistir(ActionEvent event) {
        limparMesa();
        btnVoltar.setDisable(false);
        btnApostar.setDisable(false);
        btnContinuar.setDisable(true);
    }
    @FXML
    void Voltar(ActionEvent event) throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCassino.fxml")).load());

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        jogoFachada = JogoFachada.getInstance();
        txtInsira.setText(new TextoNode("Insira:","Insert:").getTexto());
        this.cartasCentro = new Mão();
        definirBackground(panePrincipal, "/com.daniel.Images/Cartas/MesaTaverna.jpeg");
        identificarTextos(panePrincipal);
        contornarBotaoVoltar(btnVoltar);
        configurarBotoes(btnDesistir);
        configurarBotoes(btnApostar);
        configurarBotoes(btnContinuar);
        btnContinuar.setDisable(true);
        this.baralho = new Baralho();
        this.baralho.criarBaralhoPoker("hearts");
        this.baralho.criarBaralhoPoker("clubs");
        this.baralho.criarBaralhoPoker("spades");
        this.baralho.criarBaralhoPoker("diamonds");
        baralho.embaralhar();

        this.jogador = new Mão();
        this.casa = new Mão();


        btnContinuar.setOnAction(event -> {
            mostrarResultado(TextosInterface.getRodade()+": "+ rodada);
            try {
                if (tresCartas){
                    adicionarCarta(gridCartasNoCentro, cartasCentro, 0);
                    adicionarCarta(gridCartasNoCentro, cartasCentro, 1);
                    adicionarCarta(gridCartasNoCentro, cartasCentro, 2);
                }
                if (continuar){
                    adicionarCarta(gridCartasNoCentro, cartasCentro ,coluna);
                    coluna++;
                }
                continuar = true;
                tresCartas = false;
                // Verifica se o texto do textFieldAposta não é nulo
                String apostaTexto = textFieldAposta.getText();
                if (apostaTexto != null) {
                    if (Integer.parseInt(apostaTexto) + aposta <= Player.getPlayer().getCoins()){
                        aposta += Integer.parseInt(apostaTexto);
                    }else {
                        textFieldAposta.setText(null);
                        throw new SemMoedasCassino();
                    }
                }

                if (cartasCentro.getMao().size() == 5) {
                    determinarVencedor();
                    Carta carta1 = casa.getMao().get(0);
                    Carta carta2 = casa.getMao().get(1);

                    // Remove a imagem da carta de costas da gridDealer
                    gridDealer.getChildren().remove(0);

                    // Adiciona as imagens das novas cartas à gridDealer
                    ImageView imageView1 = new ImageView(carta1.getImage());
                    imageView1.setFitWidth(106);
                    imageView1.setFitHeight(150);
                    gridDealer.add(imageView1, 0, 0);

                    ImageView imageView2 = new ImageView(carta2.getImage());
                    imageView2.setFitWidth(106);
                    imageView2.setFitHeight(150);
                    gridDealer.add(imageView2, 1, 0);
                }
                rodada++;
                textFieldAposta.setText(null);
                txtAposta.setText(TextosInterface.getAposta()+": "+aposta);


            } catch (BaralhoVazioException | SemMoedasCassino e) {
                throw new RuntimeException(e);
            } catch (PlayerInexistenteException e) {
                throw new RuntimeException(e);
            }

        });
    }

    //Método para adicionar uma imagem de carta de fundo
    private void adicionarCartaCostas(GridPane gridPane, int coluna) throws BaralhoVazioException {
        // Crie uma carta de costas com valor 0
        Carta cartaCostas = new Carta("Costas", "", 0, "/com.daniel.Images/Cartas/backside.png");
        // Crie uma ImageView para a carta de costas
        ImageView imageView = new ImageView(cartaCostas.getImage());
        imageView.setFitWidth(106);
        imageView.setFitHeight(150);
        // Adicione a imagem da carta de costas ao GridPane na coluna especificada
        gridPane.add(imageView, coluna, 0);
    }
    //Metodo para desenhar a carta
    private Carta adicionarCarta(GridPane gridPane, Mão mao, int coluna) throws BaralhoVazioException {
        Carta carta = baralho.pegarCarta();
        if (carta != null) {
            ImageView imageView = new ImageView(carta.getImage());
            imageView.setFitWidth(106);
            imageView.setFitHeight(150);
            gridPane.add(imageView, coluna, 0);
            mao.addCarta(carta);
        }
        return carta;
    }
    private void determinarVencedor() throws PlayerInexistenteException {
        String resultadoJogador = jogoFachada.avaliarMao(jogador, cartasCentro);
        String resultadoCasa = jogoFachada.avaliarMao(casa, cartasCentro);

        int forcaJogador = jogoFachada.avaliarForcaMao(jogador, cartasCentro);
        int forcaCasa = jogoFachada.avaliarForcaMao(casa, cartasCentro);
        btnVoltar.setDisable(false);
        if (forcaJogador > forcaCasa ) {
            mostrarResultado(new TextoNode("Você ganhou! ","You win!").getTexto());
            Player.getPlayer().ganharCoins(aposta);
            txtSeuResultado.setText(new TextoNode("Seu resultado","Your result").getTexto()+": "+ resultadoJogador);
            txtResultadoCasa.setText(new TextoNode("Resultado da casa","Home result").getTexto()+": "+ resultadoCasa);
            btnApostar.setDisable(false);
            btnContinuar.setDisable(true);
            tresCartas = true;
            continuar = false;
        } else if (forcaJogador < forcaCasa) {
            mostrarResultado(new TextoNode("Você perdeu! ","You lose!").getTexto());
            txtSeuResultado.setText(new TextoNode("Seu resultado","Your result").getTexto()+": "+ resultadoJogador);
            txtResultadoCasa.setText(new TextoNode("Resultado da casa","Home result").getTexto()+": "+ resultadoCasa);
            Player.getPlayer().ganharCoins(-aposta);
            btnApostar.setDisable(false);
            btnContinuar.setDisable(true);
            tresCartas = true;
            continuar = false;
        } else {
            txtSeuResultado.setText(new TextoNode("Seu resultado","Your result").getTexto()+": "+ resultadoJogador);
            txtResultadoCasa.setText(new TextoNode("Resultado da casa","Home result").getTexto()+": "+ resultadoCasa);
            int pontosJogador = jogador.getPontos();
            int pontosCasa = casa.getPontos();
            if (pontosJogador >= pontosCasa){
                mostrarResultado(new TextoNode("Você ganhou! ","You win!").getTexto());
            }else {
                mostrarResultado(new TextoNode("Você perdeu! ","You lose!").getTexto());
            }
            btnContinuar.setDisable(true);
            tresCartas = true;
            continuar = false;

        }
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
        fadeOut.setDelay(Duration.seconds(1)); // Adiciona um atraso de 2 segundos

        // Combinação das animações
        SequentialTransition sequence = new SequentialTransition(fadeIn, fadeOut);

        // Inicia a sequência de animação
        sequence.play();
    }

    private void limparMesa() {
        gridDealer.getChildren().clear();
        gridJogador.getChildren().clear();
        gridCartasNoCentro.getChildren().clear();
        jogador.getMao().clear();
        casa.getMao().clear();
        cartasCentro.getMao().clear();
        txtAposta.setText("");
        txtResultadoCasa.setText("");
        txtSeuResultado.setText("");
        baralho.reiniciarBaralhoPoker();
        baralho.embaralhar();
        this.rodada = 2;
        this.coluna = 3;
    }

}
