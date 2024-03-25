package com.daniel.View;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.daniel.View.Utilidades.*;

public class RegrasPokerController implements Initializable {
    @FXML
    private Button btnProsseguir;
    @FXML
    private Text TxtRegras1;

    @FXML
    private Text TxtRegras2;
    @FXML
    private Button btnVoltar;
    @FXML
    private AnchorPane panePrincipal;

    @FXML
    void onClickContinuar(ActionEvent event) throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaPoker.fxml")).load());

    }
    @FXML
    void onClickVoltar(ActionEvent event) throws IOException {
        Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCassino.fxml")).load());

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TxtRegras1.setText(new TextoNode("O pôquer opera da seguinte maneira: cada jogador e a casa recebem inicialmente duas cartas, \n" +
                "e cabe a você decidir se deseja prosseguir ou desistir.\n" +
                " Para continuar, basta pressionar o botão \"Continuar\" localizado abaixo do botão de aposta.\n" +
                " Cada vez que o jogador opta por continuar, o valor da aposta é reiniciado, \n" +
                "permitindo aumentar a aposta inicial, pois o valor será acumulado.\n" +
                "\n" +
                "Regras do pôquer:\n" +
                "\n" +
                "Distribuição de Cartas: O jogador recebe duas cartas, e após decidir continuar, \n" +
                "três cartas comunitárias são adicionadas ao centro da mesa. A cada rodada subsequente, \n" +
                "uma carta adicional é incluída até um total de cinco cartas.\n" +
                "\n" +
                "Finalização da Rodada: Ao final de cada rodada, quem possuir a melhor mão ganha o jogo.\n" +
                "\n","Poker operates as follows: each player and the house are initially dealt two cards,\n" +
                "and it's up to you to decide whether you want to continue or give up.\n" +
                "  To continue, simply press the \"Continue\" button located below the bet button.\n" +
                "  Each time the player chooses to continue, the bet value is reset,\n" +
                "allowing you to increase the initial bet, as the value will be accumulated.\n" +
                "\n" +
                "Poker Rules:\n" +
                "\n" +
                "Card Deal: The player receives two cards, and after deciding to continue,\n" +
                "three community cards are added to the center of the table. With each subsequent round,\n" +
                "one additional card is included for a total of five cards.\n" +
                "\n" +
                "End of the Round: At the end of each round, whoever has the best hand wins the game.").getTexto());
        TxtRegras2.setText(new TextoNode("Tipos de Mãos:\n" +
                "One Pair (Par):\n" +
                "Descrição: O jogador forma um par com as cartas do centro.\n" +
                "Condição: Uma carta na mão do jogador faz par com uma do centro ou as duas cartas na mão são iguais.\n" +
                "Observação: Par refere-se a cartas do mesmo valor.\n" +
                "Two Pair (Dois Pares):\n" +
                "Descrição: O jogador forma dois pares com as cartas do centro.\n" +
                "Three of a Kind (Trinca):\n" +
                "Descrição: Três cartas do mesmo valor.\n" +
                "Straight (Sequência):\n" +
                "Descrição: O jogador forma uma sequência de cinco cartas consecutivas usando as cartas do centro.\n" +
                "Flush (Cores):\n" +
                "Descrição: Todas as cartas têm o mesmo naipe.\n" +
                "Full House (Full House):\n" +
                "Descrição: O jogador possui um par e uma trinca simultaneamente.\n" +
                "Condição: Uma carta na mão do jogador faz par com uma do centro, e as outras duas cartas da mão\n" +
                "formam uma trinca ou vice-versa.\n" +
                "Four of a Kind (Quadra):\n" +
                "Descrição: O jogador possui quatro cartas do mesmo valor.\n" +
                "Condição: Duas cartas na mão do jogador são iguais, e há mais duas cartas do mesmo valor no centro.\n" +
                "Straight Flush (Sequência de Cores):\n" +
                "Descrição: O jogador forma uma sequência de cinco cartas consecutivas do mesmo naipe.\n" +
                "Condição: As cartas na mão do jogador e as do centro formam uma sequência e têm o mesmo naipe.\n" +
                "Royal Flush (Sequência Real):\n" +
                "Descrição: O jogador possui as cartas 10, Valete, Dama, Rei e Ás do mesmo naipe.\n" +
                "Condição: As cartas na mão do jogador mais as do centro tem que formar uma sequência de 10, valete,\n" +
                "Dama, Rei e Ás do mesmo naipe.","Hand Types:\n" +
                "One Pair:\n" +
                "Description: The player forms a pair with the cards in the center.\n" +
                "Condition: A card in the player's hand is paired with one in the center or the two cards in the hand are the same.\n" +
                "Note: Pair refers to cards of the same value.\n" +
                "Two Pair:\n" +
                "Description: The player forms two pairs with the cards in the center.\n" +
                "Three of a Kind (Trinca):\n" +
                "Description: Three cards of the same value.\n" +
                "Straight (Sequence):\n" +
                "Description: The player forms a sequence of five consecutive cards using the center cards.\n" +
                "Flush (Colors):\n" +
                "Description: All cards have the same suit.\n" +
                "Full House:\n" +
                "Description: The player has a pair and three of a kind simultaneously.\n" +
                "Condition: A card in the player's hand pairs with one in the center, and the other two cards in the hand\n" +
                "form a crack or vice versa.\n" +
                "Four of a Kind (Quadra):\n" +
                "Description: The player has four cards of the same value.\n" +
                "Condition: Two cards in the player's hand are the same, and there are two more cards of the same value in the center.\n" +
                "Straight Flush (Color Sequence):\n" +
                "Description: The player forms a sequence of five consecutive cards of the same suit.\n" +
                "Condition: The cards in the player's hand and those in the center form a sequence and have the same suit.\n" +
                "Royal Flush:\n" +
                "Description: The player has the cards 10, Jack, Queen, King and Ace of the same suit.\n" +
                "Condition: The cards in the player's hand plus those in the center must form a sequence of 10, jack,\n" +
                "Queen, King and Ace of the same suit.").getTexto());
        definirBackground(panePrincipal, "/com.daniel.Images/Cartas/MesaTaverna.jpeg");
        Utilidades.identificarTextos(panePrincipal);
        contornarBotaoVoltar(btnVoltar);
        configurarBotoes(btnProsseguir);
    }
}
