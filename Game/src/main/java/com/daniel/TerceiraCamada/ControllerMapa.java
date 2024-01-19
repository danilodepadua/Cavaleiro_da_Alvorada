package com.daniel.TerceiraCamada;

import com.daniel.PrimeiraCamada.Cidade;
import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMapa extends Utilidades implements Initializable {

    @FXML
    private AnchorPane Fundo;
    @FXML
    private ImageView ImgMapa;

    @FXML
    private VBox VBoxMapas;

    @FXML
    void OnActionVoltar(ActionEvent event) throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(Main.getAltura());
        ImgMapa.setFitHeight(Main.getAltura() - 100);
        ImgMapa.setFitWidth(ImgMapa.getFitHeight()*1.3333);
        System.out.println(ImgMapa.getFitHeight());
        definirBackground(Fundo, "/com.daniel.Images/Fundos/Mar.jpg");
        try {
            for(Cidade cidade : Player.getPlayer().getCidadesConehcidas()){
                if(cidade != Main.cidadeAtual){
                    Button butao = new Button();
                    butao.setText(cidade.getNome());
                    butao.setOnAction(event -> {Main.cidadeAtual = cidade;
                        try {
                            Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        ;});
                    VBoxMapas.getChildren().add(butao);
                }
            }
        } catch (PlayerInexistenteException e) {
            throw new RuntimeException(e);
        }
    }
}

