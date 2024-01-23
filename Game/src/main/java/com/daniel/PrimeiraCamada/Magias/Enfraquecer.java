package com.daniel.PrimeiraCamada.Magias;

import com.daniel.PrimeiraCamada.Interfaces.IEffects;
import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.PersonagemLuta;
import com.daniel.PrimeiraCamada.TiposElementais;
import com.daniel.SegundaCamada.DebufAnimation;

public class Enfraquecer extends Magia implements IEffects {
    public Enfraquecer() {
        super("Debilitare", 20,0, TiposElementais.NaoElemental, new DebufAnimation(), false);
        this.autoUsavel = false;
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        System.out.println("Alvo: " + alvo.getNome());
        alvo.UpForca(-10);
        this.mensagem.add(alvo.getNome() + " teve sua força diminuida em 10");
    }
}
