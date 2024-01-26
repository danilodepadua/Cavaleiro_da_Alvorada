package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoTRex extends Inimigo {
    public InimigoTRex() {
        super("T-Rex", "/com.daniel.Images/Inimigos/Colossal T-Rex Red.png", 32, 60, 20, 50, 25, 1000, 100, TiposElementais.Gelo, Comportamentos.padrao, 15000, 5000);
        this.fraquezas = new TiposElementais[]{TiposElementais.Gelo, TiposElementais.Fogo};
        this.resistencias = new TiposElementais[]{TiposElementais.NaoElemental};
    }
}
