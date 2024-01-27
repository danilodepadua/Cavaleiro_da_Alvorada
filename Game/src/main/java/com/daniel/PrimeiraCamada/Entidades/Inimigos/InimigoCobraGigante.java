package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Magias.Veneno;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoCobraGigante extends Inimigo {
    public InimigoCobraGigante() {
        super("Cobra gigante", "/com.daniel.Images/Inimigos/Colossal Snake Black.png", 31, 50, 45, 45, 45, 500, 250, TiposElementais.NaoElemental, Comportamentos.padrao, 25000, 3500);
        this.magias.add(new Veneno());
    }
}
