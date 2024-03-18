package com.daniel.View;

import com.daniel.Model.Dados.Cidades.Cidade;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Save.Save;
import com.daniel.Model.Dados.Textos.TextosInterface;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Exceptions.SaveInexistenteException;
import com.daniel.game.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerSaves implements Initializable {

    @FXML
    private Button Btn_Carregar;

    @FXML
    private Button Btn_Deletar;

    @FXML
    private Button Save1;

    @FXML
    private Button Save2;

    @FXML
    private Button Save3;
    @FXML
    private AnchorPane Fundo;

    @FXML
    private VBox VBox_Saves;
    @FXML
    private Text Txt_Save;

    private Save saveSelecionado;
    private int saveNum;
    @FXML
    void Delete(ActionEvent event) throws IOException {
        System.out.println("Numero do arquivo a ser deletado: " + saveNum);
        Main.saveManager.Delete(saveNum);
        Atualizar();
    }

    @FXML
    void Load(ActionEvent event) throws PlayerInexistenteException, IOException {
            for(Cidade c : saveSelecionado.getPlayer().getCidadesConehcidas()){
                c.ajustarBotoes();
            }
            Player.setPlayer(saveSelecionado.getPlayer());
            saveSelecionado.getCidade().ajustarBotoes();
            Main.cidadeAtual = saveSelecionado.getCidade();
            Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());
    }
    void NovoJogo(int num) throws IOException {
        Main.setSaveAtual(num);
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaDeHistoria.fxml")).load());
    }
    void Atualizar(){
        Btn_Carregar.setDisable(true);
        Btn_Deletar.setDisable(true);
        saveSelecionado = null;
        if(Main.saveManager.SaveExistente(1)){
            try {
                Save save = Main.saveManager.Carregar(1);
                Save1.setText(save.getPlayer().getNome() + "          LVL: "+save.getPlayer().getLvl());
                Save1.setOnAction(event->{
                    saveSelecionado = save;
                    Btn_Carregar.setDisable(false);
                    Btn_Deletar.setDisable(false);
                    saveNum = 1;
                });
            } catch (SaveInexistenteException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            Save1.setText("Novo jogo");
            Save1.setOnAction(event->{
                try {
                    NovoJogo(1);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        if(Main.saveManager.SaveExistente(2)){
            try {
                Save save = Main.saveManager.Carregar(2);
                Save2.setText(save.getPlayer().getNome() + "          LVL: "+save.getPlayer().getLvl());
                Save2.setOnAction(event->{
                    saveSelecionado = save;
                    Btn_Carregar.setDisable(false);
                    Btn_Deletar.setDisable(false);
                    saveNum = 2;
                });
            } catch (SaveInexistenteException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            Save2.setText("Novo jogo");
            Save2.setOnAction(event->{
                try {
                    NovoJogo(2);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        if(Main.saveManager.SaveExistente(3)){
            try {
                Save save = Main.saveManager.Carregar(3);
                Save3.setText(save.getPlayer().getNome() + "          LVL: "+save.getPlayer().getLvl());
                Save3.setOnAction(event->{
                    saveSelecionado = save;
                    Btn_Carregar.setDisable(false);
                    Btn_Deletar.setDisable(false);
                    saveNum = 3;
                });
            } catch (SaveInexistenteException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            Save3.setText("Novo jogo");
            Save3.setOnAction(event->{
                try {
                    NovoJogo(3);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Atualizar();
        Save1.setText(TextosInterface.getNovoJogo());
        Save2.setText(TextosInterface.getNovoJogo());
        Save3.setText(TextosInterface.getNovoJogo());
        Btn_Deletar.setText(TextosInterface.getDeletar());
        Btn_Carregar.setText(TextosInterface.getCarregar());
        Utilidades.estiloBotao(Save1);
        Utilidades.estiloBotao(Save2);
        Utilidades.estiloBotao(Save3);
        Utilidades.estiloBotao(Btn_Carregar);
        Utilidades.estiloBotao(Btn_Deletar);
        Utilidades.definirBackground(Fundo, "/com.daniel.Images/Fundos/Dungeon.jpg");
        Platform.runLater(() -> {
            Utilidades.AlinharHorizontal(Txt_Save,0.5);
            Utilidades.AlinharHorizontal(VBox_Saves,0.5);
        });
    }
}
