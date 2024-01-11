package com.daniel.PrimeiraCamada.Magias;

import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.TiposElementais;
import com.daniel.SegundaCamada.AnimationsAttack;
import com.daniel.SegundaCamada.WaterSpykeAnimation;

public class WaterSpyke extends Magia {
    public WaterSpyke() {
        super("Água2", 15, 1.5, TiposElementais.Gelo, new WaterSpykeAnimation(), true);
    }
}
