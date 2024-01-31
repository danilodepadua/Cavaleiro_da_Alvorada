package com.daniel.game;

import com.daniel.PrimeiraCamada.AudioPlayer;
import com.daniel.PrimeiraCamada.Cidade;
import com.daniel.PrimeiraCamada.Cidades.CidadeInicial;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Save.SaveManager;
import com.daniel.SegundaCamada.ConfiguracoesUsuario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.IOException;


public class Main extends Application {
    public static Stage CurrentStage;
    public static Cidade cidadeAtual;
    public static SaveManager saveManager = new SaveManager();
    public static AudioPlayer audioPlayer = new AudioPlayer();
    public static void ChangeScene(Parent root){
        Scene scene = new Scene(root, CurrentStage.getWidth(), CurrentStage.getHeight());
        CurrentStage.setScene(scene);
        System.out.println(CurrentStage.getWidth() + "x"+ CurrentStage.getHeight());
        // Adicione a chamada para reprodução de som após a mudança de cena
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
        stage.setMinHeight(675);
        stage.setMinWidth(1200);
        cidadeAtual = new CidadeInicial();
        CurrentStage = stage;
        stage.setResizable(false);
        FXMLLoader root = new FXMLLoader(Main.class.getResource("MainScene.fxml"));
        stage.setHeight(ConfiguracoesUsuario.obterAlturaTelaPadrao());
        stage.setWidth(ConfiguracoesUsuario.obterLarguraTelaPadrao());
        Scene scene = new Scene(root.load(),CurrentStage.getMaxWidth(), CurrentStage.getHeight());
        stage.setScene(scene);
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
