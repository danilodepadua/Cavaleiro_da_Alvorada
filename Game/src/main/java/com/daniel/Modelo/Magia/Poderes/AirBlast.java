package com.daniel.Modelo.Magia.Poderes;

import com.daniel.Dados.MagiasRepositório.AirBurstAnimation;
import com.daniel.Modelo.Magia.Magia;
import com.daniel.Modelo.Magia.TiposElementais;

public class AirBlast extends Magia {
    public AirBlast() {
        super("Magnus ventus", 20, 2, TiposElementais.Vento,new AirBurstAnimation(), true);
    }
}
