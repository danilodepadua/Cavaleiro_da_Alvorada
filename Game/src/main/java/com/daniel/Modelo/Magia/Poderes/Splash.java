package com.daniel.Modelo.Magia.Poderes;

import com.daniel.Dados.MagiasRepositório.SplashAnimation;
import com.daniel.Modelo.Magia.Magia;
import com.daniel.Modelo.Magia.TiposElementais;

public class Splash extends Magia {
    public Splash() {
        super("Parva aqua", 10, 1, TiposElementais.Gelo, new SplashAnimation(), true);
    }
}
