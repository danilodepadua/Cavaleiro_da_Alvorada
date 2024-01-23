package com.daniel.PrimeiraCamada.Magias;

import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.TiposElementais;
import com.daniel.SegundaCamada.AirBurstAnimation;
import com.daniel.SegundaCamada.AnimationsAttack;
import com.daniel.SegundaCamada.VentoAnimation;

public class Vento extends Magia {
    public Vento() {
        super("Parum ventus", 10, 1, TiposElementais.Vento,new VentoAnimation(), true);
    }
}
