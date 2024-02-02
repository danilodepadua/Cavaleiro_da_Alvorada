package com.daniel.Dados.EntidadesRepositório.Inimigos;

import com.daniel.Modelo.ComportamentosInimigos.Comportamentos;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Magia.Poderes.Endurecer;
import com.daniel.Modelo.Magia.Poderes.Fast;
import com.daniel.Modelo.Magia.Poderes.Fortalecer;
import com.daniel.Modelo.Magia.TiposElementais;

public class InimigoTigerMan extends Inimigo {
    public InimigoTigerMan() {
        super("Tigrinho", "/com.daniel.Images/Inimigos/Weretiger Maxima.png", 34, 50, 20, 30, 50, 500, 200, TiposElementais.NaoElemental, Comportamentos.padrao, 10000, 2500);
        this.resistencias = new TiposElementais[]{TiposElementais.NaoElemental};
        this.fraquezas = new TiposElementais[]{TiposElementais.Eletrico};
        this.magias.add(new Fortalecer());
        this.magias.add(new Fast());
        this.magias.add(new Endurecer());
    }
}
