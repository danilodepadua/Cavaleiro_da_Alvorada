package com.daniel.TerceiraCamada;

import com.daniel.PrimeiraCamada.Cassino.Carta;
import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.BaralhoVazioException;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Exceptions.RemoverCoinsException;
import com.daniel.SegundaCamada.CassinoRepositorio.Baralho;
import com.daniel.SegundaCamada.CassinoRepositorio.Mão;
import com.daniel.game.Main;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerMemoria implements Initializable {
    //Armazenar as cartas salvar na hora de virar a carta de costas.
    private Baralho baralho;
    private List<Carta> cartas = new ArrayList<>();
    private List<Carta> limitarVirada = new ArrayList<>();
    private int valorAcumulado;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button btnApostar;
    @FXML
    private Button btnVoltar;
    @FXML
    private GridPane gridBaralho;
    @FXML
    private TextField textFieldAposta;
    @FXML
    private Text txtInsira;
    @FXML
    private VBox vboxTextos;
    @FXML
    private Button btnDesistir;
    @FXML
    private Text txtTutorial;
    @FXML
    private Text txtVitoria;

    @FXML
    private Text txtSeuSaldo;
    @FXML
    private Text txtAcumulado;
    @FXML
    void Apostar(ActionEvent event) throws PlayerInexistenteException {
        reiniciarJogo();
        txtVitoria.setText("");
        btnVoltar.setDisable(true);
        btnApostar.setDisable(true);
        btnDesistir.setDisable(false);
        txtSeuSaldo.setText("Carteira: "+ Player.getPlayer().getCoins());

        iniciarJogo();
        String valorStr = textFieldAposta.getText();
        try {
            int valorAposta = Integer.parseInt(valorStr);
            if (valorAposta > Player.getPlayer().getCoins() ) {
                System.out.println("Você não possui esse saldo");

            }
        } catch (NumberFormatException | PlayerInexistenteException e) {
            System.out.println("Valor de aposta inválido");
        }
    }
    @FXML
    void Voltar(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("ControllerCassino.fxml")));
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        anchorPane.setBackground(new Background(new BackgroundImage(new Image(Main.class.getResource("/com.daniel.Images/Cartas/Mesa.png").toString()),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(
                        BackgroundSize.AUTO,
                        BackgroundSize.AUTO,
                        false,
                        false,
                        true,
                        true
                ))));
        this.baralho = new Baralho();
        this.baralho.criarBaralho("hearts");
        this.baralho.criarBaralho("clubs");
        this.baralho.criarBaralho("spades");
        this.baralho.criarBaralho("diamonds");
        this.baralho.embaralhar();
        for (int i = 0; i < 20; i++) {
            try {
                cartas.add(baralho.pegarCarta());
            } catch (BaralhoVazioException e) {
                throw new RuntimeException(e);
            }
        }
        int posicaoCoringa = (int) (Math.random() * (cartas.size() + 1));
        cartas.add(Math.min(posicaoCoringa, cartas.size()), new Carta("Coringa", "", 0, "/com.daniel.Images/Cartas/black_joker.png"));
        txtVitoria.setText("");
        txtAcumulado.setText("");
        try {
            txtSeuSaldo.setText("Carteira: "+ Player.getPlayer().getCoins());
        } catch (PlayerInexistenteException e) {
            throw new RuntimeException(e);
        }
        btnDesistir.setDisable(true);
    }
    private void virarCarta(GridPane gridPane, int coluna, int linha) throws BaralhoVazioException {
        // Encontre a carta na posição correta no grid
        int index = coluna * 3 + linha;
        if (index < cartas.size()) {
            Carta carta = cartas.get(index);
            Button button = new Button();
            button.setPrefWidth(150);
            button.setPrefHeight(160);
            System.out.println("Carta: " + carta.getNome() + " - Virada: " + limitarVirada.contains(carta));
            // Verifique se a carta já foi virada
            if (limitarVirada.contains(carta)) {
                // Adicione a imagem da carta de costas
                ImageView imageView = new ImageView("/com.daniel.Images/Cartas/backside.png");
                imageView.setFitWidth(106);
                imageView.setFitHeight(150);
                button.setGraphic(imageView);
                // Remova a carta da lista de viradas
                limitarVirada.remove(carta);
                System.out.println("Virando para costas.");
            } else {
                // Adicione a imagem da carta virada
                ImageView imageView = new ImageView(carta.getImage());
                imageView.setFitWidth(106);
                imageView.setFitHeight(150);
                button.setGraphic(imageView);
                // Adicione a carta à lista de viradas
                limitarVirada.add(carta);
                System.out.println("Virando para frente.");
            }
            button.setStyle("-fx-background-color: transparent");
            gridPane.add(button, coluna, linha);
        }
    }
    private void adicionarCartaCostas(GridPane gridPane, int coluna, int linha) {
        // Crie uma carta de costas com valor 0
        Carta cartaCostas = new Carta("Costas", "", 0, "/com.daniel.Images/Cartas/backside.png");
        // Crie uma ImageView para a carta de costas
        Button button = new Button();
        button.setPrefWidth(150);
        button.setPrefHeight(160);
        ImageView imageView = new ImageView(cartaCostas.getImage());
        imageView.setFitWidth(106);
        imageView.setFitHeight(150);
        button.setGraphic(imageView);
        button.setStyle("-fx-background-color: transparent");
        // Adicione a imagem da carta de costas ao GridPane na coluna especificada
        gridPane.add(button, coluna, linha);
        // Adicione ação de clique ao botão da carta de costas
        button.setOnAction(event -> {
            try {
                handleCartaClick(coluna, linha);
            } catch (BaralhoVazioException e) {
                throw new RuntimeException(e);
            }
        });
    }
    private void iniciarJogo() {
        for (int coluna = 0; coluna < 7; coluna++) {
            for (int linha = 0; linha < 3; linha++) {
                adicionarCartaCostas(gridBaralho, coluna, linha);
            }
        }
    }
    @FXML
    void handleCartaClick(int coluna, int linha) throws BaralhoVazioException {
        virarCarta(gridBaralho, coluna, linha);
        String valorStr = textFieldAposta.getText();
        int valorAposta = Integer.parseInt(valorStr);

        // Verificar se duas cartas foram viradas
        if (limitarVirada.size() == 2) {
            // Aguarde um momento para que o jogador possa ver as cartas viradas
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(event -> {
                // Verifique se as duas cartas viradas são iguais
                if (limitarVirada.get(0).getNome().equals(limitarVirada.get(1).getNome())) {
                    System.out.println("Cartas iguais!");
                    removerCartasDoGrid(gridBaralho, limitarVirada);
                    valorAcumulado += valorAposta;
                    txtAcumulado.setText("Valor acumulado: "+valorAcumulado+ " Moedas");

                }else if (limitarVirada.get(0).getNome() == "Coringa" || limitarVirada.get(1).getNome() =="Coringa"){
                    System.out.println("Você perdeu! O coringa foi virado.");
                    txtVitoria.setText("Você perdeu: "+ textFieldAposta.getText());
                    btnDesistir.setDisable(true);
                    try {
                        Player.getPlayer().removerCoins(valorAposta);
                        txtSeuSaldo.setText("Carteira: "+ Player.getPlayer().getCoins());
                        valorAcumulado = 0;
                    } catch (PlayerInexistenteException e) {
                        throw new RuntimeException(e);
                    } catch (RemoverCoinsException e) {
                        throw new RuntimeException(e);
                    }
                    reiniciarJogo();
                }
                else {
                    System.out.println("Cartas diferentes.");
                    // Se não forem iguais, vire as cartas de volta para costas
                    virarCartaCostas(gridBaralho, limitarVirada);
                }
                // Limpe a lista de cartas viradas
                limitarVirada.clear();
            });
            pause.play();
        }
    }
    private void removerCartasDoGrid(GridPane gridPane, List<Carta> cartas) {
        List<Button> buttonsToRemove = new ArrayList<>();
        gridPane.getChildren().forEach(node -> {
            if (node instanceof Button && GridPane.getColumnIndex(node) != null && GridPane.getRowIndex(node) != null) {
                int index = GridPane.getColumnIndex(node) * 3 + GridPane.getRowIndex(node);
                if (index < this.cartas.size() && cartas.contains(this.cartas.get(index))) {
                    buttonsToRemove.add((Button) node);
                }
            }
        });
        gridPane.getChildren().removeAll(buttonsToRemove);
    }
    private void virarCartaCostas(GridPane gridPane, List<Carta> cartas) {
        Carta cartaCostas = new Carta("Costas", "", 0, "/com.daniel.Images/Cartas/backside.png");
        Iterator<Carta> iterator = cartas.iterator();
        List<Button> botaoPraVirar = new ArrayList<>();
        while (iterator.hasNext()) {
            Carta carta = iterator.next();
            int index = this.cartas.indexOf(carta);
            int coluna = index / 3;
            int linha = index % 3;
            Node node = gridPane.getChildren().get(coluna * gridPane.getRowCount() + linha);
            if (node instanceof Button) {
                Button button = (Button) node;
                botaoPraVirar.add(button);
                Button newButton = new Button();
                newButton.setPrefSize(106, 150);
                ImageView imageView = new ImageView(cartaCostas.getImage());
                imageView.setFitWidth(106);
                imageView.setFitHeight(150);
                newButton.setGraphic(imageView);
                newButton.setStyle("-fx-background-color: transparent");
                newButton.setOnAction(event -> {
                    try {
                        handleCartaClick(coluna, linha);
                    } catch (BaralhoVazioException e) {
                        throw new RuntimeException(e);
                    }
                });
                gridPane.add(newButton, coluna, linha);
                iterator.remove();
            }
        }
    }
    @FXML
    void Desistir(ActionEvent event) throws PlayerInexistenteException {
        Player.getPlayer().ganhaCoins(valorAcumulado);
        txtVitoria.setText("Ganhou: "+ valorAcumulado+ " Moedas");
        txtSeuSaldo.setText("Carteira: "+ Player.getPlayer().getCoins());
        valorAcumulado = 0;
        btnDesistir.setDisable(true);
        reiniciarJogo();
    }
    private void reiniciarJogo(){
        gridBaralho.getChildren().clear();
        baralho.reiniciarBaralho();
        baralho.embaralhar();
        txtAcumulado.setText("");
        btnVoltar.setDisable(false);
        btnApostar.setDisable(false);
    }
}
