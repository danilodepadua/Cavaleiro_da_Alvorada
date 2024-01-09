package com.daniel.PrimeiraCamada.Magias;

import com.daniel.PrimeiraCamada.GerenciadorDeBatalha;
import com.daniel.PrimeiraCamada.Interfaces.IEffects;
import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.PersonagemLuta;
import com.daniel.PrimeiraCamada.TiposElementais;
import com.daniel.SegundaCamada.IceAnimation;

public class Gelo extends Magia implements IEffects {
    public Gelo() {
        super("Gelo",10, 1, TiposElementais.Gelo, new IceAnimation(), true);
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        alvo.aplicarStun();
        this.mensagem.add(alvo.getNome() + " foi stunado");
        System.out.println("Inimigo stunado");
    }
}