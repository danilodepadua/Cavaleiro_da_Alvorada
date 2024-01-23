package com.daniel.PrimeiraCamada.Magias;

import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.TiposElementais;
import com.daniel.SegundaCamada.AnimationsAttack;
import com.daniel.SegundaCamada.BolaRaioAnimation;

public class ThunderBall extends Magia {
    public ThunderBall() {
        super("Parvum radii", 10, 1, TiposElementais.Eletrico, new BolaRaioAnimation(), true);
    }
}
