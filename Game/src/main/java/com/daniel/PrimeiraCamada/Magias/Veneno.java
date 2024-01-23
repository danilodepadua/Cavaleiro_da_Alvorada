package com.daniel.PrimeiraCamada.Magias;

import com.daniel.PrimeiraCamada.Interfaces.IEffects;
import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.PersonagemLuta;
import com.daniel.PrimeiraCamada.TiposElementais;
import com.daniel.SegundaCamada.AnimationsAttack;
import com.daniel.SegundaCamada.TerraAnimation;
import com.daniel.SegundaCamada.VenenoAnimation;

public class Veneno extends Magia implements IEffects {
    public Veneno() {
        super("Venenum", 15, 1.5, TiposElementais.NaoElemental,new VenenoAnimation(), true);
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        System.out.println("Alvo: " + alvo.getNome());
        this.mensagem.add(alvo.Envenenar());
    }
}
