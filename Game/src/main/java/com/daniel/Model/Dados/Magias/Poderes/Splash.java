package com.daniel.Model.Dados.Magias.Poderes;

import com.daniel.Model.Dados.Magias.Animation.SplashAnimation;
import com.daniel.Model.Dados.Magias.Magia;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class Splash extends Magia {
    public Splash() {
        super("Parva aqua", 10, 1, TiposElementais.Gelo, new SplashAnimation(), true);
    }
}
