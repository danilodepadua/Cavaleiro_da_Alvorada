package com.daniel.Model.Dados.Magias.Poderes;

import com.daniel.Model.Dados.Magias.Animation.VentoAnimation;
import com.daniel.Model.Dados.Magias.Magia;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class Vento extends Magia {
    public Vento() {
        super("Parum ventus", 10, 1, TiposElementais.Vento,new VentoAnimation(), true);
    }
}
