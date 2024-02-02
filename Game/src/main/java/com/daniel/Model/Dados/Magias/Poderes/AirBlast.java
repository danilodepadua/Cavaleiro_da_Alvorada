package com.daniel.Model.Dados.Magias.Poderes;

import com.daniel.Model.Dados.Magias.Animation.AirBurstAnimation;
import com.daniel.Model.Dados.Magias.Magia;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class AirBlast extends Magia {
    public AirBlast() {
        super("Magnus ventus", 20, 2, TiposElementais.Vento,new AirBurstAnimation(), true);
    }
}
