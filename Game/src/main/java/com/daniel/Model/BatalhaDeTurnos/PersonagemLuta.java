package com.daniel.Model.BatalhaDeTurnos;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Magias.Animation.AnimationsAttack;
import com.daniel.Model.Magias.Animation.SlashAnimation;
import com.daniel.Model.Dados.Entidades.Inimigo;
import com.daniel.Model.Magias.Magia;
import com.daniel.Model.Magias.TiposElementais;

import java.util.ArrayList;
import java.util.Random;

public class PersonagemLuta{

    protected String Nome;
    protected AnimationsAttack atqAnim;
    protected ArrayList<Magia> magias;
    protected boolean envenenado = false, dormindo= false, silenciado= false, cegado= false;
    protected int currentHp, currentMp, HP, MP, DefF, DefM, AtqM, AtqF, velocidade, stun = 0;
    public PersonagemLuta(Inimigo i){
        this.HP = i.getHP();
        this.MP = i.getMP();
        this.currentHp = HP;
        this.currentMp = MP;
        this.DefF = i.getResistencia();
        this.DefM = i.getInteligence();
        this.AtqF = i.getForce();
        this.AtqM = i.getInteligence();
        this.velocidade = i.getVelocity();
        this.fraquezas = i.getFraquezas();
        this.resistencias = i.getResistencias();
        this.imunidades = i.getImunidades();
        this.absorcao = i.getAbsorcao();
        this.Nome = i.getName();
        this.atqAnim = new SlashAnimation();
        this.magias = i.getMagias();
    }

    public PersonagemLuta(Player p){
        this.DefF = p.getDefesaF();
        this.DefM = p.getDefesaM();
        this.AtqM = p.getAtaqueM();
        this.AtqF = p.getAtaqueF();
        this.HP = p.getHP();
        this.MP = p.getMP();
        this.currentHp = p.getcHP();
        this.currentMp = p.getcMp();
        this.velocidade = p.getVelocity();
        this.fraquezas = p.getFraquezas();
        this.resistencias = p.getResistencias();
        this.imunidades = p.getImundades();
        this.absorcao = p.getAbsorcoes();
        this.tipoAtaqueBase = p.getArma().getTipoDano();
        this.atqAnim = new SlashAnimation();
        this.Nome = p.getName();
        this.magias = p.getMagias();
    }
    protected TiposElementais[] fraquezas;
    protected TiposElementais[] resistencias;
    protected TiposElementais[] imunidades;
    protected TiposElementais[] absorcao;
    protected TiposElementais tipoAtaqueBase;

