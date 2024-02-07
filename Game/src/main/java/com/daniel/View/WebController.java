package com.daniel.View;

import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;

import javafx.scene.control.Button;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.daniel.View.Utilidades.configurarBotoes;
import static com.daniel.View.Utilidades.contornarBotaoVoltar;

public class WebController implements Initializable {

    @FXML
    private Button btnAdmin;
    @FXML
    private Button btnVoltar;
    private boolean ativarBotao = false;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configurarBotoes(btnAdmin);
        contornarBotaoVoltar(btnVoltar);
        try {
            // Abre a URL no navegador padrão
            Desktop.getDesktop().browse(new URI("http://localhost:63342/Game/Game/src/main/java/com/daniel/Controller/IA/index.html?_ijt=11l2ucj6mg5r1ba4mqpm5otb1t&_ij_reload=RELOAD_ON_SAVE"));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void carregarArquivo(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecionar Arquivo para Carregar");

        // Definir o diretório inicial (opcional)
        File initialDirectory = new File(System.getProperty("user.home"));
        fileChooser.setInitialDirectory(initialDirectory);

        // Mostrar o diálogo de seleção de arquivo
        File selectedFile = fileChooser.showOpenDialog(null);

        // Verificar se um arquivo foi selecionado
        if (selectedFile != null) {
            // Chamar o método para carregar o arquivo
            Main.saveManager.carregarAdmin(selectedFile.toPath());
            Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());
        }
    }
    @FXML
    void onClickVoltar(ActionEvent event) throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());

    }

}






