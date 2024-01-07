package com.daniel.TerceiraCamada;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Exceptions.RemoverCoinsException;
import com.daniel.PrimeiraCamada.Itens.Armas.Cajado;
import com.daniel.PrimeiraCamada.Itens.Armas.Espada;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Calcas.CalcaCouro;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Calcas.CalcaFerro;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Capacetes.CapaceteCouro;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Capacetes.CapaceteFerro;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Peitorais.PeitoralCouro;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Peitorais.PeitoralFerro;
import com.daniel.PrimeiraCamada.Itens.Item;
import com.daniel.PrimeiraCamada.Itens.Pocoes.PocaoCura;
import com.daniel.PrimeiraCamada.Itens.Pocoes.PocaoMp;
import com.daniel.PrimeiraCamada.Itens.Pocoes.TonicoDeForca;
import com.daniel.PrimeiraCamada.Itens.Pocoes.TonicoDoHeroi;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerLoja implements Initializable {
    private Item itemSelecionado; //Armazenar item clicado
    private Button lastClicked;
    @FXML
    private Button btnComprar;
    @FXML
    private ScrollPane scrollArmaduras;

    @FXML
    private ScrollPane scrollArmas;

    @FXML
    private ScrollPane scrollPocoes;
    @FXML
    private Button btnVoltar;

    @FXML
    private GridPane gridArmaduras;

    @FXML
    private GridPane gridArmas;

    @FXML
    private GridPane gridPocoes;
    @FXML
    private Text txtInfoItem;

    @FXML
    private Text txtNomeItem;

    @FXML
    private Text txtPreco;

    @FXML
    private Text txtSeuSaldo;
    @FXML
    private AnchorPane panelImage;


    @FXML
    private AnchorPane PanePrincipal;
    public void initialize(URL location, ResourceBundle resources) {
        try {
            txtSeuSaldo.setText("Seu saldo: "+ Player.getPlayer().getCoins() + " Moedas");
        } catch (PlayerInexistenteException e) {
            throw new RuntimeException(e);
        }
        panelImage.setBackground(new Background(new BackgroundImage(new Image(Main.class.getResource("/com.daniel.Images/Veio Balconista.jpeg").toString()),
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

        criarBotaoItem(new PocaoCura(), 0, 0, gridPocoes);
        criarBotaoItem(new PocaoMp(), 1, 0, gridPocoes);
        criarBotaoItem(new TonicoDeForca(), 2,0, gridPocoes);
        criarBotaoItem(new TonicoDoHeroi(),0,1, gridPocoes);

        criarBotaoItem(new CapaceteCouro(), 0, 0, gridArmaduras);
        criarBotaoItem(new CapaceteFerro(), 1, 0 , gridArmaduras);
        criarBotaoItem(new PeitoralCouro(), 2, 0, gridArmaduras);
        criarBotaoItem(new PeitoralFerro(), 0, 1, gridArmaduras);
        criarBotaoItem(new CalcaCouro(), 1, 1, gridArmaduras);
        criarBotaoItem(new CalcaFerro(), 2, 1, gridArmaduras);

        criarBotaoItem(new Espada(), 0 , 0, gridArmas);
        criarBotaoItem(new Cajado(), 1, 0, gridArmas);

    }

    private void criarBotaoItem(Item item, int columnIndex, int rowIndex, GridPane grid) {
        int columns = grid.getColumnConstraints().size();
        int rows = grid.getRowConstraints().size();

        Button button = new Button();
        ImageView imageView = new ImageView();
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(90);
        imageView.setFitHeight(40);

        double cellWidth = grid.getPrefWidth() / columns;
        double cellHeight = grid.getPrefHeight() / rows;

        button.setGraphic(imageView);
        button.setPrefSize(cellWidth, cellHeight);
        grid.add(button, columnIndex, rowIndex);

        button.setMaxSize(cellWidth, cellHeight);

        imageView.setImage(item.getImage());
        button.setStyle("-fx-background-color: #0a234d; -fx-min-width: 60; -fx-min-height: 60;-fx-background-insets: 0; -fx-background-radius: 0;-fx-border-width: 2; -fx-focus-traversable: false;");

        button.setOnMouseClicked(event -> {
            desmarcarUltimoClicado();
            destacarBotao(button);
        });

        button.setOnMousePressed(event -> {
            escurecerCor(button);
        });

        button.setOnMouseReleased(event -> {
            restaurarCor(button);
            desmarcarUltimoClicado();
            destacarBotao(button);
        });
        button.setOnAction(event -> {
            try {
                ItemSelecionado(item); // Chama o método ItemSelecionado com o item clicado
            } catch (PlayerInexistenteException e) {
                throw new RuntimeException(e);
            }
            itemSelecionado = item; // Configura o itemSelecionado com o item clicado
        });
    }


    @FXML
    void onClickComprar(ActionEvent event) throws PlayerInexistenteException, RemoverCoinsException {
        if (Player.getPlayer() != null && itemSelecionado != null) {
            int precoItem = itemSelecionado.getPreco();
            if (Player.getPlayer().getCoins() >= precoItem) {
                // Realize a compra
                Player.getPlayer().removerCoins(precoItem);
                Player.getPlayer().getInventario().adicionarItem(itemSelecionado);

                // Atualiza as informações do item após a compra
                ItemSelecionado(itemSelecionado);

                System.out.println("Compra realizada com sucesso!");
                txtSeuSaldo.setText("Seu saldo: "+ Player.getPlayer().getCoins() + " Moedas");
            } else {
                System.out.println("Você não tem moedas suficientes para comprar este item.");
            }
        } else {
            System.out.println("Erro ao processar a compra. Certifique-se de que um jogador e um item estão selecionados.");
        }
    }

    @FXML
    void onClickVoltar(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")));
    }

    public void ItemSelecionado(Item i) throws PlayerInexistenteException {
        // Atualize o texto do nome do item
        txtNomeItem.setText("Nome: "+i.getNome());
        txtSeuSaldo.setText("Seu saldo: "+ Player.getPlayer().getCoins() + " Moedas" );
        txtInfoItem.setText("Descrição: " + i.getDescricao());
        txtPreco.setText("Preço: " + i.getPreco() + " Moedas");
    }

    private void escurecerCor(Button botao) {
        botao.setStyle("-fx-background-color: #0a234d; -fx-background-insets: 0; -fx-background-radius: 0;-fx-border-width: 2; -fx-focus-traversable: false;-fx-border-color: #ADD8E6;-fx-min-width: 60; -fx-min-height: 60; -fx-opacity: 0.8");
    }
    private void restaurarCor(Button botao) {
        botao.setStyle("-fx-background-color: #0a234d; -fx-min-width: 60; -fx-min-height: 60;-fx-background-insets: 0; -fx-background-radius: 0;-fx-border-width: 2; -fx-focus-traversable: false;");
    }
    private void desmarcarUltimoClicado() {
        if (lastClicked != null) {
            lastClicked.setStyle("-fx-background-color: #0a234d; -fx-min-width: 60; -fx-min-height: 60;-fx-background-insets: 0; -fx-background-radius: 0;-fx-border-width: 2; -fx-focus-traversable: false;");
        }
    }
    private void destacarBotao(Button button) {
        button.setStyle("-fx-background-color: #0a234d; -fx-background-insets: 0; -fx-background-radius: 0;-fx-border-width: 2; -fx-focus-traversable: false;-fx-border-color: #ADD8E6;-fx-min-width: 60; -fx-min-height: 60");
        lastClicked = button;
    }
}
