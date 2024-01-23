package com.daniel.PrimeiraCamada.Magias;

import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.TiposElementais;
import com.daniel.SegundaCamada.AnimationsAttack;
import com.daniel.SegundaCamada.ParedeTerraAnimation;
import com.daniel.SegundaCamada.TerraAnimation;

public class ParedeTerra extends Magia {
    public ParedeTerra() {
        super("Magnus lapis", 20, 2, TiposElementais.Terra,new ParedeTerraAnimation(), true);
    }
}
