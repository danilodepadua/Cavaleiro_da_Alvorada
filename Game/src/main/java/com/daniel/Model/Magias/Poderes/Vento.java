package com.daniel.Model.Magias.Poderes;

import com.daniel.Model.Magias.Animation.VentoAnimation;
import com.daniel.Model.Magias.Magia;
import com.daniel.Model.Magias.TiposElementais;

public class Vento extends Magia {
    public Vento() {
        super("Parum ventus", 10, 1, TiposElementais.Vento,new VentoAnimation(), true);
    }
}
