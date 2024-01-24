package com.daniel.TerceiraCamada;


import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Itens.Item;
import com.daniel.SegundaCamada.LootTable;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.daniel.TerceiraCamada.Utilidades.configurarBotoes;
import static com.daniel.TerceiraCamada.Utilidades.definirBackground;

public class ResultadoController implements Initializable {
    @FXML
    private Button btnCacar;

    @FXML
    private Button btnRecolher;

    @FXML
    private GridPane gridItens;

    @FXML
    private AnchorPane panePrincipal;

    @FXML
    private Text txtMoedas;

    @FXML
    private Text txtSuasMoedas;

    @FXML
    private Text txtXpObitdo;

    @FXML
    private Text txtXpPlayer;
    private int moedasInimigo;
    private int xpInimigo;
    private ArrayList<Item> itensDoInimigo = new ArrayList<>();

    private void atualizarInterface() throws PlayerInexistenteException {
        txtXpObitdo.setText(String.valueOf(xpInimigo));
        txtMoedas.setText(String.valueOf(moedasInimigo));
        txtXpPlayer.setText(String.valueOf(Player.getPlayer().getXp()));
        txtSuasMoedas.setText(String.valueOf(moedasInimigo));
        criarItens();
        btnRecolher.setOnAction(event -> {
            try {
                Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")).load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            for (Item item: itensDoInimigo){
                try {
                    Player.getPlayer().getInventario().adicionarItem(item);
                } catch (PlayerInexistenteException  e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            atualizarInterface();
        } catch (PlayerInexistenteException e) {
            throw new RuntimeException(e);
        }
        definirBackground(panePrincipal, "/com.daniel.Images/Fundos/FundoVitoria.jpg");
        configurarBotoes(btnCacar);
        configurarBotoes(btnRecolher);
    }

    public void atualizarValores(int novoXp, int novasMoedas, LootTable itens) throws PlayerInexistenteException {
        xpInimigo = novoXp;
        moedasInimigo = novasMoedas;
        itensDoInimigo = itens.drop();
        atualizarInterface();
    }

    @FXML
    void onClickCacar (ActionEvent event) throws PlayerInexistenteException, IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaBatalha.fxml")).load());
    }

    private void criarItens() {
        int columnIndex = 0;
        int rowIndex = 0;

        for (Item item : itensDoInimigo) {
            ImageView view = new ImageView();
            view.setFitHeight(35);
            view.setFitWidth(35);
            view.setImage(item.getImage());

            Button button = new Button();
            button.setGraphic(view);
            button.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
            button.setStyle("-fx-background-color:  #241811;-fx-background-insets: 0; -fx-background-radius: 0;-fx-border-width: 1; -fx-focus-traversable: false; -fx-border-color: #eccb7e");

            configurarBotoes(button);


            // Adicione os elementos ao GridPane
            gridItens.add(button, columnIndex, rowIndex);

            columnIndex++;
            if (columnIndex >= 2) {
                columnIndex = 0;
                rowIndex++;
            }
        }
    }


}