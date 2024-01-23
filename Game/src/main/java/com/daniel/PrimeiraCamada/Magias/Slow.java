package com.daniel.PrimeiraCamada.Magias;

import com.daniel.PrimeiraCamada.Interfaces.IEffects;
import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.PersonagemLuta;
import com.daniel.PrimeiraCamada.TiposElementais;
import com.daniel.SegundaCamada.AnimationsAttack;
import com.daniel.SegundaCamada.SlowAnimation;
import com.daniel.SegundaCamada.StopAnimation;

public class Slow extends Magia implements IEffects {
    public Slow() {
        super("Tardus", 15, 0, TiposElementais.NaoElemental,new SlowAnimation(), false);
        this.autoUsavel = false;
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        System.out.println("Alvo: " + alvo.getNome());
        alvo.UpVel(-10);
        this.mensagem.add(alvo.getNome() + " teve sua velocidade diminuida em 10");
    }
}
