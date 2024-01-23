package com.daniel.PrimeiraCamada;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.SegundaCamada.AnimationsAttack;
import com.daniel.SegundaCamada.SlashAnimation;

import java.util.ArrayList;
import java.util.Random;

public class PersonagemLuta{

    protected String Nome;
    protected AnimationsAttack atqAnim;
    protected ArrayList<Magia> magias;

    protected boolean envenenado = false, dormindo= false, silenciado= false, cegado= false;
    protected int currentHp, currentMp, HP, MP, DefF, DefM, AtqM, AtqF, velocidade, stun = 0;
    protected int xpDrop;

    protected int moedas;
    public PersonagemLuta(Inimigo i){
        this.HP = i.HP;
        this.MP = i.MP;
        this.currentHp = HP;
        this.currentMp = MP;
        this.DefF = i.getDefesaF();
        this.DefM = i.getDefesaM();
        this.AtqF = i.getAtaqueF();
        this.AtqM = i.getAtaqueM();
        this.velocidade = i.getVelocity();
        this.fraquezas = i.fraquezas;
        this.resistencias = i.resistencias;
        this.imunidades = i.imunidades;
        this.absorcao = i.absorcao;
        this.Nome = i.getName();
        this.atqAnim = new SlashAnimation();
        this.magias = i.magias;
        this.xpDrop = i.getDropXp();
        this.moedas = i.getMoedas();
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
        this.fraquezas = new TiposElementais[0];
        this.resistencias = new TiposElementais[0];
        this.imunidades = new TiposElementais[0];
        this.absorcao = new TiposElementais[0];
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

    public int tomarDano(int dano, TiposElementais tipo, boolean fisico){
        int danoTomado = 0;
        this.dormindo = false;
        if(temTipo(fraquezas, tipo)){
            if(!fisico){
                danoTomado = dano*2 - this.getDefM();
                if(danoTomado <0){
                    danoTomado = 0;
                }
                this.currentHp -= danoTomado;
            }
            else{
                danoTomado = dano*2 - this.getDefF();
                if(danoTomado <0){
                    danoTomado = 0;
                }
                this.currentHp -= danoTomado;
            }
        }
        else if(temTipo(resistencias, tipo)){
            if(!fisico){
                danoTomado = dano/2 - this.getDefM();
                if(danoTomado <0){
                    danoTomado = 0;
                }
                this.currentHp -= danoTomado;
            }
            else{
                danoTomado = dano/2 - this.getDefF();
                if(danoTomado <0){
                    danoTomado = 0;
                }
                this.currentHp -= danoTomado;
            }
        }
        else if(temTipo(absorcao, tipo)){
            danoTomado = -dano/2;
            this.currentHp -= danoTomado;
        }
        else if(!temTipo(imunidades, tipo)){
            if(!fisico){
                danoTomado = dano - this.getDefM();
                if(danoTomado <0){
                    danoTomado = 0;
                }
                this.currentHp -= danoTomado;
            }
            else{
                danoTomado = dano - this.getDefF();
                if(danoTomado <0){
                    danoTomado = 0;
                }
                this.currentHp -= danoTomado;
            }
        }
        return danoTomado;
    }
    public void usarMp(int i){
        this.currentMp -= i;
        if(this.currentMp <0){
            this.currentMp = 0;
        }
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

    public int getXpDrop() {
        return xpDrop;
    }

    public int getMoedas() {return moedas;}

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

    public void reduzirDefesaMagica(int diminuicao) {
        DefM -= diminuicao;
        if (DefM < 0) {
            DefM = 0;
        }
    }

    public void aplicarStun(){
        stun++;
    }
    public boolean fugir(int velC){
        Random rand = new Random();
        return !(velC * rand.nextDouble(0.5, 1.5) > this.velocidade);
    }
}
