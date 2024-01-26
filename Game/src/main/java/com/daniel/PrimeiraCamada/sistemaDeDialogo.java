package com.daniel.PrimeiraCamada;

import com.daniel.PrimeiraCamada.Entidades.NPC;
import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

import java.util.stream.Collectors;

public class sistemaDeDialogo extends VBox {
    private ComboBox<String> opcoesdeAcaoComboBox;
    private TextArea areaDialogo;

    private NPC npcAtual;

    public sistemaDeDialogo(NPC npc) {
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
        areaDialogo.appendText(Player.getPlayer().getName() + ": " + escolhadoPlayer + "\n");
        areaDialogo.appendText(npcAtual.getName() + ": " + respostaNPC + "\n");
    }
}