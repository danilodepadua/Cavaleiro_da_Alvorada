package com.daniel.Modelo.Magia.Poderes;

import com.daniel.Dados.MagiasRepositório.VentoAnimation;
import com.daniel.Modelo.Magia.Magia;
import com.daniel.Modelo.Magia.TiposElementais;

public class Vento extends Magia {
    public Vento() {
        super("Parum ventus", 10, 1, TiposElementais.Vento,new VentoAnimation(), true);
    }
}
