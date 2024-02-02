package com.daniel.Model.Magias.Poderes;

import com.daniel.Model.Magias.Animation.ExplosaoAnimation;
import com.daniel.Model.Magias.Magia;
import com.daniel.Model.Magias.TiposElementais;

public class Explosao extends Magia {
    public Explosao() {
        super("Magnus ignis", 15, 1.5, TiposElementais.Fogo, new ExplosaoAnimation(), true);
    }
}
