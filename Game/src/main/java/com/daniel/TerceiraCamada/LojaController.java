package com.daniel.TerceiraCamada;

import com.daniel.PrimeiraCamada.AudioPlayer;
import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.*;
import com.daniel.PrimeiraCamada.Interfaces.IConsumableInBattle;
import com.daniel.PrimeiraCamada.Interfaces.IConsumableOutBattle;
import com.daniel.PrimeiraCamada.Interfaces.IEquipable;
import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.Itens.Armadura;
import com.daniel.PrimeiraCamada.Itens.Item;
import com.daniel.PrimeiraCamada.Itens.Minerio;
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

import static com.daniel.TerceiraCamada.Utilidades.*;

public class LojaController implements Initializable {
    private Item itemSelecionado; //Armazenar item clicado

    @FXML
    private AnchorPane PanePrincipal;

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
    private ScrollPane scrollArmaduras;

    @FXML
    private ScrollPane scrollArmas;

    @FXML
    private ScrollPane scrollPocoes;

    @FXML
    private Tab tabArma;

    @FXML
    private Tab tabArmaduras;

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab tabPocoes;

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
    private boolean ativarVenda = false;
    private AudioPlayer audioPlayer = new AudioPlayer();
    private AudioPlayer somCompraVenda = new AudioPlayer();

    public void initialize(URL location, ResourceBundle resources) {
        configurarBotoes(btnComprar);
        configurarBotoes(btnVender);
        contornarBotaoVoltarLoja(btnVoltar);
        try {
            txtSeuSaldo.setText(""+ Player.getPlayer().getCoins() + " Moedas");
        } catch (PlayerInexistenteException e) {
            throw new RuntimeException(e);
        }
        definirBackground(panelImage, "/com.daniel.Images/Fundos/Veio Balconista.jpeg");
        btnVender.setOnAction(event -> {
            try {
                venderItem(itemSelecionado);
                somCompraVenda.play("/com.daniel.audios/som_moedas.wav", false);
                itemSelecionado = null;
            } catch (PlayerInexistenteException e) {
                throw new RuntimeException(e);
            }
        });
        btnComprar.setOnAction(event -> {
            try {
                comprarItem();
                somCompraVenda.play("/com.daniel.audios/som_moedas.wav", false);
            } catch (PlayerInexistenteException | RemoverCoinsException | CompraErroException |
                     SemMoedasParaLojaException e) {
                throw new RuntimeException(e);
            }
        });

        if (ativarCompra){
            modoCompra();
        }
    }

    private void desequiparItemSeEquipado(IEquipable equipableItem) throws PlayerInexistenteException {
        if (Player.getPlayer().getArma().equals(equipableItem)) {
            Player.getPlayer().desequiparArma();
        } else if (Player.getPlayer().getPeitoral().equals(equipableItem)) {
            Player.getPlayer().desequiparPeitoral();
        } else if (Player.getPlayer().getCapacete().equals(equipableItem)) {
            Player.getPlayer().desequiparCapacete();
        } else if (Player.getPlayer().getCalca().equals(equipableItem)) {
            Player.getPlayer().desequiparCalca();
        }
    }
    public void venderItem(Item item) throws PlayerInexistenteException {
        if (item instanceof IEquipable) {
            IEquipable equipableItem = (IEquipable) item;
            desequiparItemSeEquipado(equipableItem);
        }

        int precoItem = item.getPreco();
        Player.getPlayer().ganhaCoins(precoItem * 70 / 100);
        Player.getPlayer().getInventario().RemoverItem(item);
        configModoVenda();
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
    public void comprarItem() throws PlayerInexistenteException, RemoverCoinsException, CompraErroException, SemMoedasParaLojaException {
        if (Player.getPlayer() != null && itemSelecionado != null) {
            int precoItem = itemSelecionado.getPreco();
            if (Player.getPlayer().getCoins() >= precoItem) {
                // Realize a compra
                Player.getPlayer().removerCoins(precoItem, true);
                Player.getPlayer().getInventario().adicionarItem(itemSelecionado);

                // Atualiza as informações do item após a compra
                ItemSelecionado(itemSelecionado);

                System.out.println("Compra realizada com sucesso!");
                txtSeuSaldo.setText(""+ Player.getPlayer().getCoins() + " Moedas");
            } else {
                throw new SemMoedasParaLojaException();
            }
        } else {
            throw new CompraErroException();
        }
    }
    @FXML
    void onClickVoltar(ActionEvent event) throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCompraOuVenda.fxml")).load());
    }

    public void ItemSelecionado(Item i) throws PlayerInexistenteException {
        // Atualize o texto do nome do item
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
            ativarVenda = false;
            modoCompra();
        }
    }

    public void setAtivarVenda(boolean ativarVenda) throws PlayerInexistenteException {
        this.ativarVenda = ativarVenda;
        if (ativarVenda) {
            ativarCompra = false;
            configModoVenda();
        }
    }
}
