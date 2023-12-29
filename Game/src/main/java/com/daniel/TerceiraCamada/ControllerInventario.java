package com.daniel.TerceiraCamada;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Interfaces.IConsumable;
import com.daniel.PrimeiraCamada.Interfaces.IEquipable;
import com.daniel.PrimeiraCamada.Itens.Item;
import com.daniel.PrimeiraCamada.Itens.PocaoCura;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerInventario implements Initializable {

    @FXML
    private Button btnVoltar;
    @FXML
    private Text DefesaMagicaPlayer;

    @FXML
    private Text DefesaPlayer;

    @FXML
    private Text ForcaPlayer;

    @FXML
    private GridPane Grid;

    @FXML
    private Text HpPlayer;

    @FXML
    private ImageView ImagemItem;

    @FXML
    private ImageView ImgPlayer;

    @FXML
    private Text InteligenciaPlayer;

    @FXML
    private Text MpPlayer;

    @FXML
    private Button btnDesequipar;

    @FXML
    private Button btnEquipar;
    @FXML
    private Text NomeItem;

    @FXML
    private Text NomePlayer;

    @FXML
    private AnchorPane PainelInfos;

    @FXML
    private Text ResistenciaPlayer;

    @FXML
    private ScrollPane Scroll;

    @FXML
    private Text VelocidadePlayer;

    @FXML
    private Button botaoAcao;

    public void ItemSelecionado(Item i){
        ImagemItem.setImage(i.getImage());
        NomeItem.setText("Nome: " + i.getNome());
        botaoAcao.setText("Usar");
        PainelInfos.setDisable(false);
        PainelInfos.setOpacity(1);

        if (i instanceof IConsumable) {
            botaoAcao.setOnAction(Event -> {
                ((IConsumable) i).Consumir();
                Player.player.inventario.RemoverItem(i);
                AtualizarDados();
            });
        }

        if (i instanceof IEquipable) {
            IEquipable equipableItem = (IEquipable) i;
            btnEquipar.setDisable(equipableItem.isEquipado());
            btnDesequipar.setDisable(!equipableItem.isEquipado());

            btnEquipar.setOnAction(event -> {
                equipableItem.equipar();
                AtualizarDados();
                btnEquipar.setDisable(true);
            });

            btnDesequipar.setOnAction(event -> {
                equipableItem.desequipar();
                AtualizarDados();
                btnDesequipar.setDisable(true);
            });
        } else {
            btnEquipar.setDisable(true);
            btnDesequipar.setDisable(true);
        }
    }


    private void AtualizarDados(){
        VelocidadePlayer.setText("Vel: " + Player.player.getVelocity());
        ForcaPlayer.setText("Fr: " + Player.player.getForce());
        HpPlayer.setText("HP: " + Player.player.getCurrentHP() + "/" + Player.player.getHP());
        MpPlayer.setText("MP: " + Player.player.getCurrentMP() + "/" + Player.player.getMP());
        InteligenciaPlayer.setText("Int: " + Player.player.getInteligence());
        ResistenciaPlayer.setText("Res: " + Player.player.getResistencia());
        DefesaPlayer.setText("Def: " + Player.player.getDef());
        DefesaMagicaPlayer.setText("DefMag: " + Player.player.getMagicDef());
        Grid.getChildren().clear();
        int j =0;
        for(int i = 0; i< Player.player.inventario.getInventario().length; i++){
            if(Player.player.inventario.getInventario()[i] != null) {
                Button item = new Button();
                ImageView image = new ImageView();
                image.setImage(Player.player.inventario.getInventario()[i].getImage());
                Grid.add(item, j % 10, j / 10);
                item.prefWidthProperty().bind(Grid.prefWidthProperty().divide(Grid.getColumnCount()));
                item.prefHeightProperty().bind(Grid.prefHeightProperty().divide(Grid.getRowCount()));
                image.setFitWidth(50);
                image.setPreserveRatio(true);
                item.setGraphic(image);
                int finalI = i;
                item.setOnAction(event -> ItemSelecionado(Player.player.inventario.getInventario()[finalI]));
                j++;
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        NomePlayer.setText(Player.player.getName());
        Grid.prefWidthProperty().bind(Scroll.widthProperty().add(-20));
        Grid.prefHeightProperty().bind(Grid.prefWidthProperty());
        RowConstraints row = new RowConstraints();
        ColumnConstraints col = new ColumnConstraints();
        col.setPercentWidth(100f/Grid.getColumnCount());
        row.setPrefHeight(Grid.getColumnConstraints().get(0).getPrefWidth());
        for(int i = 0; i< Grid.getColumnCount(); i++){
            Grid.getRowConstraints().set(i,row);
            Grid.getColumnConstraints().set(i,col);
        }
        Grid.setLayoutX(0);
        Grid.setLayoutY(0);
        AtualizarDados();
    }

    @FXML
    void onClickVoltar(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("InitialCity.fxml")));
    }

}