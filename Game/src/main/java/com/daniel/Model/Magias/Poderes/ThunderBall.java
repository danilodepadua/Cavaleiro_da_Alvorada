package com.daniel.Model.Magias.Poderes;

import com.daniel.Model.Magias.Animacoes.BolaRaioAnimation;
import com.daniel.Model.Magias.Magia;
import com.daniel.Model.Magias.TiposElementais;

public class ThunderBall extends Magia {
    public ThunderBall() {
        super("Parvum radii", 10, 1, TiposElementais.Eletrico, new BolaRaioAnimation(), true);
    }
}
