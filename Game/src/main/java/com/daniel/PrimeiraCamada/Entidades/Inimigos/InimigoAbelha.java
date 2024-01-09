package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Magias.Escuridao;
import com.daniel.PrimeiraCamada.Magias.Fogo;
import com.daniel.PrimeiraCamada.Magias.Gelo;
import com.daniel.PrimeiraCamada.Magias.Luz;
import com.daniel.PrimeiraCamada.TiposElementais;

import java.util.ArrayList;

public class InimigoAbelha extends Inimigo {
    public InimigoAbelha( ) {
        super("Abelha", "/com.daniel.Images/Inimigos/Insects Bee.png", 15, 5, 10, 20, 5, 5, 10, 5, 100, 50, TiposElementais.NaoElemental, Comportamentos.padrao);
        this.fraquezas = new TiposElementais[]{TiposElementais.NaoElemental, TiposElementais.Terra};
        this.magias.add(new Fogo());
        this.magias.add(new Gelo());
        this.magias.add(new Luz());
        this.magias.add(new Escuridao());
    }
}
