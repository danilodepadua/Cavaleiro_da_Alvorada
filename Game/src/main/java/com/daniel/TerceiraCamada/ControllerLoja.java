package com.daniel.TerceiraCamada;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Itens.Item;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerLoja implements Initializable {

    @FXML
    private Button btnComprar;

    @FXML
    private Button btnVoltar;
    @FXML
    private Text txtInfoItem;

    @FXML
    private Text txtNomeItem;

    @FXML
    private AnchorPane PainelInfos;


    @FXML
    private GridPane grid;

    @FXML
    private ImageView imgBalconista;

    @FXML
    private ScrollPane scrollpane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int columns = 2;  // Número de colunas
        int rows = 3;     // Número de linhas


        for (int i = 0; i < columns * rows; i++) {
            Button item = new Button();

            ImageView image = new ImageView();

            item.setGraphic(image);

            image.setImage(Player.player.inventario.getInventario()[i].getImage());

            image.autosize();

            // Defina o tamanho preferido do botão
            item.setPrefSize(197, 132);

            // Adicione o botão ao GridPane
            grid.add(item, i % columns, i / columns);

            item.setMaxSize(197, 132);

            int finalI = i;

            item.setOnAction(event->ItemSelecionado(Player.player.inventario.getInventario()[finalI]));
        }
    }

    @FXML
    void onActionComprar(ActionEvent event) {

    }

    @FXML
    void onActionVoltar(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("InitialCity.fxml")));

    }

    public void ItemSelecionado(Item i){
        txtNomeItem.setText("Nome: " + i.getNome());
        txtInfoItem.setText("Informações: ");
        PainelInfos.setDisable(false);
        PainelInfos.setOpacity(1);
    }
}

