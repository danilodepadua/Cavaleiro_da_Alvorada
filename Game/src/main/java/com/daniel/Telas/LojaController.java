package com.daniel.Telas;

import com.daniel.Modelo.AudioPlayer;
import com.daniel.Dados.EntidadesRepositório.Player;
import com.daniel.Modelo.Exceptions.*;
import com.daniel.Modelo.Interfaces.IConsumableInBattle;
import com.daniel.Modelo.Interfaces.IConsumableOutBattle;
import com.daniel.Modelo.Itens.Arma;
import com.daniel.Modelo.Itens.Armadura;
import com.daniel.Modelo.Itens.Item;
import com.daniel.Modelo.Itens.Minerio;
import com.daniel.Modelo.Controles.LojaFachada;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.daniel.Telas.Utilidades.*;

public class LojaController implements Initializable {
    private Item itemSelecionado; //Armazenar item clicado
    @FXML
    private Button btnComprar;

    @FXML
    private Button btnVender;

    @FXML
    private Button btnVoltar;

    @FXML
    private GridPane gridArmaduras;

    @FXML
    private GridPane gridArmas;

    @FXML
    private GridPane gridPocoes;
    @FXML
    private GridPane gridMinerio;

    @FXML
    private AnchorPane panelImage;

    @FXML
    private Text txtInfoItem;

    @FXML
    private Text txtNomeItem;

    @FXML
    private Text txtPreco;

    @FXML
    private Text txtSeuSaldo;

    @FXML
    private Text txtVenda;
    private boolean ativarCompra = false;
    private AudioPlayer somCompraVenda = new AudioPlayer();
    private LojaFachada lojaFachada;

    public void initialize(URL location, ResourceBundle resources) {
        lojaFachada = LojaFachada.getInstance();
        configurarBotoes(btnComprar);
        configurarBotoes(btnVender);
        contornarBotaoVoltarLoja(btnVoltar);
        try {
            txtSeuSaldo.setText(""+ Player.getPlayer().getCoins() + " Moedas");
        } catch (PlayerInexistenteException e) {
            throw new RuntimeException(e);
        }
        definirBackground(panelImage, "/com.daniel.Images/Fundos/Veio Balconista.jpeg");
        configBotoes();
        if (ativarCompra){
            modoCompra();
        }
    }
    private void configBotoes(){
        btnVender.setOnAction(event -> {
            try {
                lojaFachada.venderItem(itemSelecionado);
                txtSeuSaldo.setText(""+Player.getPlayer().getCoins()+ " Moedas");
                configModoVenda();
                somCompraVenda.play("/com.daniel.audios/som_moedas.wav", false);
                itemSelecionado = null;
            } catch (PlayerInexistenteException e) {
                throw new RuntimeException(e);
            }
        });
        btnComprar.setOnAction(event -> {
            try {
                lojaFachada.comprarItem(itemSelecionado);
                txtSeuSaldo.setText(""+Player.getPlayer().getCoins()+ " Moedas");
                somCompraVenda.play("/com.daniel.audios/som_moedas.wav", false);
            } catch (PlayerInexistenteException | RemoverCoinsException | CompraErroException |
                     SemMoedasParaLojaException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void configModoVenda() throws PlayerInexistenteException {
        btnVender.setDisable(false);
        btnComprar.setDisable(true);

        gridArmaduras.getChildren().clear();
        gridArmas.getChildren().clear();
        gridPocoes.getChildren().clear();
        int pocoes = 0, armaduras = 0, armas = 0, minerio=0;
        for(Item i : Player.getPlayer().getInventario().getItens()){
            if(i instanceof Armadura){
                criarBotaoItem(i, armaduras%3, (int)armaduras/3, gridArmaduras);
                armaduras++;
            }
            else if(i instanceof Arma){
                criarBotaoItem(i, armas%3, (int)armas/3, gridArmas);
                armas++;
            }
            else if(i instanceof IConsumableOutBattle || i instanceof IConsumableInBattle){
                criarBotaoItem(i, pocoes%3, (int)pocoes/3, gridPocoes);
                pocoes++;
            }else if (i instanceof Minerio) {
                criarBotaoItem(i, minerio%3, (int)minerio/3, gridMinerio);
                minerio++;

            }
        }
    }
    private void criarBotaoItem(Item item, int columnIndex, int rowIndex, GridPane grid) {
        int columns = grid.getColumnConstraints().size();
        int rows = grid.getRowConstraints().size();

        Button button = new Button();
        ImageView imageView = new ImageView();
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(90);
        imageView.setFitHeight(55);

        double cellWidth = grid.getPrefWidth() / columns;
        double cellHeight = grid.getPrefHeight() / rows;

        button.setGraphic(imageView);
        button.setPrefSize(cellWidth, cellHeight);
        grid.add(button, columnIndex, rowIndex);

        button.setMaxSize(cellWidth, cellHeight);

        imageView.setImage(item.getImage());
        button.setStyle("-fx-background-color:  #241811; -fx-min-width: 60; -fx-min-height: 60;-fx-background-insets: 0; -fx-background-radius: 0;-fx-border-width: 1; -fx-focus-traversable: false; -fx-border-color: #eccb7e");

        configurarBotoes(button);
        button.setOnAction(event -> {
            try {
                ItemSelecionado(item); // Chama o método ItemSelecionado com o item clicado
            } catch (PlayerInexistenteException e) {
                throw new RuntimeException(e);
            }
            itemSelecionado = item; // Configura o itemSelecionado com o item clicado
        });
    }

    public void modoCompra(){
        btnComprar.setDisable(false);
        btnVender.setDisable(true);
        gridArmaduras.getChildren().clear();
        gridArmas.getChildren().clear();
        gridPocoes.getChildren().clear();
        int pocoes = 0, armaduras = 0, armas = 0, minerio =0;
        for(Item i : Main.cidadeAtual.getItens()){
            if(i instanceof Armadura){
                criarBotaoItem(i, armaduras%3, (int)armaduras/3, gridArmaduras);
                armaduras++;
            }
            else if(i instanceof Arma){
                criarBotaoItem(i, armas%3, (int)armas/3, gridArmas);
                armas++;
            }
            else if(i instanceof IConsumableOutBattle || i instanceof IConsumableInBattle){
                criarBotaoItem(i, pocoes%3, (int)pocoes/3, gridPocoes);
                pocoes++;
            } else if (i instanceof Minerio) {
                criarBotaoItem(i, minerio%3, (int)minerio/3, gridMinerio);
                minerio++;

            }
        }
    }
    @FXML
    void onClickVoltar(ActionEvent event) throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCompraOuVenda.fxml")).load());
    }

    public void ItemSelecionado(Item i) throws PlayerInexistenteException {
        //pega e atualiza a interface gráfica
        txtNomeItem.setText(""+i.getNome());
        txtSeuSaldo.setText(""+ Player.getPlayer().getCoins() + " Moedas" );
        txtInfoItem.setText("" + i.getDescricao());
        txtPreco.setText(i.getPreco() + " Moedas");
        itemSelecionado = i;
        txtVenda.setText((int)Math.floor(0.7 * i.getPreco()) + " Moedas");
    }

    public void setAtivado(boolean ativado) {
        this.ativarCompra = ativado;
        if (ativado) {
            modoCompra();
        }
    }

    public void setAtivarVenda(boolean ativarVenda) throws PlayerInexistenteException {
        if (ativarVenda) {
            ativarCompra = false;
            configModoVenda();
        }
    }
}
