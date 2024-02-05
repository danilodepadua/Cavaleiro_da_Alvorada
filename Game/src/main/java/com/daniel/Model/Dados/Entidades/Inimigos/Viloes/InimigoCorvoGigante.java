package com.daniel.Model.Dados.Entidades.Inimigos.Viloes;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Dados.Magias.Poderes.AirBlast;
import com.daniel.Model.Dados.Magias.Poderes.Sopro;
import com.daniel.Model.Dados.Magias.Poderes.Vento;
import com.daniel.Model.Dados.Magias.TiposElementais;

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