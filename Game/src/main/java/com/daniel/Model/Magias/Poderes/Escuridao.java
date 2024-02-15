package com.daniel.Model.Magias.Poderes;

import com.daniel.Model.Magias.Animacoes.DarkAnimation;
import com.daniel.Model.Magias.Magia;
import com.daniel.Model.Magias.TiposElementais;

public class Escuridao extends Magia {
    public Escuridao() {
        super("Tenebris",20, 1.5, TiposElementais.Escuridao, new DarkAnimation(), true);
    }
}
