package com.daniel.PrimeiraCamada.Magias;

import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.TiposDano;
import com.daniel.SegundaCamada.DarkAnimation;

public class Escuridao extends Magia {
    public Escuridao() {
        super(20, 1.5, TiposDano.Escuridao, new DarkAnimation());
    }
}
