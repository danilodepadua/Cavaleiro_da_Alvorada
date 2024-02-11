package com.daniel.View;

import com.daniel.Controller.JogoFachada;
import com.daniel.game.Main;
import com.sun.net.httpserver.HttpServer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;

import javafx.scene.control.Button;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
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
    private JogoFachada jogoFachada;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        jogoFachada = JogoFachada.getInstance();
        configurarBotoes(btnAdmin);
        contornarBotaoVoltar(btnVoltar);
        jogoFachada.ligarServidor();  // assim chamando a funçao na classe fachada pra ligar.
        try {
            // Abre a URL no navegador padrão da maquina
            Desktop.getDesktop().browse(new URI("http://localhost:4040/"));
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
        jogoFachada.desligarServidor();
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaConfiguracoes.fxml")).load());

    }

}






