package com.daniel.game;

import com.daniel.PrimeiraCamada.Cidade;
import com.daniel.PrimeiraCamada.Cidades.CidadeInicial;
import com.daniel.PrimeiraCamada.Save.SaveManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.IOException;


public class Main extends Application {
    static Stage CurrentStage;
    public static Cidade cidadeAtual;
    public static SaveManager saveManager = new SaveManager();


    public static void ChangeScene(FXMLLoader Root){
        try {
            boolean isFull = CurrentStage.isFullScreen();
            Scene scene = new Scene(Root.load(), CurrentStage.getWidth(), CurrentStage.getHeight());
            CurrentStage.setScene(scene);
            CurrentStage.setFullScreen(isFull);
            System.out.println(CurrentStage.getWidth() + "x"+ CurrentStage.getHeight());
        }
        catch(IOException i){
            i.printStackTrace();
        }
    }

    
    @Override
    public void start(Stage stage) throws IOException {
        cidadeAtual = new CidadeInicial();
        CurrentStage = stage;
        stage.setResizable(false);
        FXMLLoader root = new FXMLLoader(Main.class.getResource("MainScene.fxml"));
        stage.setHeight(639);
        stage.setWidth(1136);
        Scene scene = new Scene(root.load(),CurrentStage.getMaxWidth(), CurrentStage.getHeight());
        stage.setMinHeight(639);
        stage.setMinWidth(1136);
        stage.setScene(scene);
        stage.setTitle("teste");
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
