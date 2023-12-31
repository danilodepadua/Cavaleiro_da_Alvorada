package com.daniel.TerceiraCamada;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Itens.Armaduras.ArmaduraCouro;
import com.daniel.PrimeiraCamada.Itens.Armaduras.ArmaduraFerro;
import com.daniel.PrimeiraCamada.Itens.Item;
import com.daniel.PrimeiraCamada.Itens.Pocoes.PocaoCura;
import com.daniel.PrimeiraCamada.Itens.Pocoes.PocaoMp;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerLoja implements Initializable {
    private Item itemSelecionado; //Armazenar item clicado

    @FXML
    private AnchorPane PainelCima;

    @FXML
    private AnchorPane PainelInfos;
    @FXML
    private SplitPane SplitTela;

    @FXML
    private Button btnComprar;

    @FXML
    private Button btnVoltar;

    @FXML
    private GridPane grid;

    @FXML
    private ImageView imgBalconista;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private Text txtInfoItem;

    @FXML
    private Text txtNomeItem;

    @FXML
    private Text txtPreco;

    public void initialize(URL location, ResourceBundle resources) {
        // Criar botão para PocaoCura na coluna 0, linha 0
        criarBotaoItem(new PocaoCura(), 0, 0);

        // Criar botão para PocaoMp na coluna 1, linha 0
        criarBotaoItem(new PocaoMp(), 1, 0);

        criarBotaoItem(new ArmaduraCouro(), 0, 1);

        criarBotaoItem(new ArmaduraFerro(), 1, 1 );
    }

    private void criarBotaoItem(Item item, int columnIndex, int rowIndex) {
        int columns = grid.getColumnConstraints().size();
        int rows = grid.getRowConstraints().size();

        Button button = new Button();
        ImageView imageView = new ImageView();
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(120);
        imageView.setFitHeight(80);

        double cellWidth = grid.getPrefWidth() / columns;
        double cellHeight = grid.getPrefHeight() / rows;

        button.setGraphic(imageView);
        button.setPrefSize(cellWidth, cellHeight);
        grid.add(button, columnIndex, rowIndex);

        button.setMaxSize(cellWidth, cellHeight);

        imageView.setImage(item.getImage());

        button.setOnAction(event -> {
            ItemSelecionado(item); // Chama o método ItemSelecionado com o item clicado
            itemSelecionado = item; // Configura o itemSelecionado com o item clicado
        });
    }


    @FXML
    void onClickComprar(ActionEvent event) throws PlayerInexistenteException {
        if (Player.getPlayer() != null && itemSelecionado != null) {
            int precoItem = itemSelecionado.getPreco();
            if (Player.getPlayer().getCoins() >= precoItem) {
                // Realize a compra
                Player.getPlayer().removerCoins(precoItem);
                Player.getPlayer().getInventario().adicionarItem(itemSelecionado);

                // Atualiza as informações do item após a compra
                ItemSelecionado(itemSelecionado);

                System.out.println("Compra realizada com sucesso!");
            } else {
                System.out.println("Você não tem moedas suficientes para comprar este item.");
            }
        } else {
            System.out.println("Erro ao processar a compra. Certifique-se de que um jogador e um item estão selecionados.");
        }
    }

    @FXML
    void onClickVoltar(ActionEvent event) {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("InitialCity.fxml")));
    }

    public void ItemSelecionado(Item i){
        // Atualize o texto do nome do item
        txtNomeItem.setText("Nome: "+i.getNome());

        // Verifica o tipo de item antes de fazer o cast
        if (i instanceof PocaoCura) {
            PocaoCura pocaoCura = (PocaoCura) i;
            // Restante do código para poção de cura
            txtInfoItem.setText("Descrição: " + pocaoCura.getDescricao());
            txtPreco.setText("Preço: " + pocaoCura.getPreco() + " BitCoins");
        } else if (i instanceof PocaoMp) {
            PocaoMp pocaoMp = (PocaoMp) i;
            // Restante do código para poção de MP
            txtInfoItem.setText("Descrição: " + pocaoMp.getDescricao());
            txtPreco.setText("Preço: " + pocaoMp.getPreco() + " BitCoins");
        } else if (i instanceof ArmaduraCouro) {
            ArmaduraCouro armaduraCouro = (ArmaduraCouro) i;
            txtInfoItem.setText("Descrição: " + armaduraCouro.getDescricao());
            txtPreco.setText("Preço: " + armaduraCouro.getPreco() + " BitCoins");
        } else if (i instanceof ArmaduraFerro) {
            ArmaduraFerro armaduraFerro = (ArmaduraFerro) i;
            txtInfoItem.setText("Descrição: " + armaduraFerro.getDescricao());
            txtPreco.setText("Preço: " + armaduraFerro.getPreco() + " BitCoins");
        } else {
            txtInfoItem.setText("Descrição: N/A");
            txtPreco.setText("Preço: N/A");
        }
        PainelInfos.setDisable(false);
        PainelInfos.setOpacity(1);
    }
}
