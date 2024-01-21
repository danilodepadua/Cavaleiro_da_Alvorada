package com.daniel.PrimeiraCamada.Entidades;

import com.daniel.PrimeiraCamada.*;
import com.daniel.PrimeiraCamada.Cidades.CidadeInicial;
import com.daniel.PrimeiraCamada.Cidades.CidadeMorta;
import com.daniel.PrimeiraCamada.Cidades.MontanhaDoNorte;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Exceptions.RemoverCoinsException;
import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Calca;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Capacete;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Peitoral;
import com.daniel.PrimeiraCamada.Magias.*;
import com.daniel.PrimeiraCamada.Quests.*;

import com.daniel.SegundaCamada.Bestiario;
import com.daniel.SegundaCamada.Inventario;
import com.daniel.game.Main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.daniel.PrimeiraCamada.Quests.ManejarQuests.iniciarQuests;

public class Player extends Personagem implements Serializable {
    private Inventario inventario;
    private Arma arma;
    private int coins;
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
    private Player(String Img, int Force, int Int, String Name, int Velocity, int Res, int coins, int pontos) throws PlayerInexistenteException {
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
        this.questAtuais = iniciarQuests();
        this.magias = new ArrayList<>();
        this.magias.add(new Fogo());
        this.cidadesConehcidas.add(new CidadeInicial());
        this.cidadesConehcidas.add(new MontanhaDoNorte());
        this.cidadesConehcidas.add(new CidadeMorta());
        player = this;
    }
    public static Player CreatePlayer(String Img, int Force, int Int, String Name, int Velocity, int Res, int coins, int pontos) throws PlayerInexistenteException {
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
    public Bestiario getBestiario(){
        return this.bestiario;
    }
    public int getAtaqueF(){
        return Force + this.arma.getAumentoDeAtaqueFisico();
    }
    public int getAtaqueM(){
        return Inteligence + this.arma.getAumentoDeAtaqueMagico();
    }

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
    public Peitoral getPeitoral() {
        return peitoral;
    }
    private boolean VereficarLevelUp(){
        int i = 1+(currentXp /1000*lvl);
        if(i>lvl){
            lvl = i;
            aprenderMagia();
            return true;
        }
        return false;
    }
    public boolean ganharXp(int xp){
        this.currentXp += xp;
        return this.VereficarLevelUp();
    }

    private void aprenderMagia(){
        switch (lvl){
            case 2:
                magias.add(new Gelo());
                break;
            case 3:
                magias.add(new Luz());
                break;
            case 4:
                magias.add(new Escuridao());
                break;
            case 5:
                magias.add(new Redemoinho());
                break;
            case 6:
                magias.add(new WaterSpyke());
            default:
                break;
        }
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
    public void completarQuest(Quest quest) {
        if (questAtuais.contains(quest)) {
            ganharXp(quest.getRecompensaXP());
            ganhaCoins(quest.getRecompensaMoedas());
            ganhaPontos(quest.getPontosEvolucao());
            System.out.println("Quest completada: " + quest.getNome());
            System.out.println("Ganho de xp: "+ quest.getRecompensaXP());
            System.out.println("Xp do player: "+ currentXp);
            System.out.println(VereficarLevelUp());
            questAtuais.remove(quest);
        }
    }

    public List<Quest> obterQuestsComuns() {
        List<Quest> questComuns = Main.cidadeAtual.getQuests();
        List<Quest> questsComuns = new ArrayList<>();

        for (Quest questJogador : getQuestsAtuais()) {
            boolean questComum = questComuns.stream().anyMatch(questCidade -> questJogador.getNome().equals(questCidade.getNome()));

            if (questComum) {
                questsComuns.add(questJogador);  // Adiciona a quest comum à lista
            }
        }

        return new ArrayList<>(questsComuns);  // Retorna uma nova lista contendo as quests comuns
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
    public void adicionarCidade(Cidade cidade){
        for(Cidade c : cidadesConehcidas){
            if(Objects.equals(c.getNome(), cidade.getNome())){
                return;
            }
            cidadesConehcidas.add(cidade);
        }
    }
}
