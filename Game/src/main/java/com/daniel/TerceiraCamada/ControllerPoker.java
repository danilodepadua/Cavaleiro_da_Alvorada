package com.daniel.TerceiraCamada;
import com.daniel.PrimeiraCamada.Cassino.AvaliadorPoker;
import com.daniel.PrimeiraCamada.Cassino.Carta;
import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.BaralhoVazioException;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.SegundaCamada.CassinoRepositorio.Baralho;
import com.daniel.SegundaCamada.CassinoRepositorio.Mão;
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
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

import static com.daniel.PrimeiraCamada.Cassino.AvaliadorPoker.avaliarForcaMao;
import static com.daniel.PrimeiraCamada.Cassino.AvaliadorPoker.avaliarMao;
import static com.daniel.TerceiraCamada.Utilidades.*;

public class ControllerPoker implements Initializable {
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
    int aposta;
    @FXML
    void Apostar(ActionEvent event) throws BaralhoVazioException, PlayerInexistenteException {
        String valorStr = textFieldAposta.getText();
        try {
            int valorAposta = Integer.parseInt(valorStr);
            int saldoDisponivel = Player.getPlayer().getCoins();
            aposta = valorAposta;
            if (valorAposta > saldoDisponivel) {
                System.out.println("Você não possui esse saldo");
                btnApostar.setDisable(true);
            } else {
                mostrarResultado("Rodada: 1");
                txtAposta.setText("Aposta: "+ aposta);
                btnContinuar.setDisable(false);
                try {
                    adicionarCarta(gridJogador, jogador, 0);
                    adicionarCarta(gridJogador, jogador, 1);
                    adicionarCarta(gridDealer, casa, 0);
                    adicionarCarta(gridDealer, casa, 1);

                    adicionarCarta(gridCartasNoCentro, cartasCentro, 0);
                    adicionarCarta(gridCartasNoCentro, cartasCentro, 1);
                    adicionarCarta(gridCartasNoCentro, cartasCentro, 2);


                    adicionarCartaCostas(gridDealer, 0);
                    adicionarCartaCostas(gridDealer, 1);

                    System.out.println("Deseja continuar?");
                    btnApostar.setDisable(true);
                } catch (BaralhoVazioException e) {
                    throw new RuntimeException(e);
                }

            }
        } catch (NumberFormatException e) {
            System.out.println("Valor de aposta inválido");
        }
    }


    @FXML
    void Desistir(ActionEvent event) {
        limparMesa();
        btnApostar.setDisable(false);
        btnContinuar.setDisable(true);
    }
    @FXML
    void Voltar(ActionEvent event) throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCassino.fxml")).load());

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.cartasCentro = new Mão();
        definirBackground(panePrincipal, "/com.daniel.Images/Cartas/MesaTaverna.jpeg");
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

        AtomicInteger coluna = new AtomicInteger(2);
        btnContinuar.setOnAction(event -> {
            mostrarResultado("Rodada: " + (coluna.get() + 1));
            try {
                continuarAposta(coluna.get());
                // Verifica se o texto do textFieldAposta não é nulo
                String apostaTexto = textFieldAposta.getText();

                if (apostaTexto != null) {
                    aposta += Integer.parseInt(apostaTexto);
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
                coluna.getAndIncrement();
                textFieldAposta.setText(null);
                txtAposta.setText("Aposta: "+aposta);
            } catch (BaralhoVazioException e) {
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
            // Adiciona a imagem da carta ao GridPane na coluna especificada
            gridPane.add(imageView, coluna, 0);
            // Adiciona a carta à mão do jogador ou dealer
            mao.addCarta(carta);
        }
        return carta;
    }

    private void continuarAposta(int coluna) throws BaralhoVazioException {
       adicionarCarta(gridCartasNoCentro, cartasCentro ,coluna+1);

    }

    private void determinarVencedor() throws PlayerInexistenteException {
        String resultadoJogador = avaliarMao(jogador, cartasCentro);
        String resultadoCasa = avaliarMao(casa, cartasCentro);

        int forcaJogador = avaliarForcaMao(jogador, cartasCentro);
        int forcaCasa = avaliarForcaMao(casa, cartasCentro);

        if (forcaJogador > forcaCasa ) {
            System.out.println("Jogador vence!");
            mostrarResultado("Você ganhou! ");
            Player.getPlayer().ganhaCoins(aposta);
            txtSeuResultado.setText("Seu resultado: "+ resultadoJogador);
            txtResultadoCasa.setText("Resultado casa: "+ resultadoCasa);
            btnApostar.setDisable(false);
            btnContinuar.setDisable(true);
            System.out.println("Cartas da casa: "+ casa.getMao().size());
            for (Carta carta: casa.getMao()){
                System.out.println("cartas: "+ carta.getNome());
            }
        } else if (forcaJogador < forcaCasa) {
            System.out.println("Casa vence!");
            mostrarResultado("Você perdeu!");
            txtSeuResultado.setText("Seu resultado: "+ resultadoJogador);
            txtResultadoCasa.setText("Resultado casa: "+ resultadoCasa);
            Player.getPlayer().ganhaCoins(-aposta);
            btnApostar.setDisable(false);
            btnContinuar.setDisable(true);
            System.out.println("Cartas da casa: "+ casa.getMao().size());
            for (Carta carta: casa.getMao()){
                System.out.println("cartas: "+ carta.getNome());
            }
        } else {
            System.out.println("Empate!");
            mostrarResultado("Empate");
            txtSeuResultado.setText("Seu resultado: "+ resultadoJogador);
            txtResultadoCasa.setText("Resultado casa: "+ resultadoCasa);
            btnContinuar.setDisable(true);
            for (Carta carta: casa.getMao()){
                System.out.println("cartas: "+ carta.getNome());
            }

        }
    }

    private void mostrarResultado(String mensagem) {
        txtMensagem.setText(mensagem);

        // Torna o pane visível
        boxMensagem.setOpacity(1);

        // Adiciona um evento para ser executado após o período de pausa
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(event -> {
            // Torna o pane invisível após o período de pausa
            boxMensagem.setOpacity(0);
        });

        // Inicia a pausa
        pause.play();
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

    }

    private void testeBaralhos(){
        Carta carta2 = new Carta("Two", "hearts", 2, "/com.daniel.Images/Cartas/two_of_hearts.png");

    }
}
