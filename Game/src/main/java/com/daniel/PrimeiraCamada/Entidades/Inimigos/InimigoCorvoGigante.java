package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Magias.AirBlast;
import com.daniel.PrimeiraCamada.Magias.Sopro;
import com.daniel.PrimeiraCamada.Magias.Vento;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoCorvoGigante extends Inimigo {
    public InimigoCorvoGigante() {
        super("Corvo gigante", "/com.daniel.Images/Inimigos/Colossal Dark Crow.png", 31, 45, 45, 30, 60, 350, 125, TiposElementais.NaoElemental, Comportamentos.padrao, 25000, 4000);
        this.magias.add(new Vento());
        this.magias.add(new AirBlast());
        this.magias.add(new Sopro());
        this.resistencias = new TiposElementais[]{TiposElementais.Vento};
        this.fraquezas = new TiposElementais[]{TiposElementais.Fogo, TiposElementais.Terra};
    }
}
