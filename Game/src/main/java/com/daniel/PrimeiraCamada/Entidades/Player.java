package com.daniel.PrimeiraCamada.Entidades;

import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Exceptions.RemoverCoinsException;
import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Calca;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Calcas.CalcaFerro;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Capacete;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Capacetes.CapaceteFerro;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Peitorais.PeitoralFerro;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Peitoral;
import com.daniel.PrimeiraCamada.Itens.Armas.Espada;
import com.daniel.PrimeiraCamada.Personagem;
import com.daniel.PrimeiraCamada.Quests.Quests;
import com.daniel.SegundaCamada.Inventario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player extends Personagem implements Serializable {
    private Inventario inventario;
    private Arma arma;
    private int coins;
    private Peitoral peitoral;
    private Capacete capacete;
    private Calca calca;
    private static Player player;
    private List<Quests> questsAtuais;
    private int lvl;
    private int currentXp;
    private int currentMp, currentHp;
    private int pontos;
    private Player(String Img, int Force, int Int, String Name, int Velocity, int Res, int coins, int pontos){
        super(Name, Img, Force, Int, Res, Velocity);
        this.currentHp = this.getHP();
        this.currentMp = this.getMP();
        this.inventario = new Inventario();
        this.coins = coins;
        this.pontos = pontos;
        this.peitoral = new Peitoral();
        this.capacete = new Capacete();
        this.calca = new Calca();
        this.arma = new Arma();
        this.questsAtuais = new ArrayList<>();

        player = this;
    }
    public static Player CreatePlayer(String Img, int Force, int Int, String Name, int Velocity, int Res, int coins, int pontos){
        if(player != null){
            return player;
        }
        else{
            return new Player(Img, Force, Int, Name, Velocity, Res, coins, pontos);
        }
    }
    public Inventario getInventario() {
        return inventario;
    }
    public int getcHP(){
        return this.currentHp;
    }
    public int getcMp(){
        return this.currentMp;
    }
    public static Player getPlayer() throws PlayerInexistenteException {
        if(Player.player == null){
            throw new PlayerInexistenteException();
        }
        else {
            return player;
        }
    }
    public static void setPlayer(Player p){
        Player.player = p;
    }
    public int getCoins() {
        return coins;
    }
    public void removerCoins(int quantidade) throws RemoverCoinsException {
        if (quantidade <= 0 || this.coins < quantidade) {
            throw new RemoverCoinsException();
        }
        this.coins -= quantidade;
    }
    public void ganhaCoins(int quantidade) {
        this.coins += quantidade;
        System.out.println("Ganhou " + quantidade + " moedas. Novo saldo: " + this.coins);
    }
    public void equiparArma(Arma arma){
        desequiparArma();
        this.arma = arma;
        System.out.println("Arma equipada");
    }
    public void desequiparArma(){
        this.arma = new Arma();
        System.out.println("Arma desequipada");

    }
    public void equiparCalca(Calca calca){
        desequiparCalca();
        this.calca = calca;
        System.out.println("Calça equipada.");
    }
    public void desequiparCalca(){
        this.calca = new Calca();
        System.out.println("Calça desequipada");
    }
    public void equiparPeitoral(Peitoral peitoral) {
        desequiparPeitoral();
        this.peitoral = peitoral;
        System.out.println("Peitoral equipado.");
    }
    public void desequiparPeitoral() {
        this.peitoral = new Peitoral();
        System.out.println("Peitoral desequipado.");
    }
    public void equiparCapacete(Capacete capacete){
        desequiparCapacete();
        this.capacete = capacete;
        System.out.println("Capacete equipado.");
    }
    public void desequiparCapacete(){
        this.capacete = new Capacete();
        System.out.println("Capacete desequipado.");
    }
    public int getDefesaF(){
        return this.Resistencia + this.peitoral.getAumentoDefesaF() + this.capacete.getAumentoDefesaF() + this.calca.getAumentoDefesaF();
    }
    public int getDefesaM(){
        return this.Inteligence + this.peitoral.getAumentoDefesaM() + this.capacete.getAumentoDefesaM() + this.calca.getAumentoDefesaM();
    }
    public int getAtaqueF(){
        return Force + this.arma.getAumentoDeAtaqueFisico();
    }
    public int getAtaqueM(){
        return Inteligence;
    }
    public Peitoral getPeitoral() {
        return peitoral;
    }
    private boolean VereficarLevelUp(){
        int i = currentXp /1000*lvl;
        if(i>lvl){
            lvl = i;
            return true;
        }
        return false;
    }
    public boolean ganharXp(int xp){
        this.currentXp += xp;
        return this.VereficarLevelUp();
    }
    public int getXp() {
        return this.currentXp;
    }
    public void RecuperarVida(int i){
        this.currentHp += i;
        if(this.currentHp > this.HP){
            this.currentHp = this.HP;
        }
    }
    public void RecuperarMana(int i){
        this.currentMp += i;
        if(this.currentMp > this.MP){
            this.currentMp = this.MP;
        }
    }
    public Capacete getCapacete() {
        return capacete;
    }

    public Arma getArma() {
        return arma;
    }

    public Calca getCalca() {
        return calca;
    }

    public int getPontos() {
        return pontos;
    }
    public void ganhaPontos(int quantidade){
        this.pontos += quantidade;

    }
    public void aceitarQuest(Quests quests){
        questsAtuais.add(quests);
    }
    public void completarQuest(Quests quest) {
        if (questsAtuais.contains(quest)) {
            ganharXp(quest.getRecompensaXP());
            ganhaCoins(quest.getRecompensaMoedas());
            ganhaPontos(quest.getPontosEvolucao());
            System.out.println("Quest completada: " + quest.getNome());
            questsAtuais.remove(quest);

        }
    }

    public List<Quests> getQuestsAtuais() {
        return questsAtuais;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getLvl() {
        return lvl;
    }
}
