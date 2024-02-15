package com.daniel.Model.Magias.Poderes;

import com.daniel.Model.Magias.Animacoes.AirBurstAnimation;
import com.daniel.Model.Magias.Magia;
import com.daniel.Model.Magias.TiposElementais;

public class AirBlast extends Magia {
    public AirBlast() {
        super("Magnus ventus", 20, 2, TiposElementais.Vento,new AirBurstAnimation(), true);
    }
}
