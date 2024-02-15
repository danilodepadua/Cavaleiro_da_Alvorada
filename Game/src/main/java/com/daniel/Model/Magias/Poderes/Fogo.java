package com.daniel.Model.Magias.Poderes;

import com.daniel.Model.Magias.Animacoes.FireAnimation;
import com.daniel.Model.Magias.Magia;
import com.daniel.Model.Magias.TiposElementais;

public class Fogo extends Magia {
    public Fogo() {
        super("Parvum ignem",10, 1, TiposElementais.Fogo, new FireAnimation(), true);
    }
}
