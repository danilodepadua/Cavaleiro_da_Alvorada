package com.daniel.Model.Magias.Poderes;

import com.daniel.Model.Magias.Animacoes.SplashAnimation;
import com.daniel.Model.Magias.Magia;
import com.daniel.Model.Magias.TiposElementais;

public class Splash extends Magia {
    public Splash() {
        super("Parva aqua", 10, 1, TiposElementais.Gelo, new SplashAnimation(), true);
    }
}
