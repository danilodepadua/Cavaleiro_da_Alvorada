package com.daniel.PrimeiraCamada.Magias;

import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.TiposElementais;
import com.daniel.SegundaCamada.AnimationsAttack;
import com.daniel.SegundaCamada.SlowAnimation;
import com.daniel.SegundaCamada.TerraAnimation;

public class Terra extends Magia {
    public Terra() {
        super("Lapillus", 10, 1, TiposElementais.Terra,new TerraAnimation(), true);
    }
}
