package com.daniel.PrimeiraCamada;

import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Itens.Item;
import com.daniel.game.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Cidade implements Serializable {
    public abstract void ajustarBotoes() throws PlayerInexistenteException;
    protected String Fundo, FundoBatalha;
    protected String Nome;
    protected Inimigo[] inimigos;
    protected ArrayList<Quest> quests = new ArrayList<>(); // Usando ArrayList
    protected ArrayList<Item> itens = new ArrayList<>();
    protected String  dialogoCutscene;
    protected boolean dialogoAtivo;
    protected transient ArrayList<Botao> botoes = new ArrayList<>();
    public Cidade(String nome, String fundo, String fundoB) {
        this.Fundo = fundo;
        this.FundoBatalha = fundoB;
        this.Nome = nome;
    }

    public Image getFundo() {
        return new Image(Main.class.getResource(Fundo).toString());
    }

    public Image getFundoBatalha() {
        return new Image(Main.class.getResource(FundoBatalha).toString());
    }

    public Inimigo[] getInimigos() {
        return inimigos;
    }

    public String getDialogoCutscene() {
        return dialogoCutscene;
    }

    public ArrayList<Quest> getQuests() {
        return quests;
    }

    public String getNome() {
        return Nome;
    }
    public String getCaminhoImagem(){
        return Fundo;
    }

    public ArrayList<Botao> getBotoes(){return  this.botoes;}

    public boolean isDialogoAtivo() {
        return dialogoAtivo;
    }

    public void mudarDialogo(boolean dialogoAtivo) {
        this.dialogoAtivo = dialogoAtivo;
    }

    public String getBotaoNome(int pos){
        return this.getBotoes().get(pos).getNome();
    }
    public Runnable getBotaoFunc(int pos){
        return  this.getBotoes().get(pos).getFunc();
    }
    public ArrayList<Item> getItens(){
        return this.itens;
    }
    public ArrayList<Item> getRandomItens() {
        if (!itens.isEmpty()) {
            Collections.shuffle(itens);
            return new ArrayList<>(itens.subList(0, Math.min(3, itens.size())));
        } else {
            return new ArrayList<>();
        }
    }
    protected Botao criarBotao(String nome, Runnable run){

        return new Botao(nome, run);
    }
    protected Botao criarBotaoSalvar() throws PlayerInexistenteException {
        return criarBotao("Salvar", () -> {
            try {
                Main.saveManager.Salvar();
            } catch (PlayerInexistenteException e) {
                throw new RuntimeException(e);
            }
        });
    }
    protected  Botao criarBotaoCacar(){
        return criarBotao("Caçar", () -> {
            try {
                Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaBatalha.fxml")).load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    protected  Botao criarBotaoLoja(){
        return criarBotao("Loja", () -> {
            try {
                Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaLoja.fxml")).load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    protected  Botao criarBotaoQuest(){
        return criarBotao("Quest", () -> {
            try {
                Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaQuests.fxml")).load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    protected  Botao criarBotaoViajar(){
        return criarBotao("Viajar", () -> {
            try {
                Main.ChangeScene(new FXMLLoader(Main.class.getResource("MapaDeViagem.fxml")).load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    protected Botao criarBotaoTaverna(){
        return criarBotao("Taverna", () -> {
            try {
                Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCassino.fxml")).load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

class Botao{
    private String nome;
    private Runnable func;

    public Botao(String nome, Runnable func) {
        this.nome = nome;
        this.func = func;
    }

    public String getNome() {
        return nome;
    }

    public Runnable getFunc() {
        return func;
    }


}
