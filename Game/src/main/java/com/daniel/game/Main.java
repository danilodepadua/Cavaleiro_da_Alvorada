package com.daniel.game;

import com.daniel.PrimeiraCamada.Cidade;
import com.daniel.PrimeiraCamada.Cidades.CidadeInicial;
import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Save.SaveManager;
import com.daniel.SegundaCamada.ConfiguracoesUsuario;
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
            Scene scene = new Scene(Root.load(), CurrentStage.getWidth(), CurrentStage.getHeight());
            CurrentStage.setScene(scene);
            System.out.println(CurrentStage.getWidth() + "x"+ CurrentStage.getHeight());
        }
        catch(IOException i){
            i.printStackTrace();
        }
    }

    public static void mudarCidade(Cidade novaCidade) throws PlayerInexistenteException {
        cidadeAtual = novaCidade;
        Player.getPlayer().ativarQuests();
    }
    
    @Override
    public void start(Stage stage) throws IOException {
        stage.setMinHeight(639);
        stage.setMinWidth(1136);
        cidadeAtual = new CidadeInicial();
        CurrentStage = stage;
        stage.setResizable(false);
        FXMLLoader root = new FXMLLoader(Main.class.getResource("MainScene.fxml"));
        stage.setHeight(ConfiguracoesUsuario.obterAlturaTelaPadrao());
        stage.setWidth(ConfiguracoesUsuario.obterLarguraTelaPadrao());
        Scene scene = new Scene(root.load(),CurrentStage.getMaxWidth(), CurrentStage.getHeight());
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
