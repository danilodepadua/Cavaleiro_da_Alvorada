package com.daniel.TerceiraCamada;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Exceptions.RemoverCoinsException;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Calcas.CalcaMalha;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Calcas.CalcaPano;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Capacetes.CapaceteMalha;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Capacetes.CapacetePano;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Peitorais.PeitoralMalha;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Peitorais.PeitoralPano;
import com.daniel.PrimeiraCamada.Itens.Armas.*;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Calcas.CalcaCouro;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Calcas.CalcaFerro;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Capacetes.CapaceteCouro;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Capacetes.CapaceteFerro;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Peitorais.PeitoralCouro;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Peitorais.PeitoralFerro;
import com.daniel.PrimeiraCamada.Itens.Item;
import com.daniel.PrimeiraCamada.Itens.Pocoes.PocaoCura;
import com.daniel.PrimeiraCamada.Itens.Pocoes.PocaoMp;
import com.daniel.PrimeiraCamada.Itens.Pocoes.TonicoDeForca;
import com.daniel.PrimeiraCamada.Itens.Pocoes.TonicoDoHeroi;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

import static com.daniel.TerceiraCamada.Utilidades.*;

public class ControllerLoja implements Initializable {
    private Item itemSelecionado; //Armazenar item clicado

    @FXML
    private Button btnComprar;
    @FXML
    private ScrollPane scrollArmaduras;

    @FXML
    private ScrollPane scrollArmas;

    @FXML
    private ScrollPane scrollPocoes;
    @FXML
    private Button btnVoltar;

    @FXML
    private GridPane gridArmaduras;

    @FXML
    private GridPane gridArmas;

    @FXML
    private GridPane gridPocoes;
    @FXML
    private Text txtInfoItem;

    @FXML
    private Text txtNomeItem;

    @FXML
    private Text txtPreco;

    @FXML
    private Text txtSeuSaldo;
    @FXML
    private AnchorPane panelImage;
    @FXML
    private Tab tabArma;

    @FXML
    private Tab tabArmaduras;
    @FXML
    private Pane paneInfos;
    @FXML
    private Tab tabPocoes;
    @FXML
    private AnchorPane PanePrincipal;
    @FXML
    private TabPane tabPane;
    public void initialize(URL location, ResourceBundle resources) {

        configurarBotoes(btnComprar);
        contornarBotaoVoltar(btnVoltar);
        try {
            txtSeuSaldo.setText(""+ Player.getPlayer().getCoins() + " Moedas");
        } catch (PlayerInexistenteException e) {
            throw new RuntimeException(e);
        }
        definirBackground(panelImage, "/com.daniel.Images/Veio Balconista.jpeg");

        criarBotaoItem(new PocaoCura(), 0, 0, gridPocoes);
        criarBotaoItem(new PocaoMp(), 1, 0, gridPocoes);
        criarBotaoItem(new TonicoDeForca(), 2,0, gridPocoes);
        criarBotaoItem(new TonicoDoHeroi(),0,1, gridPocoes);

        criarBotaoItem(new CapacetePano(), 0, 0, gridArmaduras);
        criarBotaoItem(new PeitoralPano(), 1, 0, gridArmaduras);
        criarBotaoItem(new CalcaPano(), 2, 0 , gridArmaduras);

        criarBotaoItem(new CapaceteCouro(), 0, 1, gridArmaduras);
        criarBotaoItem(new PeitoralCouro(), 1, 1, gridArmaduras);
        criarBotaoItem(new CalcaCouro(), 2, 1, gridArmaduras);

        criarBotaoItem(new CapaceteMalha(), 0, 2, gridArmaduras);
        criarBotaoItem(new PeitoralMalha(), 1, 2, gridArmaduras);
        criarBotaoItem(new CalcaMalha(), 2, 2, gridArmaduras);

        criarBotaoItem(new CapaceteFerro(), 0, 3, gridArmaduras);
        criarBotaoItem(new PeitoralFerro(), 1, 3, gridArmaduras);
        criarBotaoItem(new CalcaFerro(), 2, 3, gridArmaduras);

        criarBotaoItem(new EspadaInicial(), 0 , 0, gridArmas);
        criarBotaoItem(new Cajado(), 1, 0, gridArmas);
        criarBotaoItem(new EspadaSombria(), 2, 0,gridArmas);
        criarBotaoItem(new EspadaLuz(), 0, 1, gridArmas);
        criarBotaoItem(new Katana(), 1, 1, gridArmas);
        criarBotaoItem(new Tridente(), 2, 1, gridArmas);



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


    @FXML
    void onClickComprar(ActionEvent event) throws PlayerInexistenteException, RemoverCoinsException {
        if (Player.getPlayer() != null && itemSelecionado != null) {
            int precoItem = itemSelecionado.getPreco();
            if (Player.getPlayer().getCoins() >= precoItem) {
                // Realize a compra
                Player.getPlayer().removerCoins(precoItem);
                Player.getPlayer().getInventario().adicionarItem(itemSelecionado);

                // Atualiza as informações do item após a compra
                ItemSelecionado(itemSelecionado);

                System.out.println("Compra realizada com sucesso!");
                txtSeuSaldo.setText(""+ Player.getPlayer().getCoins() + " Moedas");
            } else {
                System.out.println("Você não tem moedas suficientes para comprar este item.");
            }
        } else {
            System.out.println("Erro ao processar a compra. Certifique-se de que um jogador e um item estão selecionados.");
        }
    }

    @FXML
    void onClickVoltar(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCidade.fxml")));
    }

    public void ItemSelecionado(Item i) throws PlayerInexistenteException {
        // Atualize o texto do nome do item
        txtNomeItem.setText(""+i.getNome());
        txtSeuSaldo.setText(""+ Player.getPlayer().getCoins() + " Moedas" );
        txtInfoItem.setText("" + i.getDescricao());
        txtPreco.setText("" + i.getPreco() + " Moedas");
    }

}
