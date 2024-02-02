package com.daniel.Model.Dados.Magias.Poderes;

import com.daniel.Model.Dados.Magias.Animation.FireAnimation;
import com.daniel.Model.Dados.Magias.Magia;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class Fogo extends Magia {
    public Fogo() {
        super("Parvum ignem",10, 1, TiposElementais.Fogo, new FireAnimation(), true);
    }
}
