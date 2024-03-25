package com.daniel.Model.Dados.Cidades;

import com.daniel.Controller.JogoFachada;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.AudioPlayer;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Dados.Textos.TextosInterface;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Itens.Item;
import com.daniel.Model.Quests.Quest;
import com.daniel.Model.BatalhaDeTurnos.TiposDeBatalha.BatalhaComum;
import com.daniel.game.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Cidade implements Serializable {
    public abstract void ajustarBotoes() throws PlayerInexistenteException;
    public void Atualizar() throws PlayerInexistenteException {
        botoes.clear();
        ajustarBotoes();
    }
    protected String Fundo, FundoBatalha;
    protected String Nome;
    protected Inimigo[] inimigos;
    protected ArrayList<Quest> quests = new ArrayList<>(); // Usando ArrayList
    protected ArrayList<Item> itens = new ArrayList<>();
    protected String dialogoCutscene;
    protected boolean dialogoAtivo;
    protected transient ArrayList<Botao> botoes = new ArrayList<>();
    protected String musicPath;
    public int CustoNaninha;
    protected Inimigo boss;
    public Cidade(String nome, String fundo, String fundoB, int Custo, Inimigo iniBoss) {
        this.Fundo = fundo;
        this.FundoBatalha = fundoB;
        this.Nome = nome;
        this.CustoNaninha = Custo;
        this.boss= iniBoss;
    }
    public Inimigo getBoss(){
        return boss;
    }
    public String getMusicPath(){
        return this.musicPath;
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
    protected Botao criarBotao(String nome, Runnable run){

        return new Botao(nome, run);
    }
    protected Botao criarBotaoSalvar() throws PlayerInexistenteException {
        return criarBotao(TextosInterface.getSalvar(), () -> {
            try {
                Main.saveManager.Salvar(Main.getSaveAtual());
            } catch (PlayerInexistenteException e) {
                throw new RuntimeException(e);
            }
        });
    }
    protected Botao criarBotaoEstalagem(){
        return criarBotao(TextosInterface.getTaverna(), () ->{
            try {
                Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaEstalagem.fxml")).load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    protected  Botao criarBotaoCacar(){
        return criarBotao(TextosInterface.getCacar(), () -> {
            try {
                JogoFachada.getInstance().getGerenciadorDeBatalha().Inicializar(new BatalhaComum());
            } catch (IOException | PlayerInexistenteException e) {
                throw new RuntimeException(e);
            }
        });
    }
    protected  Botao criarBotaoLoja(){
        return criarBotao(TextosInterface.getLoja(), () -> {
            try {
                Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaCompraOuVenda.fxml")).load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    protected  Botao criarBotaoQuest(){
        return criarBotao("Quests", () -> {
            try {
                Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaQuests.fxml")).load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    protected  Botao criarBotaoViajar(){
        return criarBotao(TextosInterface.getViajar(), () -> {
            try {
                Main.ChangeScene(new FXMLLoader(Main.class.getResource("TelaMapaDeViagem.fxml")).load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

