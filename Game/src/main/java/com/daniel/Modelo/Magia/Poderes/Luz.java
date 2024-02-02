package com.daniel.Modelo.Magia.Poderes;

import com.daniel.Dados.MagiasRepositório.HolyAnimation;
import com.daniel.Modelo.Magia.Magia;
import com.daniel.Modelo.Magia.TiposElementais;

public class Luz extends Magia {
    public Luz() {
        super("Lux",20, 1.5, TiposElementais.Luz, new HolyAnimation(), true);
    }
}