    public String tomarDano(int dano, TiposElementais tipo, boolean fisico){
        String mensagem = this.Nome + " é imune a esse tipo de dano";;
        int danoTomado = 0;
        Random rand = new Random();
        dano = (int)(dano * rand.nextDouble(4.8, 5.2));
        System.out.println("Dano: " + dano);
        this.dormindo = false;
        if(temTipo(fraquezas, tipo)){
            if(!fisico){
                danoTomado = (int)(dano*2 * Math.exp(-0.005*this.getDefM()));
            }
            else{
                danoTomado = (int) (dano*2 * Math.exp(-0.005*this.getDefF()));
            }
            if(danoTomado <0){
                danoTomado = 0;
            }
            this.currentHp -= danoTomado;
            mensagem = this.Nome + " tomou " + danoTomado;
        }
        else if(temTipo(resistencias, tipo)){
            if(!fisico){
                danoTomado = (int) (dano/2 * Math.exp(-0.005*this.getDefM()));
            }
            else{
                danoTomado = (int) (dano/2 * Math.exp(-0.005*this.getDefF()));
            }
            if(danoTomado <0){
                danoTomado = 0;
                mensagem = this.Nome + " não tomou dano tomou ";
            }
            else {
                mensagem = this.Nome + " tomou " + danoTomado;
            }
            this.currentHp -= danoTomado;
        }
        else if(temTipo(absorcao, tipo)){
            danoTomado = -dano/2;
            this.currentHp -= danoTomado;
            mensagem = this.Nome + " recuperou " + -danoTomado + " de vida";
        }
        else if(!temTipo(imunidades, tipo)){
            if(!fisico){
                danoTomado = (int) (dano * Math.exp(-0.005*this.getDefM()));
            }
            else{
                danoTomado = (int) (dano * Math.exp(-0.005*this.getDefF()));
            }
            if(danoTomado <0){
                danoTomado = 0;
            }
            this.currentHp -= danoTomado;
            mensagem = this.Nome + " tomou "+danoTomado+" de dano";
        }
        return mensagem;
    }
    public int TomarDanoVerdadeiro(int dano){
        this.currentHp -= dano;
        return dano;
    }
    public boolean usarMp(int i){
        if(this.currentMp >= i && !silenciado){
            this.currentMp -= i;
            return true;
        }
        else{
            return false;
        }
    }
    public boolean getEnvenenado(){
        return envenenado;
    }
    public boolean setCegado(){
        return cegado;
    }
    public boolean getSilenciado(){
        return silenciado;
    }
    public boolean temTipo(TiposElementais[] tipos, TiposElementais tipo){
        for(TiposElementais T : tipos){
            if(T == tipo){
                return true;
            }
        }
        return false;
    }
    public String TomarDanoVeneno(){
        this.currentHp -= this.HP/10;
        if(this.currentHp<=0){
            this.currentHp = 1;
        }
        return "Tomou dano por envenenamento";
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public int getCurrentMp() {
        return currentMp;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public int getDefF() {
        return DefF;
    }

    public int getDefM() {
        return DefM;
    }

    public int getAtqM() {
        return AtqM;
    }

    public int getAtqF() {
        return AtqF;
    }

    public AnimationsAttack getAtqAnim() {
        return atqAnim;
    }

    public ArrayList<Magia> getMagias() {
        return magias;
    }

    public int getHP() {
        return HP;
    }

    public int getMP() {
        return MP;
    }

    public TiposElementais getTipoAtaqueBase() {
        return tipoAtaqueBase;
    }

    public String getNome() {
        return Nome;
    }

    public void UpForca(int Up){
        this.AtqF += Up;
    }
    public void UpInt(int Up){
        this.AtqM += Up;
        this.DefM += Up;
    }
    public void UpVel(int Up){
        this.velocidade += Up;
    }
    public void UpRes(int Up){
        this.DefF += Up;
    }
    public String Envenenar(){
        Random rand = new Random();
        int i = rand.nextInt(0,100);
        if(i > 50){
            this.envenenado = true;
            return this.getNome()+" foi envenenado";
        }
        return this.getNome()+" não foi envenenado";
    }
    public String Desenvenenar(){
        this.envenenado = false;
        return this.getNome()+" se recuperou";
    }
    public String Dormir(){
        Random rand = new Random();
        int i = rand.nextInt(0,100);
        if(i > 50){
            this.dormindo = true;
            return this.getNome()+" caiu no sono";
        }
        return this.getNome()+" não caiu no sono";
    }
    public String Silenciar(){
        Random rand = new Random();
        int i = rand.nextInt(0,100);
        if(i > 50){
            this.silenciado = true;
            return this.getNome()+" foi silenciado";
        }
        return this.getNome()+" não foi silenciado";
    }
    public String dessilenciar(){
        this.silenciado = false;
        return this.getNome()+" voltou a falar";
    }
    public String Cegar(){
        Random rand = new Random();
        int i = rand.nextInt(0,100);
        if(i > 50){
            this.cegado = true;
            return this.getNome()+" foi cegado";
        }
        return this.getNome()+" não foi cegado";
    }
    public String descegar(){
        this.cegado = false;
        return this.getNome()+" voltou a enchegar";
    }
    public void RecuperarMana(int i) {
        this.currentMp += i;
        if(currentMp > MP){
            currentMp = MP;
        }
    }
    public void RecuperarVida(int i){
        this.currentHp += i;
        if(this.currentHp > this.HP){
            this.currentHp = this.HP;
        }
    }
    public void aplicarStun(){
        stun++;
    }
    public boolean fugir(int velC){
        Random rand = new Random();
        return !(velC * rand.nextDouble(0.5, 1.5) > this.velocidade);
    }

    public void setFraquezas(TiposElementais[] fraquezas) {
        this.fraquezas = fraquezas;
    }

    public void setResistencias(TiposElementais[] resistencias) {
        this.resistencias = resistencias;
    }

    public void setImunidades(TiposElementais[] imunidades) {
        this.imunidades = imunidades;
    }

    public void setAbsorcao(TiposElementais[] absorcao) {
        this.absorcao = absorcao;
    }
}
