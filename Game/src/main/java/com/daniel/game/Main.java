package com.daniel.game;

import com.daniel.Controller.JogoFachada;
import com.daniel.Model.AudioPlayer;
import com.daniel.Model.Dados.Cidades.Cidade;
import com.daniel.Model.Dados.Cidades.Vilas.Auroraville;
import com.daniel.View.ConfiguracoesUsuario;
import com.daniel.Model.Dados.Save.SaveManager;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class Main extends Application {
    public static Stage CurrentStage; //instancia um palco inicial

    public static Cidade cidadeAtual; //instancia a cidade inicial do player
    public static SaveManager saveManager = new SaveManager(); //instancia a classe de manejar o save

    public static AudioPlayer audioPlayer = new AudioPlayer();

    private static int saveAtual = 1;
    public static int getSaveAtual(){
        return saveAtual;
    }
    public static void setSaveAtual(int num){
        if(num<1 || num >3){
            saveAtual = 1;
        }
        else{
            saveAtual = num;
        }
    }
    public static void ChangeScene(Parent root){
        Scene scene = new Scene(root, CurrentStage.getWidth(), CurrentStage.getHeight());
        CurrentStage.setScene(scene);
        JogoFachada.getInstance().getAudioPlayer().PlayEfeito("/com.daniel.audios/som_click.wav");
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
        cidadeAtual = new Auroraville();
        CurrentStage = stage;
        stage.setResizable(false);
        FXMLLoader root = new FXMLLoader(Main.class.getResource("TelaInicial.fxml"));
        stage.setHeight(ConfiguracoesUsuario.obterAlturaTelaPadrao());
        stage.setWidth(ConfiguracoesUsuario.obterLarguraTelaPadrao());
        Scene scene = new Scene(root.load(),CurrentStage.getMaxWidth(), CurrentStage.getHeight());
        stage.setScene(scene);
        Image icon = new Image(Objects.requireNonNull(Main.class.getResource("/com.daniel.Images/Icons/IconJogo.png")).toString());
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
