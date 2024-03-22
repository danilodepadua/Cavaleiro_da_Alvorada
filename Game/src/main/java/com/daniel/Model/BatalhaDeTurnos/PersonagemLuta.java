package com.daniel.Model.BatalhaDeTurnos;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Magias.AnimationsAttack;
import com.daniel.Model.Magias.Animacoes.SlashAnimation;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Magias.Magia;
import com.daniel.Model.Magias.TiposElementais;

import java.util.ArrayList;
import java.util.Random;

public class PersonagemLuta{

    protected String Nome;
    protected AnimationsAttack atqAnim;
    protected ArrayList<Magia> magias;
    protected boolean envenenado = false, dormindo= false, silenciado= false, cegado= false;
    protected int currentHp, currentMp, HP, MP, DefF, DefM, AtqM, AtqF, velocidade,sorte, stun = 0, regen = 0;
    public PersonagemLuta(Inimigo i){
        this.HP = i.getHP();
        this.MP = i.getMP();
        this.currentHp = HP;
        this.currentMp = MP;
        this.DefF = i.getResistencia();
        this.DefM = i.getInteligencia();
        this.AtqF = i.getForca();
        this.AtqM = i.getInteligencia();
        this.velocidade = i.getVelocidade();
        this.fraquezas = i.getFraquezas();
        this.resistencias = i.getResistencias();
        this.imunidades = i.getImunidades();
        this.absorcao = i.getAbsorcao();
        this.Nome = i.getNome();
        this.atqAnim = new SlashAnimation();
        this.magias = i.getMagias();
        this.sorte = i.getSorte();
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
        this.velocidade = p.getVelocidade();
        this.fraquezas = p.getFraquezas();
        this.resistencias = p.getResistencias();
        this.imunidades = p.getImundades();
        this.absorcao = p.getAbsorcoes();
        this.tipoAtaqueBase = p.getArma().getTipoDano();
        this.atqAnim = new SlashAnimation();
        this.Nome = p.getNome();
        this.magias = p.getMagias();
        this.sorte = p.getSorte();
    }
    protected TiposElementais[] fraquezas;
    protected TiposElementais[] resistencias;
    protected TiposElementais[] imunidades;
    protected TiposElementais[] absorcao;
    protected TiposElementais tipoAtaqueBase;

    public TextoNode tomarDano(int dano, TiposElementais tipo, boolean fisico){
        TextoNode mensagem = new TextoNode(this.Nome + " é imune a esse tipo de dano",this.Nome + " is immune to this type of damage");
        int danoTomado = 0;
        Random rand = new Random();
        dano = (int)(dano * rand.nextDouble(30, 40));
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
            if(danoTomado>9999){
                danoTomado = 9999;
            }
            this.currentHp -= danoTomado;
            mensagem = new TextoNode(this.Nome + " tomou " + danoTomado+" de dano",this.Nome + " took " + danoTomado+" of damage");
        }
        else if(temTipo(resistencias, tipo)){
            if(!fisico){
                danoTomado = (int) (dano/2 * Math.exp(-0.005*this.getDefM()));
            }
            else{
                danoTomado = (int) (dano/2 * Math.exp(-0.005*this.getDefF()));
            }
            if(danoTomado>9999){
                danoTomado = 9999;
            }
            if(danoTomado <0){
                danoTomado = 0;
                mensagem = new TextoNode(this.Nome + " não tomou dano tomou",this.Nome + " doesn't took damage");
            }
            else {
                mensagem = new TextoNode(this.Nome + " tomou " + danoTomado+" de dano",this.Nome + " took " + danoTomado+" of damage");
            }
            this.currentHp -= danoTomado;
        }
        else if(temTipo(absorcao, tipo)){
            danoTomado = -dano/2;
            if(danoTomado>9999){
                danoTomado = 9999;
            }
            this.currentHp -= danoTomado;
            mensagem = new TextoNode(this.Nome + " recuperou " + -danoTomado + " de vida",this.Nome + " recovered " + -danoTomado + " of hp");
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
            if(danoTomado>9999){
                danoTomado = 9999;
            }
            this.currentHp -= danoTomado;
            mensagem = new TextoNode(this.Nome + " tomou "+danoTomado+" de dano",this.Nome + " took " + danoTomado+" of damage");
        }
        return mensagem;
    }
    public int TomarDanoVerdadeiro(int dano){
        this.currentHp -= dano;
        return dano;
    }

    public TiposElementais[] getFraquezas() {
        return fraquezas;
    }

    public TiposElementais[] getResistencias() {
        return resistencias;
    }

    public TiposElementais[] getImunidades() {
        return imunidades;
    }

    public TiposElementais[] getAbsorcao() {
        return absorcao;
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
    public boolean getCegado(){
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
    public TextoNode TomarDanoVeneno(){
        this.currentHp -= this.HP/10;
        if(this.currentHp<=0){
            this.currentHp = 1;
        }
        return new TextoNode("Tomou dano por envenenamento","Took poison damage");
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
    public void UpSorte(int Up){
        this.sorte += Up;
    }
    public TextoNode Envenenar(){
        Random rand = new Random();
        int i = rand.nextInt(0,100);
        if(i > 50){
            this.envenenado = true;
            return new TextoNode(this.getNome()+" foi envenenado",this.getNome()+" was poisoned");
        }
        return new TextoNode(this.getNome()+" não foi envenenado",this.getNome()+" wasn't poisoned");
    }
    public TextoNode Desenvenenar(){
        this.envenenado = false;
        return new TextoNode(this.getNome()+" se recuperou do veneno",this.getNome()+" recovered from the poison");
    }
    public TextoNode Dormir(){
        Random rand = new Random();
        int i = rand.nextInt(0,100);
        if(i > 50){
            this.dormindo = true;
            return new TextoNode(this.getNome()+" caiu no sono",this.getNome()+" fell asleep");
        }
        return new TextoNode(this.getNome()+" não caiu no sono",this.getNome()+" didn't fell asleep");
    }
    public TextoNode Silenciar(){
        Random rand = new Random();
        int i = rand.nextInt(0,100);
        if(i > 50){
            this.silenciado = true;
            return new TextoNode(this.getNome()+" foi silenciado",this.getNome()+" has been silenced");
        }
        return new TextoNode(this.getNome()+" não foi silenciado",this.getNome()+" hasn't been silenced");
    }
    public TextoNode dessilenciar(){
        this.silenciado = false;
        return new TextoNode(this.getNome()+" voltou a falar",this.getNome()+" can speak again");
    }
    public TextoNode Cegar(){
        Random rand = new Random();
        int i = rand.nextInt(0,100);
        if(i > 50){
            this.cegado = true;
            return new TextoNode(this.getNome()+" foi cegado",this.getNome()+" has been blinded");
        }
        return new TextoNode(this.getNome()+" não foi cegado",this.getNome()+" hasn't been blinded");
    }
    public TextoNode descegar(){
        this.cegado = false;
        return new TextoNode(this.getNome()+" voltou a enchegar",this.getNome()+" can see again");
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
        if(stun>0) {
            Random rand = new Random();
            stun+= rand.nextInt(1,4);
        }
    }
    public void aplicarRegen(){
        regen+=5;
        if(regen>5){
            regen=5;
        }
    }
    public boolean fugir(int velC){
        Random rand = new Random();
        return !((velC+3) * rand.nextDouble(0.8, 1.2) > this.velocidade);
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
