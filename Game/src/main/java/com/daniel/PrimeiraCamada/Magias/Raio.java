package com.daniel.PrimeiraCamada.Magias;

import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.TiposElementais;
import com.daniel.SegundaCamada.AnimationsAttack;
import com.daniel.SegundaCamada.RaioAnimation;

public class Raio extends Magia {
    public Raio() {
        super("Magnus radii", 20, 2, TiposElementais.Eletrico, new RaioAnimation(), true);
    }
}
