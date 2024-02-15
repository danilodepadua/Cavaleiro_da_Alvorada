package com.daniel.Model.Dados.Entidades;

import com.daniel.Model.Dados.Cidades.Cidade;
import com.daniel.Model.Dados.Cidades.Vilas.Auroraville;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Exceptions.RemoverCoinsException;
import com.daniel.Model.Itens.Arma;
import com.daniel.Model.Itens.Armaduras.Calca;
import com.daniel.Model.Itens.Armaduras.Calcas.NullCalca;
import com.daniel.Model.Itens.Armaduras.Capacete;
import com.daniel.Model.Itens.Armaduras.Capacetes.NullCapacete;
import com.daniel.Model.Itens.Armaduras.Peitorais.NullPeitoral;
import com.daniel.Model.Itens.Armaduras.Peitoral;
import com.daniel.Model.Itens.Armas.*;
import com.daniel.Model.Itens.Minerios.*;
import com.daniel.Model.Magias.*;

import com.daniel.Model.Dados.Bestiario;
import com.daniel.Model.Dados.Inventario;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Quests.Quest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.daniel.Model.Quests.ManejarQuests.iniciarQuests;

public class Player extends Personagem implements Serializable {
    private Inventario inventario;
    private Arma arma;
    private int coins, xpProx;
    private Peitoral peitoral;
    private Capacete capacete;
    private Calca calca;
    private static Player player;
    private List<Quest> questAtuais;
    private ArrayList<Magia> magias;
    private int lvl = 1;
    private int currentXp;
    private int currentMp, currentHp;
    private int pontos;
    private ArrayList<Cidade> cidadesConehcidas = new ArrayList<>();
    private Bestiario bestiario = new Bestiario();
    private Player(String Img, int Force, int Int, String Name, int Velocity, int Res) throws PlayerInexistenteException {
        super(Name, Img, Force, Int, Res, Velocity);
        this.HP += 589;
        this.MP +=103;
        this.currentHp = this.getHP();
        this.currentMp = this.getMP();
        this.inventario = new Inventario();
        this.coins = 100;
        this.pontos = 0;
        this.xpProx = 1000;
        this.peitoral = new NullPeitoral();
        this.capacete = new NullCapacete();
        this.calca = new NullCalca();
        this.arma = new NullArma();
        this.questAtuais = iniciarQuests();
        this.magias = new ArrayList<>();
        this.magias.add(new Fogo());
        this.cidadesConehcidas.add(new Auroraville());
        this.inventario.adicionarItem(new Ferro());
        this.inventario.adicionarItem(new Ferro());
        this.inventario.adicionarItem(new Ferro());
        this.inventario.adicionarItem(new Ferro());
        this.inventario.adicionarItem(new FragmentoFogo());
        this.inventario.adicionarItem(new FragmentoFogo());
        this.inventario.adicionarItem(new FragmentoGlacial());
        this.inventario.adicionarItem(new FragmentoGlacial());
        this.inventario.adicionarItem(new FragmentoEscuridao());
        this.inventario.adicionarItem(new FragmentoEscuridao());
        this.inventario.adicionarItem(new Ouro());
        this.inventario.adicionarItem(new Ouro());
        this.inventario.adicionarItem(new EspadaEletricaBasica());
        this.inventario.adicionarItem(new EspadaFogoBasica());
        this.inventario.adicionarItem(new EspadaGeloBasica());
        this.inventario.adicionarItem(new EspadaSombriaBasica());
        player = this;
    }
    //Criar a instancia unica do player
    public static Player CreatePlayer(String Img, int Force, int Int, String Name, int Velocity, int Res) throws PlayerInexistenteException {
        if(player != null){
            return player;
        }
        else{
            return new Player(Img, Force, Int, Name, Velocity, Res);
        }
    }
    //get do player
    public static Player getPlayer() throws PlayerInexistenteException {
        if(Player.player == null){
            throw new PlayerInexistenteException();
        }else {
            return player;
        }
    }
    //metodo pra adicionar cidades ao array do player
    public void adicionarCidade(Cidade cidade) throws PlayerInexistenteException {
        for(Cidade c : Player.getPlayer().getCidadesConehcidas()){  //itera sobre o array de cidades do player
            if(Objects.equals(c.getNome(), cidade.getNome())){  //se tiver uma cidade igual não adiciona
                return;
            }
        }
        Player.getPlayer().getCidadesConehcidas().add(cidade);  //adiciona a cidade caso nao seja igual
    }
    public void RecuperarVida(int i){ //metodo pra recuperar a vida do player, serve pra poçoes e comidas
        this.currentHp += i;
        if(this.currentHp > this.HP){
            this.currentHp = this.HP;
        }
    }
    public void RecuperarMana(int i){  //metodo pra recuperar a mana do player, analogo ao recuperar vida
        this.currentMp += i;
        if(this.currentMp > this.MP){
            this.currentMp = this.MP;
        }
    }
    public String removerCoins(int quantidade) throws RemoverCoinsException, PlayerInexistenteException {
        int inicial = coins;   //metodo pra remover as moedas do player caso ele compra algo ou seja "roubado"
        if (quantidade <= 0 || coins < quantidade) {
            throw new RemoverCoinsException();
        }
        coins-= quantidade;  //reduz a quantidade atual de moedas
        return Integer.toString(inicial-coins);
    }
    public void ganharCoins(int quantidade) { //metodo pra ganhar moedas
        coins += quantidade;
    }

    public void AtualizarStatus(int vida, int mp){ //metodo pra atualizar a vida e a mana do player apos uma batalha.
        this.currentMp = mp;
        this.currentHp = vida;
    }

