package com.daniel.PrimeiraCamada.Magias;

import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.TiposElementais;
import com.daniel.SegundaCamada.AnimationsAttack;
import com.daniel.SegundaCamada.ExplosaoAnimation;

public class Explosao extends Magia {
    public Explosao() {
        super("Explosão", 15, 1.5, TiposElementais.Fogo, new ExplosaoAnimation(), true);
    }
}
