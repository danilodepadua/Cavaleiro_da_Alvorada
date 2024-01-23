package com.daniel.PrimeiraCamada.Magias;

import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.TiposElementais;
import com.daniel.SegundaCamada.AirBurstAnimation;
import com.daniel.SegundaCamada.AnimationsAttack;
import com.daniel.SegundaCamada.RajadaAnimation;

public class Sopro extends Magia {
    public Sopro() {
        super("Ventus", 15, 1.5, TiposElementais.Vento,new RajadaAnimation(), true);
    }
}
