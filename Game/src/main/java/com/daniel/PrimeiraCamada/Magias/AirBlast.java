package com.daniel.PrimeiraCamada.Magias;

import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.TiposElementais;
import com.daniel.SegundaCamada.AirBurstAnimation;
import com.daniel.SegundaCamada.AnimationsAttack;
import com.daniel.SegundaCamada.StopAnimation;

public class AirBlast extends Magia {
    public AirBlast() {
        super("Magnus ventus", 20, 2, TiposElementais.Vento,new AirBurstAnimation(), true);
    }
}
