package com.daniel.TerceiraCamada;


import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Interfaces.IConsumableInBattle;
import com.daniel.PrimeiraCamada.Interfaces.IConsumableOutBattle;
import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.Itens.Armadura;
import com.daniel.PrimeiraCamada.Itens.Item;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.daniel.TerceiraCamada.Utilidades.*;
import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class ResultadoController implements Initializable {
    @FXML
    private Label labelXP;
    @FXML
    private Label labelMoedas;
    @FXML
    private Button btnVoltar;
    @FXML
    private Button btnCacar;
    @FXML
    private AnchorPane Screen;
    @FXML
    private ScrollPane scrollItens;
    @FXML
    public GridPane gridItens;
    private Item itemSelecionado; //Armazenar item clicado

    private static int xp;
    private static int moedas;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        atualizarInterface();
        definirBackground(Screen, "/com.daniel.Images/Fundos/FundoSalaDeTesouro.jpg");
        estiloBotao(btnCacar);
        estiloBotao(btnVoltar);
        configurarBotoesTelaResultado(btnCacar);
        configurarBotoesTelaResultado(btnVoltar);

        gridItens.setVgap(10);
        scrollItens.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollItens.setFitToWidth(true);
        gridItens.setMaxHeight(Double.MAX_VALUE);
        scrollItens.setContent(gridItens);
        int itemnum = 0;
        for (Item i : Main.cidadeAtual.getItens()) {
            if(i instanceof Armadura){
                criarBotaoItem(i, itemnum, gridItens);
                itemnum++;

            }
            else if(i instanceof Arma){
                criarBotaoItem(i, itemnum, gridItens);
                itemnum++;
            }
            else if(i instanceof IConsumableOutBattle || i instanceof IConsumableInBattle){
                criarBotaoItem(i, itemnum, gridItens);
                itemnum++;
            }
            System.out.println("ItemNum: " + itemnum);
        }
    }
    private void criarBotaoItem(Item item, int rowIndex, GridPane grid) {
        int columns = grid.getColumnConstraints().size();

        Button button = new Button();
        ImageView imageView = new ImageView();
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(90);
        imageView.setFitHeight(55);

        double cellWidth = grid.getPrefWidth() / columns;

        button.setGraphic(imageView);
        button.setPrefSize(cellWidth, cellWidth);
        grid.add(button, 0, rowIndex);

        button.setMaxSize(cellWidth, cellWidth);

        imageView.setImage(item.getImage());
        button.setStyle("-fx-background-color:  #241811; -fx-min-width: 60; -fx-min-height: 60;-fx-background-insets: 0; -fx-background-radius: 0;-fx-border-width: 1; -fx-focus-traversable: false; -fx-border-color: #eccb7e");

        configurarBotoes(button);
        button.setOnAction(event -> {
            try {
                ItemSelecionado(item); // Chama o método ItemSelecionado com o item clicado
            } catch (PlayerInexistenteException e) {
                throw new RuntimeException(e);
            }
            itemSelecionado = item; // Configura o itemSelecionado com o item clicado
        });
    }
    public void ItemSelecionado(Item i) throws PlayerInexistenteException {
        // Atualize o texto do nome do item
        /*txtNomeItem.setText(""+i.getNome());
        txtSeuSaldo.setText(""+ Player.getPlayer().getCoins() + " Moedas" );
        txtInfoItem.setText("" + i.getDescricao());
        txtPreco.setText("" + i.getPreco() + " Moedas");*/
    }

    @FXML
    void onClickVoltar (ActionEvent event) throws PlayerInexistenteException, IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());
    }
    @FXML
    void onClickCacar (ActionEvent event) throws PlayerInexistenteException, IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaBatalha.fxml")).load());
    }
    public  void setInfoInimigos(int moedas, int xp) {
        ResultadoController.moedas = moedas;
        ResultadoController.xp = xp;
    }

    public void atualizarInterface() {
        labelXP.setText("" + xp);
        labelMoedas.setText("" + moedas);
    }
}
