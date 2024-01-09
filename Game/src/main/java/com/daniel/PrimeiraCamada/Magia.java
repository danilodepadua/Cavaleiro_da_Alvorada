package com.daniel.PrimeiraCamada;

import com.daniel.PrimeiraCamada.Interfaces.IEffects;
import com.daniel.SegundaCamada.AnimationsAttack;
import javafx.scene.image.ImageView;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Magia implements Serializable {
    protected String nome;
    protected int custo;
    protected double multiplicador;
    protected TiposElementais tiposElementais;
    protected AnimationsAttack Animation;
    protected boolean agressivo, autoUsavel = true;
    protected ArrayList<String> mensagem = new ArrayList<>();

    public Magia(String nome, int custo, double multiplicador, TiposElementais tiposElementais, AnimationsAttack animation, boolean agre) {
        this.custo = custo;
        this.multiplicador = multiplicador;
        this.tiposElementais = tiposElementais;
        this.Animation = animation;
        this.agressivo = agre;
        this.nome = nome;
        if(agre){
            autoUsavel = false;
        }
        this.mensagem.add("Usou " + this.nome);
    }
    public void Conjurar(GerenciadorDeBatalha GB, PersonagemLuta c){
        this.mensagem.clear();
        ImageView img = GB.getAlvoView(this.autoUsavel);
        c.usarMp(this.custo);
        if(this instanceof IEffects){
            ((IEffects)this).aplicarEfeito(GB.getAlvo(this.autoUsavel));
        }
        if(this.agressivo){
            GB.Ataque(this.Animation.INICIAR(img), (int)(c.getAtqM()*multiplicador), this.tiposElementais, false, this.mensagem);
        }
        else{
            GB.acaoNaoAgreciva(this.Animation.INICIAR(img), this.mensagem);
        }
    }

    public TiposElementais getTiposDano() {
        return tiposElementais;
    }

    public AnimationsAttack getAnimation() {
        return Animation;
    }
    public int getCusto(){return custo;}
    public double getMultiplicador(){return multiplicador;}
    public boolean isAgressivo(){return agressivo;}

    public String getNome() {
        return nome;
    }
}
