package com.daniel.Model.Dados.Magias.Poderes;

import com.daniel.Model.Dados.Magias.Animation.BolaRaioAnimation;
import com.daniel.Model.Dados.Magias.Magia;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class ThunderBall extends Magia {
    public ThunderBall() {
        super("Parvum radii", 10, 1, TiposElementais.Eletrico, new BolaRaioAnimation(), true);
    }
}
