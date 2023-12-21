package com.daniel.ControleInterface;

import com.daniel.Basicos.Item;
import com.daniel.game.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerInventario implements Initializable {
    ArrayList<Item> itens = new ArrayList<>();

    @FXML
    private GridPane Grid;
    @FXML
    private ImageView ImagemItem;

    @FXML
    private Text NomeItem;

    @FXML
    private AnchorPane PainelInfos;

    @FXML
    private Button botaoAcao;

    public void ItemSelecionado(Item i){
        ImagemItem.setImage(i.getImage());
        NomeItem.setText("Nome: " + i.getNome());
        botaoAcao.setText("Usar");
        PainelInfos.setDisable(false);
        PainelInfos.setOpacity(1);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(int i = 0; i<12; i++){
            itens.add(new Item("Item teste", new Image(Main.class.getResource("/com.daniel.Images/Fire/Fire1.png").toString())));
        }
        for(int i =0; i< itens.size(); i++){
            Button item = new Button();
            ImageView image = new ImageView();
            item.setGraphic(image);
            image.setImage(itens.get(i).getImage());
            image.autosize();
            Grid.add(item, i%10, (int)i/10);
            item.setMaxSize(102.2, 102.2);
            int finalI = i;
            item.setOnAction(event->ItemSelecionado(itens.get(finalI)));
        }
    }
}