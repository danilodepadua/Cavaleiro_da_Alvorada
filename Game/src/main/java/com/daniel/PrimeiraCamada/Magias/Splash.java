package com.daniel.PrimeiraCamada.Magias;

import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.TiposElementais;
import com.daniel.SegundaCamada.AnimationsAttack;
import com.daniel.SegundaCamada.SplashAnimation;

public class Splash extends Magia {
    public Splash() {
        super("Parva aqua", 10, 1, TiposElementais.Gelo, new SplashAnimation(), true);
    }
}
