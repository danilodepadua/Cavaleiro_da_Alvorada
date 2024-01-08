package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposDano;

public class InimigoSlime extends Inimigo {
    public InimigoSlime() {
        super("Slime", "/com.daniel.Images/Inimigos/Slime Blue.png", 5, 5, 10, 5, 5, 10, 10, 5, 30, 10, TiposDano.Fisico);
        this.imunidades = new TiposDano[]{TiposDano.Fisico};
    }
}
