package com.daniel.Model.Dados.Magias.Poderes;

import com.daniel.Model.Dados.Magias.Animation.HolyAnimation;
import com.daniel.Model.Dados.Magias.Magia;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class Luz extends Magia {
    public Luz() {
        super("Lux",20, 1.5, TiposElementais.Luz, new HolyAnimation(), true);
    }
}
