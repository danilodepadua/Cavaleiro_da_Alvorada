package com.daniel.Model.Dados.Magias.Poderes;

import com.daniel.Model.Dados.Magias.Animation.ExplosaoAnimation;
import com.daniel.Model.Dados.Magias.Magia;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class Explosao extends Magia {
    public Explosao() {
        super("Magnus ignis", 15, 1.5, TiposElementais.Fogo, new ExplosaoAnimation(), true);
    }
}
