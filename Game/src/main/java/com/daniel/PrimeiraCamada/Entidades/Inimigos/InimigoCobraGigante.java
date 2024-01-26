package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Magias.Veneno;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoCobraGigante extends Inimigo {
    public InimigoCobraGigante() {
        super("Cobra gigante", "/com.daniel.Images/Inimigos/Colossal Snake Black.png", 30, 50, 35, 55, 45, 500, 250, TiposElementais.NaoElemental, Comportamentos.padrao, 500, 350);
        this.magias.add(new Veneno());
    }
}
