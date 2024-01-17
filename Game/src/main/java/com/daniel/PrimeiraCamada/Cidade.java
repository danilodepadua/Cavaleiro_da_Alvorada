package com.daniel.PrimeiraCamada;

import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.game.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Cidade implements Serializable {
    protected String Fundo, FundoBatalha;
    protected String Nome;
    protected Inimigo[] inimigos;
    protected ArrayList<Quest> quests = new ArrayList<>(); // Usando ArrayList
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

    public ArrayList<Quest> getQuests() {
        return quests;
    }

    public String getNome() {
        return Nome;
    }
    public String getCaminhoImagem(){
        return Fundo;
    }

    protected Botao criarBotao(String nome, Runnable run){
        return new Botao(nome, run);
    }
    protected Botao criarBotaoSlavar() throws PlayerInexistenteException {
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
                Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaBatalha")).load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    protected Botao criarBotaoCassino(){
        return criarBotao("Cassino", () -> {
            try {
                Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCassino")).load());
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
