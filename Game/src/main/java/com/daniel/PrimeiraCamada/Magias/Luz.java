package com.daniel.PrimeiraCamada.Magias;

import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.TiposDano;
import com.daniel.SegundaCamada.HolyAnimation;

public class Luz extends Magia {
    public Luz() {
        super(20, 1.5, TiposDano.Luz, new HolyAnimation());
    }
}
