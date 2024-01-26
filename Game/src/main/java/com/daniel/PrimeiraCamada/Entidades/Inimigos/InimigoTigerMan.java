package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Magias.*;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoTigerMan extends Inimigo {
    public InimigoTigerMan() {
        super("Tigrinho", "/com.daniel.Images/Inimigos/Weretiger Maxima.png", 33, 50, 20, 30, 50, 500, 200, TiposElementais.NaoElemental, Comportamentos.padrao, 10000, 2500);
        this.resistencias = new TiposElementais[]{TiposElementais.NaoElemental};
        this.fraquezas = new TiposElementais[]{TiposElementais.Eletrico};
        this.magias.add(new Fortalecer());
        this.magias.add(new Fast());
        this.magias.add(new Endurecer());
    }
}
