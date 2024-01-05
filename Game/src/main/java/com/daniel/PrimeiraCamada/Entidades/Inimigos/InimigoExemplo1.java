package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.TiposDano;

public class InimigoExemplo1 extends Inimigo {

    public InimigoExemplo1() {
        super("Kartus", "/com.daniel.Images/Player2.png", 10, 10, 25, 5, 10, 5, 5, 5, 100, 30, TiposDano.Fogo);
        this.fraquezas = new TiposDano[]{TiposDano.Fisico};
    }
}
