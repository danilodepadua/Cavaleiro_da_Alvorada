package com.daniel.PrimeiraCamada.Magias;

import com.daniel.PrimeiraCamada.Interfaces.IEffects;
import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.PersonagemLuta;
import com.daniel.PrimeiraCamada.TiposElementais;
import com.daniel.SegundaCamada.AnimationsAttack;
import com.daniel.SegundaCamada.FastAnimation;
import com.daniel.SegundaCamada.StopAnimation;

public class Fast extends Magia implements IEffects {
    public Fast() {
        super("Celer", 15, 0, TiposElementais.NaoElemental,new FastAnimation(), false);
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        System.out.println("Alvo: " + alvo.getNome());
        alvo.UpVel(10);
        this.mensagem.add(alvo.getNome() + " teve sua velocidade aumentada em 10");
    }
}