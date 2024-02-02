package com.daniel.Model.Dados.Magias.Poderes;

import com.daniel.Model.Dados.Magias.Animation.RaioAnimation;
import com.daniel.Model.Dados.Magias.Magia;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class Raio extends Magia {
    public Raio() {
        super("Magnus radii", 20, 2, TiposElementais.Eletrico, new RaioAnimation(), true);
    }
}
