package com.daniel.View;

import com.daniel.Model.Dados.Entidades.NPC;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

import java.util.stream.Collectors;

public class SistemaDeDialogo extends VBox {
    private ComboBox<String> opcoesdeAcaoComboBox;
    private TextArea areaDialogo;

    private NPC npcAtual;

    public SistemaDeDialogo(NPC npc) {
        npcAtual = npc;

        ObservableList<String> opcoesdeAcao = FXCollections.observableArrayList( // cria a lista de opções de ação
                npcAtual.getOpcoesPredefinidas().stream() // adiciona as opções do npc
                        .map(String::toLowerCase)
                        .collect(Collectors.toList())
        );
        opcoesdeAcaoComboBox = new ComboBox<>(opcoesdeAcao); // cria o combobox
        opcoesdeAcaoComboBox.setPromptText("Escolha sua ação");

        areaDialogo = new TextArea(); // cria o textarea
        areaDialogo.setEditable(false);

        opcoesdeAcaoComboBox.setStyle("-fx-background-color: #ffffff; -fx-border-color: #eccb7e; -fx-font-size: 17; -fx-font-family: 'Barlow Condensed SemiBold';");
        areaDialogo.setStyle("-fx-background-color: #241811; -fx-text-fill: #000000; -fx-border-color: #eccb7e; -fx-font-size: 17; -fx-font-family: 'Barlow Condensed SemiBold';");

        opcoesdeAcaoComboBox.setOnAction(event -> {
            try {
                handleEscolhaDoPlayer();
            } catch (PlayerInexistenteException e) {
                throw new RuntimeException(e);
            }
        });

        getChildren().addAll(opcoesdeAcaoComboBox, areaDialogo); // adiciona o combobox e a area de dialogo
    }

    private void handleEscolhaDoPlayer() throws PlayerInexistenteException { // pega a opção selecionada do combobox
        String opcaoEscolhida = opcoesdeAcaoComboBox.getSelectionModel().getSelectedItem();
        if (opcaoEscolhida != null) {
            responderPlayer(opcaoEscolhida);
        }
    }

    private void responderPlayer(String escolhadoPlayer) throws PlayerInexistenteException { // pega a resposta do npc baseado na escolha do player
        String respostaNPC = npcAtual.gerarResposta(escolhadoPlayer.toLowerCase());
        areaDialogo.appendText(Player.getPlayer().getNome() + ": " + escolhadoPlayer + "\n");
        areaDialogo.appendText(npcAtual.getName() + ": " + respostaNPC + "\n");
    }
}