package com.daniel.Dados.EntidadesRepositório.Inimigos;

import com.daniel.Modelo.ComportamentosInimigos.Comportamentos;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Magia.Poderes.AirBlast;
import com.daniel.Modelo.Magia.Poderes.Sopro;
import com.daniel.Modelo.Magia.Poderes.Vento;
import com.daniel.Modelo.Magia.TiposElementais;

public class InimigoCorvoGigante extends Inimigo {
    public InimigoCorvoGigante() {
        super("Corvo gigante", "/com.daniel.Images/Inimigos/Colossal Dark Crow.png", 32, 45, 45, 30, 60, 350, 125, TiposElementais.NaoElemental, Comportamentos.padrao, 25000, 4000);
        this.magias.add(new Vento());
        this.magias.add(new AirBlast());
        this.magias.add(new Sopro());
        this.resistencias = new TiposElementais[]{TiposElementais.Vento};
        this.fraquezas = new TiposElementais[]{TiposElementais.Fogo, TiposElementais.Terra};
    }
}
