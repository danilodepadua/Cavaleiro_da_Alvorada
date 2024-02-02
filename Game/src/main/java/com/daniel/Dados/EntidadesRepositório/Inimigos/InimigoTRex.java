package com.daniel.Dados.EntidadesRepositório.Inimigos;

import com.daniel.Modelo.ComportamentosInimigos.Comportamentos;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Magia.TiposElementais;

public class InimigoTRex extends Inimigo {
    public InimigoTRex() {
        super("T-Rex", "/com.daniel.Images/Inimigos/Colossal T-Rex Red.png", 33, 60, 20, 50, 25, 1000, 100, TiposElementais.Gelo, Comportamentos.padrao, 15000, 5000);
        this.fraquezas = new TiposElementais[]{TiposElementais.Gelo, TiposElementais.Fogo};
        this.resistencias = new TiposElementais[]{TiposElementais.NaoElemental};
    }
}
