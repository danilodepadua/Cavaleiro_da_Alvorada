package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Magias.Sopro;
import com.daniel.PrimeiraCamada.Magias.Vento;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeVentoNv2 extends Inimigo {
    public InimigoSlimeDeVentoNv2() {
        super("Slime de vento médio", "/com.daniel.Images/Inimigos/Slime Windii.png", 18, 35, 25, 25, 50, 45, 35, TiposElementais.Vento, Comportamentos.padrao, 100, 5);
        this.absorcao = new TiposElementais[]{TiposElementais.Vento};
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.fraquezas = new TiposElementais[]{TiposElementais.Terra};
        this.magias.add(new Vento());
        this.magias.add(new Sopro());
    }
}
