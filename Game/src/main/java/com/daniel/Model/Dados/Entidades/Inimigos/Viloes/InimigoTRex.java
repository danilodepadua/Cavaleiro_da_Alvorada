package com.daniel.Model.Dados.Entidades.Inimigos.Viloes;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoTRex extends Inimigo {
    public InimigoTRex() {
        super("T-Rex", "/com.daniel.Images/Inimigos/Colossal T-Rex Red.png", 33, 60, 20, 50, 25, 1000, 100, TiposElementais.Gelo, Comportamentos.padrao, 15000, 5000);
        this.fraquezas = new TiposElementais[]{TiposElementais.Gelo, TiposElementais.Fogo};
        this.resistencias = new TiposElementais[]{TiposElementais.NaoElemental};
    }
}
