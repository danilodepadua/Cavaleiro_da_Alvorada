package com.daniel.View;

import com.daniel.Model.Dados.Inventario;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableOutBattle;
import com.daniel.Model.Interfaces.IEquipable;
import com.daniel.Model.Dados.Itens.Arma;
import com.daniel.Model.Dados.Itens.Armaduras.Calca;
import com.daniel.Model.Dados.Itens.Armaduras.Capacete;
import com.daniel.Model.Dados.Itens.Armaduras.Peitoral;
import com.daniel.Model.Dados.Itens.Item;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.daniel.View.Utilidades.configurarBotoes;
import static com.daniel.View.Utilidades.contornarBotaoVoltar;

public class InventarioController implements Initializable {
    private boolean statusVisivel = false; // Variável para controlar se os dados estão visíveis

    @FXML
    private Text AtqFPlayer;

    @FXML
    private Text AtqMPlayer;

    @FXML
    private Text DefesaMagicaPlayer;

    @FXML
    private Text DefesaPlayer;

    @FXML
    private Text ForcaPlayer;

    @FXML
    private GridPane Grid;

    @FXML
    private Text HpPlayer;

    @FXML
    private ImageView ImagemItem;

    @FXML
    private Text InteligenciaPlayer;

    @FXML
    private Text MpPlayer;

    @FXML
    private Text NomeItem;

    @FXML
    private AnchorPane PainelInfos;

    @FXML
    private Text ResistenciaPlayer;

    @FXML
    private ScrollPane Scroll;

    @FXML
    private Text VelocidadePlayer;

    @FXML
    private Button btnDesequipar;

    @FXML
    private Button btnEquipar;

    @FXML
    private Button btnStatus;

    @FXML
    private Button btnUsar;


    @FXML
    private Button btnVoltar;

    @FXML
    private GridPane gridEquipaveis;

    @FXML
    private Text txt1;

    @FXML
    private Text txt10;

    @FXML
    private Text txt2;

    @FXML
    private Text txt3;

    @FXML
    private Text txt4;

    @FXML
    private Text txt5;

    @FXML
    private Text txt6;

    @FXML
    private Text txt7;

    @FXML
    private Text txt8;

    @FXML
    private Text txt9;

    @FXML
    private Text txtDescricao;

    @FXML
    private Text txtQtdItem;

