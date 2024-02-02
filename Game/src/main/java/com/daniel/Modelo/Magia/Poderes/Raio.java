package com.daniel.Modelo.Magia.Poderes;

import com.daniel.Dados.MagiasRepositório.RaioAnimation;
import com.daniel.Modelo.Magia.Magia;
import com.daniel.Modelo.Magia.TiposElementais;

public class Raio extends Magia {
    public Raio() {
        super("Magnus radii", 20, 2, TiposElementais.Eletrico, new RaioAnimation(), true);
    }
}
