package com.daniel.Modelo.Magia.Poderes;

import com.daniel.Dados.MagiasRepositório.ExplosaoAnimation;
import com.daniel.Modelo.Magia.Magia;
import com.daniel.Modelo.Magia.TiposElementais;

public class Explosao extends Magia {
    public Explosao() {
        super("Magnus ignis", 15, 1.5, TiposElementais.Fogo, new ExplosaoAnimation(), true);
    }
}
