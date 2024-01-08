package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposDano;

public class InimigoAbelha extends Inimigo {
    public InimigoAbelha( ) {
        super("Abelha", "/com.daniel.Images/Inimigos/Insects Bee.png", 15, 5, 10, 20, 5, 5, 10, 5, 100, 50, TiposDano.Fisico);
        this.fraquezas = new TiposDano[]{TiposDano.Fisico,TiposDano.Terra};
    }
}
