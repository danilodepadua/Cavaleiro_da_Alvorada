package com.daniel.TerceiraCamada;

import com.daniel.PrimeiraCamada.AudioPlayer;
import com.daniel.PrimeiraCamada.Entidades.NPC;
import com.daniel.PrimeiraCamada.SistemaDeDialogo;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.daniel.TerceiraCamada.Utilidades.*;

public class AnciaoController implements Initializable {
    @FXML
    AnchorPane Screen;
    @FXML
    HBox Hbox;
    @FXML
    ImageView veioImg;
    @FXML
    Pane paneCentral;
    @FXML
    private Button btnVoltar;
    private AudioPlayer audioPlayer = new AudioPlayer();
    private static boolean irmaoVisitado = false;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Main.cidadeAtual.audioPlayer.stop();
        audioPlayer.play("/com.daniel.audios/msc_anciao.wav", true);
        definirBackground(Screen, "/com.daniel.Images/Fundos/CasaDoAnciao.jpg");
        contornarBotaoVoltar(btnVoltar);
        configurarNPCdaCidade();
    }

    private void configurarNPCdaCidade() {
        if (Objects.equals(Main.cidadeAtual.getNome(), "Auroraville")) {
            carregarImagemVeio("Veio");
            NPC veioNPC = new NPC("Veio");
            if (irmaoVisitado) {
            veioNPC.setMaisOpcao("Seu Irmão?");
            }
            SistemaDeDialogo dialogo = new SistemaDeDialogo(veioNPC);
            paneCentral.getChildren().add(dialogo);
            dialogo.setPrefWidth(400);
            dialogo.setPrefHeight(200);
            dialogo.setLayoutX((paneCentral.getWidth() - dialogo.getPrefWidth()) / 2);
            dialogo.setLayoutY((paneCentral.getHeight() - dialogo.getPrefHeight()) / 2);
        } else if (Objects.equals(Main.cidadeAtual.getNome(), "Montanha Do Norte")) {
            carregarImagemVeio("Veio");
            NPC veiacoNPC = new NPC("Veiaco");
            SistemaDeDialogo dialogo = new SistemaDeDialogo(veiacoNPC);
            paneCentral.getChildren().add(dialogo);
            dialogo.setPrefWidth(400);
            dialogo.setPrefHeight(200);
            dialogo.setLayoutX((paneCentral.getWidth() - dialogo.getPrefWidth()) / 2);
            dialogo.setLayoutY((paneCentral.getHeight() - dialogo.getPrefHeight()) / 2);
            irmaoVisitado = true;
        } else if (Objects.equals(Main.cidadeAtual.getNome(), "Cidade Portuária")) {
            carregarImagemVeio("Ardan");
            NPC ardanNPC = new NPC("Ardan");
            SistemaDeDialogo dialogo = new SistemaDeDialogo(ardanNPC);
            paneCentral.getChildren().add(dialogo);
            dialogo.setPrefWidth(400);
            dialogo.setPrefHeight(200);
            dialogo.setLayoutX((paneCentral.getWidth() - dialogo.getPrefWidth()) / 2);
            dialogo.setLayoutY((paneCentral.getHeight() - dialogo.getPrefHeight()) / 2);
        }
    }
    @FXML
    void OnActionVoltar(ActionEvent event) throws IOException {
        audioPlayer.stop();
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());
    }
    private void carregarImagemVeio(String nome) {
        Image imagemVeio;
        if(nome.equals("Veio")) {
            imagemVeio = new Image(getClass().getResourceAsStream("/com.daniel.Images/Personagens/veiohaha.png"));
        } else if(nome.equals("Ardan")) {
            imagemVeio = new Image(getClass().getResourceAsStream("/com.daniel.Images/Personagens/magoestiloso.png"));
        } else {
            imagemVeio = new Image(getClass().getResourceAsStream("/com.daniel.Images/Personagens/veiohaha.png"));
        }
        configurarImagemVeio(imagemVeio, nome);
    }
    private void configurarImagemVeio(Image image, String nome) {
        if (nome.equals("Ardan")) {
            veioImg.setImage(image);
            veioImg.setFitWidth(600);
            veioImg.setFitHeight(800);
        } else {
        veioImg.setImage(image);
        veioImg.setFitWidth(500);
        veioImg.setFitHeight(500);
        }
    }
}