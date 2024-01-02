package com.daniel.TerceiraCamada;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Interfaces.IConsumable;
import com.daniel.PrimeiraCamada.Interfaces.IEquipable;
import com.daniel.PrimeiraCamada.Itens.Item;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.net.URL;
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
    private Button btnEquipar;

    @FXML
    private Button btnDesequipar;
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
    private Text txtDescricao;
    @FXML
    private Button botaoAcao;

    public void ItemSelecionado(Item i) throws PlayerInexistenteException {
        ImagemItem.setImage(i.getImage());
        NomeItem.setText("Nome: " + i.getNome());
        txtDescricao.setText("Descrição: " +i.getDescricao());
        botaoAcao.setText("Usar");
        PainelInfos.setDisable(false);
        PainelInfos.setOpacity(1);

        if (i instanceof IConsumable) {
            botaoAcao.setOnAction(Event -> {
                try {
                    ((IConsumable) i).Consumir();
                } catch (PlayerInexistenteException e) {
                    throw new RuntimeException(e);
                }
                try {
                    Player.getPlayer().inventario.RemoverItem(i);
                    AtualizarDados();
                } catch (PlayerInexistenteException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        if (i instanceof IEquipable) {
            IEquipable equipableItem = (IEquipable) i;

            if (!Player.getPlayer().getPeitoral().equals(equipableItem) &&
                    !Player.getPlayer().getCapacete().equals(equipableItem)) {
                btnEquipar.setDisable(false);
                btnEquipar.setOnAction(event -> {
                    try {
                        equipableItem.equipar(); //Chama o equipar implementado da interface.
                        AtualizarDados();
                    } catch (PlayerInexistenteException e) {
                        throw new RuntimeException(e);
                    }
                    btnEquipar.setDisable(true);
                });

                btnDesequipar.setDisable(true);
            } else {
                btnEquipar.setDisable(true);
                btnDesequipar.setDisable(false);
                btnDesequipar.setOnAction(event -> {
                    try {
                        equipableItem.desequipar();
                        AtualizarDados();
                    } catch (PlayerInexistenteException e) {
                        throw new RuntimeException(e);
                    }
                    btnDesequipar.setDisable(true);
                });
            }
        } else {
            btnEquipar.setDisable(true);
            btnDesequipar.setDisable(true);
        }
    }

    private void AtualizarDados() throws PlayerInexistenteException {
        VelocidadePlayer.setText("Vel: " + Player.getPlayer().getVelocity());
        ForcaPlayer.setText("Fr: " + Player.getPlayer().getForce());
        HpPlayer.setText("HP: " + Player.getPlayer().getcHP() + "/" + Player.getPlayer().getHP());
        MpPlayer.setText("MP: " + Player.getPlayer().getcMp() + "/" + Player.getPlayer().getMP());
        InteligenciaPlayer.setText("Int: " + Player.getPlayer().getInteligence());
        ResistenciaPlayer.setText("Res: " + Player.getPlayer().getResistencia());
        DefesaPlayer.setText("Def: " + Player.getPlayer().getDefesaF());
        DefesaMagicaPlayer.setText("DefMag: " + Player.getPlayer().getDefesaM());
        Grid.getChildren().clear();
        int j =0;
        for(int i = 0; i< Player.getPlayer().inventario.getInventario().length; i++){
            if(Player.getPlayer().inventario.getInventario()[i] != null) {
                Button item = new Button();
                ImageView image = new ImageView();
                image.setImage(Player.getPlayer().inventario.getInventario()[i].getImage());
                Grid.add(item, j % 10, j / 10);
                item.prefWidthProperty().bind(Grid.prefWidthProperty().divide(Grid.getColumnCount()));
                item.prefHeightProperty().bind(Grid.prefHeightProperty().divide(Grid.getRowCount()));
                image.setFitWidth(50);
                image.setPreserveRatio(true);
                item.setGraphic(image);
                int finalI = i;
                item.setOnAction(event -> {
                    try {
                        ItemSelecionado(Player.getPlayer().inventario.getInventario()[finalI]);
                    } catch (PlayerInexistenteException e) {
                        throw new RuntimeException(e);
                    }
                });
                j++;
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            NomePlayer.setText(Player.getPlayer().getName());
        } catch (PlayerInexistenteException e) {
            throw new RuntimeException(e);
        }
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
        try {
            AtualizarDados();
        } catch (PlayerInexistenteException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void onClickVoltar(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("InitialCity.fxml")));
    }

}