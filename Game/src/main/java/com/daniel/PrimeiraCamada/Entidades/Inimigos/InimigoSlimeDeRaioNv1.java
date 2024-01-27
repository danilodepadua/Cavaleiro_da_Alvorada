package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Magias.Raio;
import com.daniel.PrimeiraCamada.Magias.ThunderBall;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeRaioNv1 extends Inimigo {
    public InimigoSlimeDeRaioNv1() {
        super("Slime de raio pequeno", "/com.daniel.Images/Inimigos/Slime Thunderi.png", 14, 30, 15, 20, 25, 40, 45, TiposElementais.Eletrico, Comportamentos.padrao, 150, 50);
        this.absorcao = new TiposElementais[]{TiposElementais.Eletrico};
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.magias.add(new ThunderBall());
    }
}
