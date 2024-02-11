package com.daniel.game;
import com.daniel.Controller.JogoFachada;
import com.sun.net.httpserver.* ;
import com.daniel.Model.Dados.AudioPlayer;
import com.daniel.Model.Dados.CidadeRepositorio.Cidade;
import com.daniel.Model.Dados.CidadeRepositorio.Cidades.Auroraville;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Dados.Save.SaveManager;
import com.daniel.Model.Dados.ConfiguracoesUsuario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.awt.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Executors;


public class Main extends Application {
    public static Stage CurrentStage;

    public static Cidade cidadeAtual;
    public static SaveManager saveManager = new SaveManager();

    public static AudioPlayer audioPlayer = new AudioPlayer();
    Font barlow;
    public static void ChangeScene(Parent root){
        Scene scene = new Scene(root, CurrentStage.getWidth(), CurrentStage.getHeight());
        CurrentStage.setScene(scene);
        System.out.println(CurrentStage.getWidth() + "x"+ CurrentStage.getHeight());

        audioPlayer.play("/com.daniel.audios/som_click.wav", false);
    }

    public static double getLargura(){
        return CurrentStage.getWidth();
    }
    public static double getAltura(){
        return CurrentStage.getHeight();
    }
    @Override
    public void start(Stage stage) throws IOException, PlayerInexistenteException {
        try {
            // Carrega a fonte a partir do arquivo no caminho relativo
            InputStream fontStream = getClass().getResourceAsStream("/com.daniel.game/Fontes/BarlowCondensed-SemiBold.ttf");
            Font.loadFont(fontStream, 12);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        stage.setMinHeight(675);
        stage.setMinWidth(1200);
        cidadeAtual = new Auroraville();
        CurrentStage = stage;
        stage.setResizable(false);
        FXMLLoader root = new FXMLLoader(Main.class.getResource("MainScene.fxml"));
        stage.setHeight(ConfiguracoesUsuario.obterAlturaTelaPadrao());
        stage.setWidth(ConfiguracoesUsuario.obterLarguraTelaPadrao());
        Scene scene = new Scene(root.load(),CurrentStage.getMaxWidth(), CurrentStage.getHeight());
        stage.setScene(scene);
        Image icon = new Image(Main.class.getResource("/com.daniel.Images/Icons/IconJogo.png").toString());
        stage.getIcons().add(icon);

        stage.setTitle("O Cavaleiro da Alvorada");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    public static void MudarTamanhoTela(int largura, int altura){
        CurrentStage.setWidth(largura);
        CurrentStage.setHeight(altura);
    }
}
