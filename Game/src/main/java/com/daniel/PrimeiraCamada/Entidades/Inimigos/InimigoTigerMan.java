package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposDano;

public class InimigoTigerMan extends Inimigo {
    public InimigoTigerMan() {
        super("Tigrinho", "/com.daniel.Images/Inimigos/Weretiger Maxima.png", 50, 40, 25, 60, 20, 10, 40, 20, 500, 200, TiposDano.Fisico);
        this.resistencias = new TiposDano[]{TiposDano.Fisico};
        this.fraquezas = new TiposDano[]{TiposDano.Eletrico};
    }
}
