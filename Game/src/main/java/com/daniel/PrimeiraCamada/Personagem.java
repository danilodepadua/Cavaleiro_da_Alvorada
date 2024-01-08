package com.daniel.PrimeiraCamada;

import com.daniel.game.Main;
import javafx.scene.image.Image;

import java.io.Serializable;

public abstract class Personagem implements Serializable {

    public Personagem(String Nome, String Imagem, int fr, int in, int rs, int vel){
        this.Name = Nome;
        this.ImagePath = Imagem;
        this.Resistencia = rs;
        this.Force = fr;
        this.Inteligence = in;
        this.Velocity = vel;
        this.HP = this.Resistencia + 5;
        this.MP = this.Inteligence + 5;
    }
    protected int HP = 0;
    protected String ImagePath;
    protected int MP = 0;
    protected String Name = null;
    protected int Force = 0;
    protected int Velocity = 0;
    protected int Inteligence = 0;
    protected int Resistencia = 0;

    public int getHP() {
        return HP;
    }

    public int getMP() {
        return MP;
    }

    public String getName() {
        return Name;
    }

    public int getForce() {
        return Force;
    }

    public int getVelocity() {
        return Velocity;
    }
    public int getInteligence() {
        return Inteligence;
    }
    public int getResistencia(){return Resistencia;}
    public String getImageStr(){
        return ImagePath;
    }
    public Image getImagem() {
        return new Image(Main.class.getResource(ImagePath).toString());
    }

    public void aumentaForcaProgress(int quantidade) {
        Force = quantidade;
    }

    public void aumentaInteligenciaProgess(int quantidade) {
        Inteligence = quantidade;
    }

    public void aumentaResistenciaProgress(int quantidade) {
        Resistencia = quantidade;
    }

    public void aumentaVelocidadeProgress(int quantidade) {
        Velocity = quantidade;
    }
}