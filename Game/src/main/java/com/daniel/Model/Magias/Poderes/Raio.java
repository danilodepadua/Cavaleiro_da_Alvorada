package com.daniel.Model.Magias.Poderes;

import com.daniel.Model.Magias.Animation.RaioAnimation;
import com.daniel.Model.Magias.Magia;
import com.daniel.Model.Magias.TiposElementais;

public class Raio extends Magia {
    public Raio() {
        super("Magnus radii", 20, 2, TiposElementais.Eletrico, new RaioAnimation(), true);
    }
}