    public void ItemSelecionado(Item i) throws PlayerInexistenteException {
        ImagemItem.setImage(i.getImage());
        btnUsar.setText("Usar");
        NomeItem.setText(i.getNome());
        txtDescricao.setText(i.getDescricao());
        txtQtdItem.setText(""+i.getQuant());
        PainelInfos.setDisable(false);
        PainelInfos.setOpacity(1);

        if (i instanceof IConsumableOutBattle) {
            btnUsar.setDisable(false);
            configurarAcaoConsumivel((IConsumableOutBattle) i);
        } else {
            btnUsar.setDisable(true);
        }

        if (i instanceof IEquipable) {
            IEquipable equipableItem = (IEquipable) i;

            if (Player.getPlayer().podeEquiparItem(equipableItem)) {
                configurarBtnEquipar(equipableItem, i);
            } else {
                configurarBtnDesequipar(equipableItem);
            }
        } else {
            btnEquipar.setDisable(true);
            btnDesequipar.setDisable(true);
        }
    }
    private void criaBotaoEquipavel(Item i) throws PlayerInexistenteException {
        if (i.getNome()!= null){
            Button itemButton = new Button();
            ImageView image = new ImageView();
            image.setImage(i.getImage()); // Usar diretamente o Item i

            image.setFitWidth(40);
            image.setPreserveRatio(true);
            itemButton.prefWidthProperty().bind(gridEquipaveis.prefWidthProperty());
            itemButton.prefHeightProperty().bind(gridEquipaveis.prefHeightProperty().divide(4));
            itemButton.setStyle("-fx-border-color:  #eccb7e; -fx-background-color:  #241811");
            configurarBotoes(itemButton);
            // Configurar ação do botão para exibir detalhes do item ou equipá-lo
            itemButton.setOnAction(event -> {
                try {
                    ItemSelecionado(i); // Passar o Item i
                } catch (PlayerInexistenteException e) {
                    throw new RuntimeException(e);
                }
            });
            // Adicionar imagem ao botão
            itemButton.setGraphic(image);
            // Configurar ação do botão para exibir detalhes do item ou equipá-lo
            if (i instanceof Peitoral) {
                atualizarGridEquipavel(itemButton, 1);
            } else if (i instanceof Capacete) {
                atualizarGridEquipavel(itemButton, 0);
            } else if (i instanceof Calca) {
                atualizarGridEquipavel(itemButton, 2);
            } else if (i instanceof Arma) {
                atualizarGridEquipavel(itemButton, 3);

            }
        }
    }
    private void atualizarGridEquipavel(Button novoBotao, int linha) {
        // Remove os botões existentes na linha
        gridEquipaveis.getChildren().removeIf(node -> GridPane.getRowIndex(node) == linha);
        // Adiciona o novo botão
        gridEquipaveis.add(novoBotao, 0, linha);
    }
    private void configurarAcaoConsumivel(IConsumableOutBattle consumable) {
        btnUsar.setOnAction(event -> {
            try {
                consumable.Consumir();
                limparTela();
                AtualizarDados();
            } catch (PlayerInexistenteException e) {
                throw new RuntimeException(e);
            }
        });
    }
    private void configurarBtnEquipar(IEquipable equipableItem, Item i) {
        btnEquipar.setDisable(false);
        btnEquipar.setOnAction(event -> {
            try {
                equipableItem.equipar();
                AtualizarDados();
                ItemSelecionado(i);
            } catch (PlayerInexistenteException e) {
                throw new RuntimeException(e);
            }
            btnEquipar.setDisable(true);
        });

        btnDesequipar.setDisable(true);
    }

