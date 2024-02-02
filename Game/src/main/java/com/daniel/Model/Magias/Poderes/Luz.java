package com.daniel.Model.Magias.Poderes;

import com.daniel.Model.Magias.Animation.HolyAnimation;
import com.daniel.Model.Magias.Magia;
import com.daniel.Model.Magias.TiposElementais;

public class Luz extends Magia {
    public Luz() {
        super("Lux",20, 1.5, TiposElementais.Luz, new HolyAnimation(), true);
    }
}
