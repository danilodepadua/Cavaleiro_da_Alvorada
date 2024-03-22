package com.daniel.Model.Dados.Entidades.Inimigos.MonteClaro;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Magias.Poderes.Endurecer;
import com.daniel.Model.Magias.Poderes.Fast;
import com.daniel.Model.Magias.Poderes.Fortalecer;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoTigerMan extends Inimigo {
    public InimigoTigerMan() {
        super("Tigrinho", "/com.daniel.Images/Inimigos/Weretiger Maxima.png", 29, 35, 35, 35, 35, 35,500, 200, TiposElementais.NaoElemental, Comportamentos.padrao, 10000, 2500);
        this.resistencias = new TiposElementais[]{TiposElementais.NaoElemental};
        this.fraquezas = new TiposElementais[]{TiposElementais.Eletrico};
        this.magias.add(new Fortalecer());
        this.magias.add(new Fast());
        this.magias.add(new Endurecer());
    }
}
