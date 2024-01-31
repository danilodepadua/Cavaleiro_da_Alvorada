package com.daniel.PrimeiraCamada.Entidades;

import com.daniel.game.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class NPC {
    private Map<String, ObservableList<String>> MapOpcoesNPC;
    ObservableList<String> itens = FXCollections.observableArrayList();

    private String name;

    public NPC(String name) {
        this.name = name;
        this.MapOpcoesNPC = new HashMap<>();
        setOpcoesPredefinidas();
    }
    public void setMaisOpcao(String opcao) { // isso define as opções predefinidas baseado no npc
        switch (name) {
            case "Veio":
                itens.add(opcao);
                break;

            default:
                MapOpcoesNPC.put(name, FXCollections.observableArrayList());
        }
    }

    private void setOpcoesPredefinidas() { // isso permite adicionar coisas na lista do npc
        if (Objects.equals(name, "Veio")) {
            itens.add("Olá, veio!");
            itens.add("Me dê uma dica");
            itens.add("Tem dinheiro?");
            MapOpcoesNPC.put(name, itens);
        }
            if (Objects.equals(name, "Veiaco")) {
                itens.add("Você de novo?");
                MapOpcoesNPC.put(name, itens);
            }
        }


    public ObservableList<String> getOpcoesPredefinidas() {
        return MapOpcoesNPC.getOrDefault(name, FXCollections.observableArrayList());
    }

    public String gerarResposta(String escolhaPlayer) {
        System.out.println("Escolha do player: " + escolhaPlayer);


        String escolhaEmUpperCase = escolhaPlayer.toUpperCase();
        System.out.println("Escolha em upperCase: " + escolhaEmUpperCase);


        ObservableList<String> opcoesNPC = getOpcoesPredefinidas();

        if (opcoesNPC == null) {
            System.out.println("Sem opções predefinidas para " + name);
            return "Resposta padrão";
        }

        if (Objects.equals(name, "Veio")) { // aqui você puxa as escolhas específicas de cada  NPC
                String resposta = gerarRespostaVeio(escolhaEmUpperCase);
                System.out.println("Resposta gerada: " + resposta);
                return resposta;
        } else if (Objects.equals(name, "Veiaco")) {
                String resposta = gerarRespostaVeiaco(escolhaEmUpperCase);
                System.out.println("Resposta gerada: " + resposta);
            return resposta;
            } else {
            return "Resposta padrão";
        }
        }

    private String gerarRespostaVeio(String escolhaPlayer) { // aqui gera as respostas especificas do velho
        switch (escolhaPlayer) {
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
    private String gerarRespostaVeiaco(String escolhaPlayer) {
        switch (escolhaPlayer) {
            case "VOCÊ DE NOVO?":
                return "Aquele era meu irmão mais novo, eu sou mais sábio";
            default:
                return "resposta padrão do veiaco";
        }
    }

    public String getName() {
        return name;
    }
}
