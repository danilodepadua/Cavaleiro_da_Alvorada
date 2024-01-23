package com.daniel.PrimeiraCamada.Magias;

import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.TiposElementais;
import com.daniel.SegundaCamada.AnimationsAttack;
import com.daniel.SegundaCamada.RedemoinhoAnimation;

public class Redemoinho extends Magia {
    public Redemoinho() {
        super("Magna aqua", 20, 2, TiposElementais.Gelo, new RedemoinhoAnimation(), true);
    }
}
