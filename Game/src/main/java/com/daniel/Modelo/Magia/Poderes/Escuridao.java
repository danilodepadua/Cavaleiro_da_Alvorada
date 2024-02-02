package com.daniel.Modelo.Magia.Poderes;

import com.daniel.Dados.MagiasRepositório.DarkAnimation;
import com.daniel.Modelo.Magia.Magia;
import com.daniel.Modelo.Magia.TiposElementais;

public class Escuridao extends Magia {
    public Escuridao() {
        super("Tenebris",20, 1.5, TiposElementais.Escuridao, new DarkAnimation(), true);
    }
}
