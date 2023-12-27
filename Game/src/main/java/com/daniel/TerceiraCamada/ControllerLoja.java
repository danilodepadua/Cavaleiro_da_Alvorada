package com.daniel.TerceiraCamada;

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

import static com.daniel.PrimeiraCamada.Entidades.Player.player;

public class ControllerLoja implements Initializable {
    private ArrayList<Item> itensVenda = new ArrayList<>();
    private Item itemSelecionado; //Armanezar item clicado

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

        for(int i = 0; i < 6; i++) {
            itensVenda.add(new Item("Item teste", new Image(Main.class.getResource("/com.daniel.Images/Fire/Fire1.png").toString())));
        }

        for (int i = 0; i < columns * rows; i++) {
            Button item = new Button();

            ImageView image = new ImageView();

            item.setGraphic(image);

            image.setImage(itensVenda.get(i).getImage());

            image.autosize();

            // Defina o tamanho preferido do botão
            item.setPrefSize(197, 132);

            // Adicione o botão ao GridPane
            grid.add(item, i % columns, i / columns);

            item.setMaxSize(197, 132);

            int finalI = i;

            item.setOnAction(event->ItemSelecionado(itensVenda.get(finalI)));
        }
    }

    @FXML
    void onActionComprar(ActionEvent event) {
        if (itemSelecionado != null) {
            player.getInventario().adicionarItem(itemSelecionado);
            System.out.println("Item adicionado ao seu inventário");
        }
    }

    @FXML
    void onActionVoltar(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("InitialCity.fxml")));

    }

    public void ItemSelecionado(Item i){
        // Atualize o campo itemSelecionado quando um item for selecionado
        itemSelecionado = i;

        txtNomeItem.setText("Nome: " + i.getNome());
        txtInfoItem.setText("Informações: ");
        PainelInfos.setDisable(false);
        PainelInfos.setOpacity(1);
    }
}

