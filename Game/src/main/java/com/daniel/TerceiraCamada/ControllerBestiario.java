package com.daniel.TerceiraCamada;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerBestiario implements Initializable {

    @FXML
    private ImageView ImgBesta;

    @FXML
    private Text TxtFr;

    @FXML
    private Text TxtHP;

    @FXML
    private Text TxtInt;

    @FXML
    private Text TxtMP;

    @FXML
    private Text TxtNome;

    @FXML
    private Text TxtRes;

    @FXML
    private Text TxtVel;

    @FXML
    private VBox VBoxBestas;

    @FXML
    void OnActionVoltar(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaInfosPlayer.fxml")));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Inimigo[] bestas = Player.getPlayer().getBestiario().getInimigos();
            for(Inimigo i : bestas){
                Button btnBesta = new Button();
                if(i == null){
                    btnBesta.setText("?????");
                    btnBesta.setOnAction(event -> {
                        TxtFr.setText("Força: ???");
                        TxtHP.setText("HP: ???");
                        TxtMP.setText("MP: ???");
                        TxtNome.setText("?????");
                        TxtRes.setText("Resistência: ???");
                        TxtInt.setText("Inteligência: ???");
                        TxtVel.setText("Velocidade: ???");
                        ImgBesta.setImage(new Image(Main.class.getResource("/com.daniel.Images/Interrogacao.png").toString()));
                    });
                }
                else{
                    btnBesta.setText(i.getName());
                    btnBesta.setOnAction(event -> {
                        TxtFr.setText("Força: " + i.getForce());
                        TxtHP.setText("HP: " + i.getHP());
                        TxtMP.setText("MP: " + i.getMP());
                        TxtNome.setText(i.getName());
                        TxtRes.setText("Resistência: " + i.getResistencia());
                        TxtInt.setText("Inteligência: " + i.getInteligence());
                        TxtVel.setText("Velocidade: " + i.getVelocity());
                        ImgBesta.setImage(i.getImagem());
                    });
                }
                btnBesta.setMaxWidth(Double.MAX_VALUE);
                VBoxBestas.getChildren().add(btnBesta);
            }
        } catch (PlayerInexistenteException e) {
            throw new RuntimeException(e);
        }
    }
}
