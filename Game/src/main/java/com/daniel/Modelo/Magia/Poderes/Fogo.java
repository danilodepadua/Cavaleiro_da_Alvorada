package com.daniel.Modelo.Magia.Poderes;

import com.daniel.Dados.MagiasRepositório.FireAnimation;
import com.daniel.Modelo.Magia.Magia;
import com.daniel.Modelo.Magia.TiposElementais;

public class Fogo extends Magia {
    public Fogo() {
        super("Parvum ignem",10, 1, TiposElementais.Fogo, new FireAnimation(), true);
    }
}
