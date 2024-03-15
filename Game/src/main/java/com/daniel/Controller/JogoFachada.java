package com.daniel.Controller;

import com.daniel.Model.AudioPlayer;
import com.daniel.Model.BatalhaDeTurnos.GerenciadorDeBatalha;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Quests.Quest;
import com.daniel.Model.Dados.RepositorioTaverna.Mão;
import com.daniel.Model.Exceptions.*;
import com.daniel.Model.Itens.Item;

import java.util.List;

public class JogoFachada {
    private static JogoFachada instance = null;
    private ControleLoja controleLoja;
    private ControleCraft controleCraft;
    private ControlePoker controlePoker;
    private ControleServidor controleServidor;
    private ControlePlayerEquipaveis controlePlayerEquipaveis;
    private ControlePlayerXP controlePlayerXP;
    private ControlePlayerQuests controlePlayerQuests;
    private GerenciadorDeBatalha gerenciadorDeBatalha;
    private AudioPlayer audioPlayer;

    public JogoFachada()  {
        controleLoja = new ControleLoja(this);
        controleCraft = new ControleCraft();
        controlePoker = new ControlePoker();
        controleServidor = new ControleServidor();
        controlePlayerEquipaveis = new ControlePlayerEquipaveis();
        controlePlayerXP = new ControlePlayerXP();
        controlePlayerQuests = new ControlePlayerQuests(this);
        gerenciadorDeBatalha = new GerenciadorDeBatalha();
        audioPlayer = new AudioPlayer();
    }

    public static JogoFachada getInstance()  {
        if(JogoFachada.instance == null){
            JogoFachada.instance = new JogoFachada();
        }
        return instance;
    }

    public AudioPlayer getAudioPlayer() {
        return audioPlayer;
    }

    public void comprarItem(Item item) throws PlayerInexistenteException, RemoverCoinsException, CompraErroException, SemMoedasParaLojaException {
        controleLoja.comprarItem(item);
    }

    public void venderItem(Item item) throws PlayerInexistenteException {
        controleLoja.venderItem(item);
    }

    public Item criarBarraFerro(Item item, Item item2, double chance) {
        return controleCraft.criarBarraFerro(item, item2, chance);
    }

    public Item criarPocaoVidaGrande(Item item, Item item2, double chance) {
        return controleCraft.criarPocaoVidaGrande(item, item2, chance);
    }

    public Item criarPocaoManaGrande(Item item, Item item2, double chance) {
        return controleCraft.criarPocaoManaGrande(item, item2, chance);
    }

    public Item criarBarraEscuridao(Item item, Item item2, double chance) {
        return controleCraft.criarBarraEscuridao(item, item2, chance);
    }

    public Item criarBarraOuro(Item item, Item item2, double chance) {
        return controleCraft.criarBarraOuro(item, item2, chance);
    }

    public Item criarBarraFogo(Item item, Item item2, double chance) {
        return controleCraft.criarBarraFogo(item, item2, chance);
    }

    public Item criarBarraGelo(Item item, Item item2, double chance) {
        return controleCraft.criarBarraGelo(item, item2, chance);
    }

    public Item criarFerroAperfeicoado(Item item, Item item2, double chance) {
        return controleCraft.criarFerroAperfeicoado(item, item2, chance);
    }

    public Item criarEspadaAperfeicoada(Item item, Item item2, double chance) {
        return controleCraft.criarEspadaAperfeicoada(item, item2, chance);
    }

    public Item criarEspadaGeloAperfeicoada(Item item, Item item2, double chance) {
        return controleCraft.criarEspadaGeloAperfeicoada(item, item2, chance);
    }

    public Item criarEspadaEscuridaoAperfeicoada(Item item, Item item2, double chance) {
        return controleCraft.criarEspadaEscuridaoAperfeicoada(item, item2, chance);
    }

    public Item criarEspadaFogoAperfeicoada(Item item, Item item2, double chance) {
        return controleCraft.criarEspadaFogoAperfeicoada(item, item2, chance);
    }

    public Item criarEspadaEletricaAperfeicoada(Item item, Item item2, double chance) {
        return controleCraft.criarEspadaEletricaAperfeicoada(item, item2, chance);
    }

    public double getChanceBase() {
        return controleCraft.getChanceBase();
    }
    public  String avaliarMao(Mão mao, Mão centro){
        return controlePoker.avaliarMao(mao, centro);
    }

    public  int avaliarForcaMao(Mão mao, Mão centro) {
        return controlePoker.avaliarForcaMao(mao, centro);
    }

    public void ligarServidor(){
        controleServidor.ligarServidor();
    }
    public void desligarServidor(){
        controleServidor.desligarServidor();
    }
    public GerenciadorDeBatalha getGerenciadorDeBatalha(){
        return gerenciadorDeBatalha;
    }
    public void equiparItem(Item item) throws PlayerInexistenteException {
        controlePlayerEquipaveis.equipar(item);
    }
    public void desequiparItem(Item item) throws PlayerInexistenteException {
        controlePlayerEquipaveis.desequipar(item);
    }
    public boolean podeEquiparItem(Item item) throws PlayerInexistenteException {
        return controlePlayerEquipaveis.podeEquiparItem(item);
    }
    public void ganharXp(int xp) throws PlayerInexistenteException {
        controlePlayerXP.ganharXp(xp);
    }
    public void completarQuest(Quest quest) throws PlayerInexistenteException {
        controlePlayerQuests.completarQuest(quest);
    }
    public List<Quest> obterQuestsComuns() throws PlayerInexistenteException {
       return controlePlayerQuests.obterQuestsComuns();
    }
    public void ganhaPontos(int quantidade) throws PlayerInexistenteException { //metodo pra ganhar pontos de evoluçao do player
        Player.getPlayer().setPontos(Player.getPlayer().getPontos()+ quantidade);
    }
}