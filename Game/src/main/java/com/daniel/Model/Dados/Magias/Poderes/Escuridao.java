package com.daniel.Model.Dados.Magias.Poderes;

import com.daniel.Model.Dados.Magias.Animation.DarkAnimation;
import com.daniel.Model.Dados.Magias.Magia;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class Escuridao extends Magia {
    public Escuridao() {
        super("Tenebris",20, 1.5, TiposElementais.Escuridao, new DarkAnimation(), true);
    }
}
