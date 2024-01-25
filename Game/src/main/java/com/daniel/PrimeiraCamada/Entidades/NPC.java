package com.daniel.PrimeiraCamada.Entidades;

import com.daniel.game.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.Map;

public class NPC {
    private Map<String, ObservableList<String>> MapOpcoesNPC;

    private String name;

    public NPC(String name) {
        this.name = name;
        this.MapOpcoesNPC = new HashMap<>();
        setOpcoesPredefinidas();
    }

    private void setOpcoesPredefinidas() { // isso define as opções predefinidas baseado no npc
        switch (name) {
            case "Veio":
                MapOpcoesNPC.put(name, FXCollections.observableArrayList("Olá, veio!", "Me dê uma dica", "Tem dinheiro?"));
                break;

            default:
                MapOpcoesNPC.put(name, FXCollections.observableArrayList());
        }
    }

    public ObservableList<String> getOpcoesPredefinidas() {
        return MapOpcoesNPC.getOrDefault(name, FXCollections.observableArrayList());
    }

    public String gerarResposta(String escolhaPlayer) {
        System.out.println("Escolha do player: " + escolhaPlayer);

        String resposta;
        String escolhaEmUpperCase = escolhaPlayer.toUpperCase();
        System.out.println("Escolha em upperCase: " + escolhaEmUpperCase);


        ObservableList<String> opcoesNPC = getOpcoesPredefinidas();

        if (opcoesNPC == null) {
            System.out.println("Sem opções predefinidas para " + name);
            return "Resposta padrão";
        }

        switch (name) { // aqui você puxa as escolhas específicas de cada  NPC
            case "Veio":
                resposta = generateVeioResponse(escolhaEmUpperCase);
                break;
            default:
                resposta = "Resposta padrão";
        }

        System.out.println("Resposta gerada: " + resposta);
        return resposta;
    }

    private String generateVeioResponse(String userInput) { // aqui gera as respostas especificas do velho
        switch (userInput) {
            case "OLÁ, VEIO!":
                return "Olá! Bem vindo a " + Main.cidadeAtual.getNome();
            case "ME DÊ UMA DICA":
                return "Não viaje para locais difíceis no início";
            case "TEM DINHEIRO?":
                return "Sou aposentado";
            default:
                return "Resposta padrão do veio";
        }
    }

    public String getName() {
        return name;
    }
}
