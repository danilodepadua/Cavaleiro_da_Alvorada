package com.daniel.PrimeiraCamada.Entidades;

import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Itens.*;
import com.daniel.PrimeiraCamada.Itens.Armaduras.nullPeitoral;
import com.daniel.PrimeiraCamada.Personagem;
import com.daniel.SegundaCamada.Inventario;

import java.io.Serializable;

public class Player extends Personagem implements Serializable {
    public Inventario inventario;
    private int coins;
    private Peitoral peitoral;
    private static Player player;
    private int lvl;
    private int currentXp;
    private int currentMp, currentHp;
    private Player(String Img, int Force, int Int, String Name, int Velocity, int Res, int coins){
        super(Name, Img, Force, Int, Res, Velocity);
        this.currentHp = this.getHP();
        this.currentMp = this.getMP();
        this.inventario = new Inventario();
        this.coins = coins;
        this.peitoral = new nullPeitoral(); // Inicialmente sem peitoral equipado
        player = this;
    }

    public static Player CreatePlayer(String Img, int Force, int Int, String Name, int Velocity, int Res, int coins){
        if(player != null){
            return player;
        }
        else{
            return new Player(Img, Force, Int, Name, Velocity, Res, coins);
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
    public void removerCoins(int quantidade) {
        if (quantidade > 0 && this.coins >= quantidade) {
            this.coins -= quantidade;
        } else {
            System.out.println("Quantidade inválida ou moedas insuficientes.");
        }
    }
    public void equiparPeitoral(Peitoral peitoral) {
        if (this.peitoral == null) {
            this.peitoral = peitoral;
        } else {
            System.out.println("Você já está usando um peitoral. Desequipa o atual antes de equipar outro.");
        }
    }
    public void desequiparPeitoral() {
        if (this.peitoral != null) {
            this.peitoral = null;
        } else {
            System.out.println("Você não está usando nenhum peitoral para desequipar.");
        }
    }
    public int getDefesaF(){
        return this.Resistencia + this.peitoral.getAumentoDefesaF();
    }
    public int getDefesaM(){
        return this.Inteligence + this.peitoral.getAumentoDefesaM();
    }
    public int getAtaqueF(){
        return Force;
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
}
