package com.daniel.Model.Dados.Entidades.Inimigos.Viloes;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Magias.Poderes.Roubo;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoLadrao extends Inimigo {
    public InimigoLadrao() {
        super("Trombadinha", "/com.daniel.Images/Inimigos/Medieval Bandit Child.png", 30, 30, 42, 30, 45, 50,270, 100, TiposElementais.NaoElemental, Comportamentos.fugitivo, 500, 5000);
        this.magias.add(new Roubo());
    }
}
