package com.daniel.View;

import com.daniel.Controller.JogoFachada;
import com.daniel.Model.AudioPlayer;
import com.daniel.Model.Dados.Entidades.NPC;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.daniel.View.Utilidades.*;

public class AnciaoController implements Initializable {
    @FXML
    AnchorPane Screen;
    @FXML
    HBox Hbox;
    @FXML
    ImageView imagemNPC;
    @FXML
    Pane paneCentral;
    @FXML
    private Button btnVoltar;
    private AudioPlayer audioPlayer = new AudioPlayer();
    private static boolean irmaoVisitado = false;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        identificarTextos(Screen);
        //Main.cidadeAtual.audioPlayer.stop();
        JogoFachada.getInstance().getAudioPlayer().PlayLoop("/com.daniel.audios/msc_anciao.wav");
        definirBackground(Screen, "/com.daniel.Images/Fundos/CasaDoAnciao.jpg");
        contornarBotaoVoltar(btnVoltar);
        configurarNPCdaCidade();
    }

    private void configurarNPCdaCidade() {
        if (Objects.equals(Main.cidadeAtual.getNome(), "AURORAVILLE")) {
            carregarImagemNPC("Veio");
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
        } else if (Objects.equals(Main.cidadeAtual.getNome(), "MONTANHA DO NORTE")) {
            carregarImagemNPC("Veio");
            NPC veiacoNPC = new NPC("Veiaco");
            SistemaDeDialogo dialogo = new SistemaDeDialogo(veiacoNPC);
            paneCentral.getChildren().add(dialogo);
            dialogo.setPrefWidth(400);
            dialogo.setPrefHeight(200);
            dialogo.setLayoutX((paneCentral.getWidth() - dialogo.getPrefWidth()) / 2);
            dialogo.setLayoutY((paneCentral.getHeight() - dialogo.getPrefHeight()) / 2);
            irmaoVisitado = true;
        } else if (Objects.equals(Main.cidadeAtual.getNome(), "CIDADE PORTUÁRIA")) {
            carregarImagemNPC("Ardan");
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
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());
    }
    private void carregarImagemNPC(String nome) {
        Image imagemNPC;
        if(nome.equals("Veio")) {
            imagemNPC = new Image(getClass().getResourceAsStream("/com.daniel.Images/Personagens/veiohaha.png"));
        } else if(nome.equals("Ardan")) {
            imagemNPC = new Image(getClass().getResourceAsStream("/com.daniel.Images/Personagens/magoestiloso.png"));
        } else {
            imagemNPC = new Image(getClass().getResourceAsStream("/com.daniel.Images/Personagens/veiohaha.png"));
        }
        configurarImagemNPC(imagemNPC, nome);
    }
    private void configurarImagemNPC(Image image, String nome) {
        if (nome.equals("Ardan")) {
            imagemNPC.setImage(image);
            imagemNPC.setFitWidth(600);
            imagemNPC.setFitHeight(800);
        } else {
        imagemNPC.setImage(image);
        imagemNPC.setFitWidth(500);
        imagemNPC.setFitHeight(500);
        }
    }
}