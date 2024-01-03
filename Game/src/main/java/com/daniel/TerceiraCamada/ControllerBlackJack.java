package com.daniel.TerceiraCamada;

import com.daniel.PrimeiraCamada.Cassino.Baralho;
import com.daniel.PrimeiraCamada.Cassino.Carta;
import com.daniel.PrimeiraCamada.Cassino.Mão;
import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerBlackJack  implements Initializable{

    private Baralho baralho;
    private Mão jogador;
    private Mão dealer;
    @FXML
    private ImageView costasCartaDois;

    @FXML
    private ImageView costasCartaUm;
    @FXML
    private GridPane GridPaneDealer;

    @FXML
    private GridPane GridPanePlayer;
    @FXML
    private AnchorPane PanePrincipal;
    @FXML
    private Button btnManter;

    @FXML
    private Button btnPuxar;

    @FXML
    private Button btnApostar;

    @FXML
    private Button btnVoltar;

    @FXML
    private TextField textFieldAposta;


    @FXML
    void onClickManter(ActionEvent event) throws PlayerInexistenteException {
        determinarVencedor();

    }

    @FXML
    void onClickPuxar(ActionEvent event) throws PlayerInexistenteException {
        adicionarCarta(GridPanePlayer, jogador, 2);
        System.out.println("Pontos do jogador apos puxar" + jogador.getPontos());
        determinarVencedor();

    }
    public void determinarVencedor() throws PlayerInexistenteException {
        String valorStr = textFieldAposta.getText();
        int valorAposta = Integer.parseInt(valorStr);


        adicionarCarta(GridPaneDealer, dealer, 0);
        adicionarCarta(GridPaneDealer, dealer, 1);

        int pontosJogador = jogador.getPontos();
        int pontosDealer = dealer.getPontos();
        System.out.println("Pontos do jogador: "+ pontosJogador);
        System.out.println("Pontos do dealer: "+ pontosDealer);

        // Se o dealer tem menos de 15 pontos, ele puxa uma carta
        if (pontosDealer <= 15) {
            adicionarCarta(GridPaneDealer, dealer, 3);
            pontosDealer = dealer.getPontos();
            System.out.println("Pontos do dealer apos puxar : "+ pontosDealer);
        }

        // Verifica se alguém ultrapassou 21 (bust)
        if (pontosJogador > 21 && pontosDealer <= 21) {
            System.out.println("Você perdeu, você estourou 21!");
            Player.getPlayer().removerCoins(valorAposta);

        } else if (pontosDealer > 21 && pontosJogador <= 21) {
            System.out.println("Você venceu, o dealer estourou 21!");
            Player.getPlayer().ganhaCoins(valorAposta );
        } else {
            // Verifica quem tem mais pontos sem ultrapassar 21
            if (pontosJogador > pontosDealer) {
                System.out.println("Você venceu!");
                Player.getPlayer().ganhaCoins(valorAposta );
            } else if (pontosDealer > pontosJogador) {
                System.out.println("Você perdeu!");
                Player.getPlayer().removerCoins(valorAposta);
            } else {
                System.out.println("Empate!");
            }
        }
        btnManter.setDisable(true);
        btnPuxar.setDisable(true);

    }

    @FXML
    void Apostar(ActionEvent event) throws PlayerInexistenteException {
        resetarJogo();
        String valorStr = textFieldAposta.getText();

        try {
            int valorAposta = Integer.parseInt(valorStr);

            if (valorAposta > Player.getPlayer().getCoins()) {
                System.out.println("Você não possui esse saldo");
            } else {
                // Restante do código para realizar a aposta
                adicionarCartaCostas(GridPaneDealer, 0);
                adicionarCartaCostas(GridPaneDealer, 1);

                // Distribuir cartas iniciais
                adicionarCarta(GridPanePlayer, jogador, 0);
                adicionarCarta(GridPanePlayer, jogador, 1);

                // Habilitar os botões após o botão "Apostar" ser clicado
                btnPuxar.setDisable(false);
                btnManter.setDisable(false);
            }
        } catch (NumberFormatException e) {
            System.out.println("Valor de aposta inválido");
        }
    }

    private void adicionarCartaCostas(GridPane gridPane, int coluna) {
        // Crie uma carta de costas com valor 0
        Carta cartaCostas = new Carta("Costas", "", 0, "/com.daniel.Images/img/backside.png");

        // Crie uma ImageView para a carta de costas
        ImageView imageView = new ImageView(cartaCostas.getImage());
        imageView.setFitWidth(106);
        imageView.setFitHeight(150);

        // Adicione a imagem da carta de costas ao GridPane na coluna especificada
        gridPane.add(imageView, coluna, 0);
    }


    @FXML
    void Voltar(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("ControllerCassino.fxml")));
    }

    private void adicionarCarta(GridPane gridPane, Mão mao, int coluna) {
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
        // Limpar as GridPanes
        GridPaneDealer.getChildren().clear();
        GridPanePlayer.getChildren().clear();

        // Resetar as variáveis do jogo
        jogador.limparMao();
        dealer.limparMao();

        // Resetar os pontos do jogador e do dealer
        jogador.setPontos(0);
        dealer.setPontos(0);

        // Desabilitar os botões novamente
        btnPuxar.setDisable(true);
        btnManter.setDisable(true);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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


    }
}
