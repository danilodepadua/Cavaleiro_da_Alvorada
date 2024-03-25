package com.daniel.View;

import com.daniel.Model.Dados.Textos.TextoNode;
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
        Utilidades.adicionarCaracteresComAtrasoCredito(new TextoNode(
                "Programagores:\n" +
                        "-Daniel Ramos de Oliveira Tenório Bomfim\n" +
                        "-Thiago Jacinto de Oliveira Andrade\n" +
                        "-Ryan Eskinazi\n" +
                        "-Danilo de Pádua\n" +
                        "\n" +
                        "Arte:\n" +
                        "-Pimen\n" +
                        "-Aekashics\n" +
                        "-Truly Malicious\n" +
                        "-Magory\n" +
                        "\n" +
                        "Músicas\n" +
                        "\n" +
                        "-YouFulca",
                "Programmers:\n" +
                "-Daniel Ramos de Oliveira Tenório Bomfim\n" +
                "-Thiago Jacinto de Oliveira Andrade\n" +
                "-Ryan Eskinazi\n" +
                "-Danilo de Pádua\n" +
                "\n" +
                "Art:\n" +
                "-Pimen\n" +
                "-Aekashics\n" +
                "-Truly Malicious\n" +
                "-Magory\n" +
                "\n" +
                "Music\n" +
                "\n" +
                "-YouFulca").getTexto(), txtCreditos, ()-> {
            txtFim.setOpacity(1.0);
        });
    }
}
