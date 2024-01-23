package com.daniel.PrimeiraCamada.Magias;

import com.daniel.PrimeiraCamada.Interfaces.IEffects;
import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.PersonagemLuta;
import com.daniel.PrimeiraCamada.TiposElementais;
import com.daniel.SegundaCamada.AnimationsAttack;
import com.daniel.SegundaCamada.CuragaAnimation;
import com.daniel.SegundaCamada.FastAnimation;

public class Curaga extends Magia implements IEffects {
    public Curaga() {
        super("Sana multum", 30, 0, TiposElementais.NaoElemental,new CuragaAnimation(), false);
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        System.out.println("Alvo: " + alvo.getNome());
        alvo.RecuperarVida(500);
    }
}
