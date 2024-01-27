package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Magias.Raio;
import com.daniel.PrimeiraCamada.Magias.ThunderBall;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeRaioNv2 extends Inimigo {
    public InimigoSlimeDeRaioNv2() {
        super("Slime de raio médio", "/com.daniel.Images/Inimigos/Slime Thunderii.png", 15, 35, 25, 25, 40,  60, 50, TiposElementais.Eletrico, Comportamentos.padrao, 250, 150);
        this.absorcao = new TiposElementais[]{TiposElementais.Eletrico};
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.magias.add(new Raio());
        this.magias.add(new ThunderBall());
    }
}
