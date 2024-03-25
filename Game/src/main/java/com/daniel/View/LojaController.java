package com.daniel.View;

import com.daniel.Model.AudioPlayer;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextosInterface;
import com.daniel.Model.Exceptions.*;
import com.daniel.Model.Interfaces.IConsumableInBattle;
import com.daniel.Model.Interfaces.IConsumableOutBattle;
import com.daniel.Model.Itens.Arma;
import com.daniel.Model.Itens.Armadura;
import com.daniel.Model.Itens.Item;
import com.daniel.Model.Itens.Minerio;
import com.daniel.Controller.JogoFachada;
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

import static com.daniel.View.Utilidades.*;

public class LojaController implements Initializable {
    private Item itemSelecionado; //Armazenar item clicado
    @FXML
    private Tab Aba_Arm;

    @FXML
    private Tab Aba_Armas;

    @FXML
    private Tab Aba_Minerios;

    @FXML
    private Tab Aba_P;

    @FXML
    private Text Txt_Carteira;

    @FXML
    private Text Txt_Desc;

    @FXML
    private Text Txt_Nome;

    @FXML
    private Text Txt_Preco;

    @FXML
    private Text Txt_Venda;

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
    private GridPane gridMinerio;

    @FXML
    private GridPane gridPocoes;

    @FXML
    private AnchorPane panelImage;

    @FXML
    private TabPane tabPane;

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
    private JogoFachada jogoFachada;
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        Txt_Carteira.setText(TextosInterface.getCarteira());
        Txt_Desc.setText(TextosInterface.getDesc());
        Txt_Nome.setText(TextosInterface.getNome());
        Txt_Preco.setText(TextosInterface.getPreco());
        Txt_Venda.setText(TextosInterface.getVender()+":");
        Aba_Arm.setText(TextosInterface.getArmadura());
        Aba_Armas.setText(TextosInterface.getArmas()+"s");
        Aba_Minerios.setText(TextosInterface.getMinerio());
        Aba_P.setText(TextosInterface.getPocoes());
        jogoFachada = JogoFachada.getInstance();
        configurarBotoes(btnComprar);
        configurarBotoes(btnVender);
        btnComprar.setText(TextosInterface.getComprar());
        btnVender.setText(TextosInterface.getVender());
        contornarBotaoVoltarLoja(btnVoltar);
        try {
            txtSeuSaldo.setText(""+ Player.getPlayer().getCoins() + " Makkos");
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
                jogoFachada.venderItem(itemSelecionado);
                txtSeuSaldo.setText(""+Player.getPlayer().getCoins()+ " Makkos");
                configModoVenda();
                JogoFachada.getInstance().getAudioPlayer().PlayEfeito("/com.daniel.audios/som_moedas.wav");
                itemSelecionado = null;
            } catch (PlayerInexistenteException e) {
                throw new RuntimeException(e);
            }
        });
        btnComprar.setOnAction(event -> {
            try {
                jogoFachada.comprarItem(itemSelecionado);
                txtSeuSaldo.setText(""+Player.getPlayer().getCoins()+ " Makkos");
                JogoFachada.getInstance().getAudioPlayer().PlayEfeito("/com.daniel.audios/som_moedas.wav");
                if(Player.getPlayer().getCoins()<itemSelecionado.getPreco()){
                    btnComprar.setDisable(true);
                }
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
                if(Player.getPlayer().getCoins()<itemSelecionado.getPreco()){
                    btnComprar.setDisable(true);
                }
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
        txtSeuSaldo.setText(""+ Player.getPlayer().getCoins() + " Makkos" );
        txtInfoItem.setText("" + i.getDescricao());
        txtPreco.setText(i.getPreco() + " Makkos");
        itemSelecionado = i;
        txtVenda.setText((int)Math.floor(0.7 * i.getPreco()) + " Makkos");
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
