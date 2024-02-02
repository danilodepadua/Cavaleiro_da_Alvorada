package com.daniel.Dados.EntidadesRepositório.Inimigos;

import com.daniel.Modelo.ComportamentosInimigos.Comportamentos;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Magia.Poderes.Roubo;
import com.daniel.Modelo.Magia.TiposElementais;

public class InimigoLadrao extends Inimigo {
    public InimigoLadrao() {
        super("Trombadinha", "/com.daniel.Images/Inimigos/Medieval Bandit Child.png", 30, 30, 42, 30, 45, 270, 100, TiposElementais.NaoElemental, Comportamentos.fugitivo, 500, 5000);
        this.magias.add(new Roubo());
    }
}
