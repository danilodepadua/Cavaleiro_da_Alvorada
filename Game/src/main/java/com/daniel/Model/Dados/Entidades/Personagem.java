package com.daniel.Model.Dados.Entidades;

import com.daniel.Model.Magias.Magia;
import com.daniel.game.Main;
import javafx.scene.image.Image;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Personagem implements Serializable {
    //classe inicial onde vão ser instanciados os atributos primoridades das entidades do jogo.
    protected ArrayList<Magia> magias = new ArrayList<>();
    protected int HP; //vida
    protected String ImagePath; //caminho da imagem
    protected int MP; //mana
    protected String nome;
    protected int forca; //força de ataque do player, quanto maior, mais dano
    protected int velocidade; //define quem vai iniciar o combate
    protected int inteligencia; //atributo pra aumentar os poderes magicos
    protected int resistencia; //atributo pra resistir a danos
    public Personagem(String Nome, String Imagem, int fr, int in, int rs, int vel){
        this.nome = Nome;
        this.ImagePath = Imagem;
        this.resistencia = rs;
        this.forca = fr;
        this.inteligencia = in;
        this.velocidade = vel;
        this.HP = this.resistencia *5;
        this.MP = this.inteligencia *5;
    }
    public int getHP() {
        return HP;
    }
    public int getMP() {
        return MP;
    }
    public String getNome() {
        return nome;
    }
    public int getForca() {
        return forca;
    }
    public int getVelocidade() {
        return velocidade;
    }
    public int getInteligencia() {
        return inteligencia;
    }
    public int getResistencia(){return resistencia;}
    public Image getImagem() {
        return new Image(Main.class.getResource(ImagePath).toString());
    }
    public ArrayList<Magia> getMagias() {
        return magias;
    }
    public void mudarHP(int hp){
        this.HP = hp;
    } //metodo personalizado pra mudar o hp do player
    public void mudarMP(int MP){
        this.MP = MP;
    } //analogo ao hp so que com a mana
    //metodos analogos ao hp e mana pra tela de evoluçao
    public void aumentaForcaProgress(int quantidade) {
        forca = quantidade;
    }
    public void aumentaInteligenciaProgess(int quantidade) {
        inteligencia = quantidade;
    }
    public void aumentaResistenciaProgress(int quantidade) {
        resistencia = quantidade;
    }
    public void aumentaVelocidadeProgress(int quantidade) {
        velocidade = quantidade;
    }
}