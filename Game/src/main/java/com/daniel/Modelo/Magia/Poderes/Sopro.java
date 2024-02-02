package com.daniel.Modelo.Magia.Poderes;

import com.daniel.Dados.MagiasRepositório.RajadaAnimation;
import com.daniel.Modelo.Magia.Magia;
import com.daniel.Modelo.Magia.TiposElementais;

public class Sopro extends Magia {
    public Sopro() {
        super("Ventus", 15, 1.5, TiposElementais.Vento,new RajadaAnimation(), true);
    }
}
