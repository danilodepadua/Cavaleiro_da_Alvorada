package com.daniel.View;

import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreditosController implements Initializable {

    @FXML
    private Button btnVoltar1;

    @FXML
    private Text txtCreditos;
    @FXML
    private VBox vboxCredito;
    @FXML
    private Text txtFim;

    @FXML
    void Voltar(ActionEvent event) throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaInicial.fxml")).load());
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Utilidades.contornarBotaoVoltar(btnVoltar1);
        Utilidades.adicionarCaracteresComAtrasoCredito(txtCreditos.getText(), txtCreditos, ()-> {
            txtFim.setOpacity(1.0);
        });
    }
}
