package com.daniel.game;

import com.daniel.Basicos.SaveManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.IOException;


public class Main extends Application {
    static Stage CurrentStage;
    public static SaveManager saveManager = new SaveManager();


    public static void ChangeScene(FXMLLoader Root){
        try {
            Scene scene = new Scene(Root.load());
            CurrentStage.setScene(scene);

        }
        catch(IOException ignored){
            System.out.println(ignored);
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
        CurrentStage = stage;
        FXMLLoader root = new FXMLLoader(Main.class.getResource("MainScene.fxml"));
        Scene scene = new Scene(root.load(),1024, 768);
        stage.setScene(scene);
        stage.setTitle("teste");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
