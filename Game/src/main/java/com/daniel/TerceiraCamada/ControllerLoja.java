package com.daniel.TerceiraCamada;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Exceptions.RemoverCoinsException;
import com.daniel.PrimeiraCamada.Itens.Armas.Espada;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Calcas.CalcaCouro;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Calcas.CalcaFerro;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Capacetes.CapaceteCouro;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Capacetes.CapaceteFerro;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Peitorais.PeitoralCouro;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Peitorais.PeitoralFerro;
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
    private Text txtSeuSaldo;
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
        try {
            txtSeuSaldo.setText(""+ Player.getPlayer().getCoins() + " Moedas");
        } catch (PlayerInexistenteException e) {
            throw new RuntimeException(e);
        }

        criarBotaoItem(new PocaoCura(), 0, 0);
        criarBotaoItem(new PocaoMp(), 1, 0);
        criarBotaoItem(new CapaceteCouro(), 0, 1);
        criarBotaoItem(new CapaceteFerro(), 1, 1 );
        criarBotaoItem(new PeitoralCouro(), 0, 2);
        criarBotaoItem(new PeitoralFerro(), 1, 2);
        criarBotaoItem(new CalcaCouro(), 0, 3);
        criarBotaoItem(new CalcaFerro(), 1, 3);
        criarBotaoItem(new Espada(), 0 , 4);

    }

    private void criarBotaoItem(Item item, int columnIndex, int rowIndex) {
        int columns = grid.getColumnConstraints().size();
        int rows = grid.getRowConstraints().size();

        Button button = new Button();
        ImageView imageView = new ImageView();
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(110);
        imageView.setFitHeight(60);

        double cellWidth = grid.getPrefWidth() / columns;
        double cellHeight = grid.getPrefHeight() / rows;

        button.setGraphic(imageView);
        button.setPrefSize(cellWidth, cellHeight);
        grid.add(button, columnIndex, rowIndex);

        button.setMaxSize(cellWidth, cellHeight);

        imageView.setImage(item.getImage());

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
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("InitialCity.fxml")));
    }

    public void ItemSelecionado(Item i) throws PlayerInexistenteException {
        // Atualize o texto do nome do item
        txtNomeItem.setText("Nome: "+i.getNome());
        txtSeuSaldo.setText(""+ Player.getPlayer().getCoins() + " Moedas" );
        // Verifica o tipo de item antes de fazer o cast
        if (i instanceof PocaoCura) {
            PocaoCura pocaoCura = (PocaoCura) i;
            // Restante do código para poção de cura
            txtInfoItem.setText("Descrição: " + pocaoCura.getDescricao());
            txtPreco.setText("Preço: " + pocaoCura.getPreco() + " Moedas");
        } else if (i instanceof PocaoMp) {
            PocaoMp pocaoMp = (PocaoMp) i;
            // Restante do código para poção de MP
            txtInfoItem.setText("Descrição: " + pocaoMp.getDescricao());
            txtPreco.setText("Preço: " + pocaoMp.getPreco() + " Moedas");
        } else if (i instanceof PeitoralCouro) {
            PeitoralCouro peitoralCouro = (PeitoralCouro) i;
            txtInfoItem.setText("Descrição: " + peitoralCouro.getDescricao());
            txtPreco.setText("Preço: " + peitoralCouro.getPreco() + " Moedas");
        } else if (i instanceof PeitoralFerro) {
            PeitoralFerro peitoralFerro = (PeitoralFerro) i;
            txtInfoItem.setText("Descrição: " + peitoralFerro.getDescricao());
            txtPreco.setText("Preço: " + peitoralFerro.getPreco() + " Moedas");
        } else if (i instanceof CapaceteFerro) {
            CapaceteFerro capaceteFerro = (CapaceteFerro) i;
            txtInfoItem.setText("Descrição: " + capaceteFerro.getDescricao());
            txtPreco.setText("Preço: " + capaceteFerro.getPreco() + " Moedas");
        } else if (i instanceof CapaceteCouro) {
            CapaceteCouro capaceteCouro = (CapaceteCouro) i;
            txtInfoItem.setText("Descrição: " + capaceteCouro.getDescricao());
            txtPreco.setText("Preço: " + capaceteCouro.getPreco() + " Moedas");
        } else if (i instanceof CalcaCouro) {
            CalcaCouro calcaCouro = (CalcaCouro) i;
            txtInfoItem.setText("Descrição: " + calcaCouro.getDescricao());
            txtPreco.setText("Preço: " + calcaCouro.getPreco() + " Moedas");
        } else if (i instanceof CalcaFerro) {
            CalcaFerro calcaFerro = (CalcaFerro) i;
            txtInfoItem.setText("Descrição: " + calcaFerro.getDescricao());
            txtPreco.setText("Preço: " + calcaFerro.getPreco() + " Moedas");
        } else if (i instanceof Espada) {
            Espada espada = (Espada) i;
            txtInfoItem.setText("Descrição: " + espada.getDescricao());
            txtPreco.setText("Preço: " + espada.getPreco() + " Moedas");
        } else {
            txtInfoItem.setText("Descrição: N/A");
            txtPreco.setText("Preço: N/A");
        }
        PainelInfos.setDisable(false);
        PainelInfos.setOpacity(1);
    }
}