    public void setXpProx(int xpProx) {
        this.xpProx = xpProx;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setCurrentXp(int currentXp) {
        this.currentXp = currentXp;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }
    public void setPeitoral(Peitoral peitoral) {
        this.peitoral = peitoral;
    }
    public void setCapacete(Capacete capacete) {
        this.capacete = capacete;
    }
    public void setCalca(Calca calca) {
        this.calca = calca;
    }
    public Inventario getInventario() {
        return inventario;
    }
    public int getXpProx() {
        return xpProx;
    }

    public int getCurrentXp() {
        return currentXp;
    }
    public int getcHP(){
        return this.currentHp;
    }
    public int getcMp(){
        return this.currentMp;
    }
    public static void setPlayer(Player p){
        Player.player = p;
    }
    public int getCoins() {
        return coins;
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
    public Peitoral getPeitoral() {
        return peitoral;
    }
    public int getDefesaF(){
        return this.resistencia + this.peitoral.getAumentoDefesaF() + this.capacete.getAumentoDefesaF() + this.calca.getAumentoDefesaF();
    }
    public int getDefesaM(){
        return this.inteligencia + this.peitoral.getAumentoDefesaM() + this.capacete.getAumentoDefesaM() + this.calca.getAumentoDefesaM();
    }
    public Bestiario getBestiario(){
        return this.bestiario;
    }
    public int getAtaqueF(){
        return forca + this.arma.getAumentoDeAtaqueFisico();
    }
    public int getAtaqueM(){
        return inteligencia + this.arma.getAumentoDeAtaqueMagico();
    }
    public int getPontos() {
        return pontos;
    }
    public int getXp() {
        return this.currentXp;
    }
    public List<Quest> getQuestsAtuais() {
        return questAtuais;
    }
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
    public int getLvl() {
        return lvl;
    }
    public ArrayList<Magia> getMagias() {
        return magias;
    }
    public ArrayList<Cidade> getCidadesConehcidas(){return this.cidadesConehcidas;}
    public TiposElementais[] getFraquezas(){
        int tamanho = this.getPeitoral().getFraquezas().length + this.getCalca().getFraquezas().length + this.getCapacete().getFraquezas().length;
        TiposElementais[] tipos = new TiposElementais[tamanho];
        for (int i = 0; i < this.peitoral.getFraquezas().length; i++) {
            tipos[i] = this.peitoral.getFraquezas()[i];
        }

        for (int i = 0; i < this.getCalca().getFraquezas().length; i++) {
            tipos[i + this.peitoral.getFraquezas().length] = this.getCalca().getFraquezas()[i];
        }

        for (int i = 0; i < this.getCapacete().getFraquezas().length; i++) {
            tipos[i + this.peitoral.getFraquezas().length + this.getCalca().getFraquezas().length] = this.getCapacete().getFraquezas()[i];
        }
        return tipos;
    }
    public TiposElementais[] getResistencias(){
        int tamanho = this.getPeitoral().getResistencias().length + this.getCalca().getResistencias().length + this.getCapacete().getResistencias().length;
        TiposElementais[] tipos = new TiposElementais[tamanho];
        for (int i = 0; i < this.peitoral.getResistencias().length; i++) {
            tipos[i] = this.peitoral.getResistencias()[i];
        }

        for (int i = 0; i < this.getCalca().getResistencias().length; i++) {
            tipos[i + this.peitoral.getResistencias().length] = this.getCalca().getResistencias()[i];
        }

        for (int i = 0; i < this.getCapacete().getResistencias().length; i++) {
            tipos[i + this.peitoral.getResistencias().length + this.getCalca().getResistencias().length] = this.getCapacete().getResistencias()[i];
        }
        return tipos;
    }
    public TiposElementais[] getImundades(){
        int tamanho = this.getPeitoral().getImunidades().length + this.getCalca().getImunidades().length + this.getCapacete().getImunidades().length;
        TiposElementais[] tipos = new TiposElementais[tamanho];
        for (int i = 0; i < this.peitoral.getImunidades().length; i++) {
            tipos[i] = this.peitoral.getImunidades()[i];
        }

        for (int i = 0; i < this.getCalca().getImunidades().length; i++) {
            tipos[i + this.peitoral.getImunidades().length] = this.getCalca().getImunidades()[i];
        }

        for (int i = 0; i < this.getCapacete().getImunidades().length; i++) {
            tipos[i + this.peitoral.getImunidades().length + this.getCalca().getImunidades().length] = this.getCapacete().getImunidades()[i];
        }
        for(TiposElementais t :tipos){
            System.out.println("Imune: " + t.name());
        }
        return tipos;
    }
    public TiposElementais[] getAbsorcoes(){
        int tamanho = this.getPeitoral().getAbsorcao().length + this.getCalca().getAbsorcao().length + this.getCapacete().getAbsorcao().length;
        TiposElementais[] tipos = new TiposElementais[tamanho];
        for (int i = 0; i < this.peitoral.getAbsorcao().length; i++) {
            tipos[i] = this.peitoral.getAbsorcao()[i];
        }

        for (int i = 0; i < this.getCalca().getAbsorcao().length; i++) {
            tipos[i + this.peitoral.getAbsorcao().length] = this.getCalca().getAbsorcao()[i];
        }

        for (int i = 0; i < this.getCapacete().getAbsorcao().length; i++) {
            tipos[i + this.peitoral.getAbsorcao().length + this.getCalca().getAbsorcao().length] = this.getCapacete().getAbsorcao()[i];
        }
        return tipos;
    }
}
