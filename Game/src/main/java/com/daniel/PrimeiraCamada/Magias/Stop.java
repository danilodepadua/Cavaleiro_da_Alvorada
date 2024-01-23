package com.daniel.PrimeiraCamada.Magias;

import com.daniel.PrimeiraCamada.Interfaces.IEffects;
import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.PersonagemLuta;
import com.daniel.PrimeiraCamada.TiposElementais;
import com.daniel.SegundaCamada.AnimationsAttack;
import com.daniel.SegundaCamada.StopAnimation;

public class Stop extends Magia implements IEffects {
    public Stop() {
        super("Prohibere", 15, 0, TiposElementais.NaoElemental,new StopAnimation(), false);
        this.autoUsavel = false;
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        System.out.println("Alvo: " + alvo.getNome());
        alvo.aplicarStun();
        this.mensagem.add(alvo.getNome() + " foi paralizado");
    }
}