    private void configurarBtnDesequipar(IEquipable equipableItem){
        btnEquipar.setDisable(true);
        btnDesequipar.setDisable(false);
        btnDesequipar.setOnAction(event -> {
            try {
                equipableItem.desequipar(); //Analogo ao equipar, chama o metodo implementando
                AtualizarDados();
                limparTela();

            } catch (PlayerInexistenteException e) {
                throw new RuntimeException(e);
            }
            btnDesequipar.setDisable(true);
        });
    }
    private void AtualizarDados() throws PlayerInexistenteException {
        txt1.setText("HP:");
        txt2.setText("MP:");
        txt3.setText("Força: ");
        txt4.setText("Ataque físico:");
        txt5.setText("Velocidade:");
        txt6.setText("Inteligência:");
        txt7.setText("Ataque mágico:");
        txt8.setText("Defesa mágica:");
        txt9.setText("Resistência:");
        txt10.setText("Defesa física:");
        VelocidadePlayer.setText("" + Player.getPlayer().getVelocity());
        ForcaPlayer.setText("" + Player.getPlayer().getForce());
        HpPlayer.setText("" + Player.getPlayer().getcHP() + "/" + Player.getPlayer().getHP());
        MpPlayer.setText("" + Player.getPlayer().getcMp() + "/" + Player.getPlayer().getMP());
        InteligenciaPlayer.setText("" + Player.getPlayer().getInteligence());
        ResistenciaPlayer.setText("" + Player.getPlayer().getResistencia());
        DefesaPlayer.setText("" + Player.getPlayer().getDefesaF());
        DefesaMagicaPlayer.setText("" + Player.getPlayer().getDefesaM());
        AtqFPlayer.setText("" + Player.getPlayer().getAtaqueF());
        AtqMPlayer.setText("" + Player.getPlayer().getAtaqueM());
        Grid.getChildren().clear();
        int j =0;
        for (int i = 0; i < Player.getPlayer().getInventario().getItens().length; i++) {
            if (Player.getPlayer().getInventario().getItens()[i] != null) {
                Button item = new Button();
                ImageView image = new ImageView();
                image.setImage(Player.getPlayer().getInventario().getItens()[i].getImage());

                image.setFitWidth(40);
                image.setFitHeight(40);
                Grid.add(item, j % 10, j / 10);
                item.prefWidthProperty().bind(Grid.prefWidthProperty().divide(Grid.getColumnCount()));
                item.prefHeightProperty().bind(Grid.prefHeightProperty().divide(Grid.getRowCount()));
                // Defina a cor de fundo do botão, bordas arredondadas e tamanho mínimo do botão
                item.setStyle("-fx-background-color: #241811; -fx-min-width: 60; -fx-min-height: 60;-fx-background-insets: 0; -fx-background-radius: 0;-fx-border-width: 1; -fx-focus-traversable: false; -fx-border-color:  #eccb7e");

                image.setPreserveRatio(true);
                item.setGraphic(image);

                configurarBotoes(item);

                int finalI = i;
                item.setOnAction(event -> {
                    try {
                        ItemSelecionado(Player.getPlayer().getInventario().getItens()[finalI]);
                    } catch (PlayerInexistenteException e) {
                        throw new RuntimeException(e);
                    }
                });
                j++;
            }
        }
        criaBotaoEquipavel(Player.getPlayer().getPeitoral());
        criaBotaoEquipavel(Player.getPlayer().getCapacete());
        criaBotaoEquipavel(Player.getPlayer().getCalca());
        criaBotaoEquipavel(Player.getPlayer().getArma());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        contornarBotaoVoltar(btnVoltar);
        btnUsar.setDisable(true);
        btnDesequipar.setDisable(true);
        btnEquipar.setDisable(true);
        btnStatus.setDisable(false);
        Grid.prefWidthProperty().bind(Scroll.widthProperty().subtract(14));
        Grid.prefHeightProperty().bind(Grid.prefWidthProperty());
        RowConstraints row = new RowConstraints();
        ColumnConstraints col = new ColumnConstraints();
        col.setPercentWidth(100f/Grid.getColumnCount());
        row.setPrefHeight(Grid.getColumnConstraints().get(0).getPrefWidth());
        configurarBotoes(btnDesequipar);
        configurarBotoes(btnEquipar);
        configurarBotoes(btnStatus);
        configurarBotoes(btnUsar);
        for(int i = 0; i< Grid.getColumnCount(); i++){
            Grid.getRowConstraints().set(i,row);
            Grid.getColumnConstraints().set(i,col);
        }
        Grid.setLayoutX(0);
        Grid.setLayoutY(0);
        try {
            AtualizarDados();
            limparDadosStatus();
        } catch (PlayerInexistenteException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void onClickVoltar(ActionEvent event) throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaInfosPlayer.fxml")).load());
    }

    public void limparTela() {
        NomeItem.setText("");
        txtDescricao.setText("");
        txtQtdItem.setText("");
        ImagemItem.setImage(null);
    }
    @FXML
    void onClickStatus(ActionEvent event) throws PlayerInexistenteException {
        if (statusVisivel){
            limparDadosStatus(); // Chama o método para limpar os dados
            statusVisivel = false;
        }else {
            AtualizarDados();
            statusVisivel = true;
        }
    }
    // Método para limpar os dados
    private void limparDadosStatus() {
        VelocidadePlayer.setText("");
        ForcaPlayer.setText("");
        HpPlayer.setText("");
        MpPlayer.setText("");
        InteligenciaPlayer.setText("");
        ResistenciaPlayer.setText("");
        DefesaPlayer.setText("");
        DefesaMagicaPlayer.setText("");
        AtqFPlayer.setText("");
        AtqMPlayer.setText("");
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        txt4.setText("");
        txt5.setText("");
        txt6.setText("");
        txt7.setText("");
        txt8.setText("");
        txt9.setText("");
        txt10.setText("");
    }

}