package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Magias.Roubo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoLadrao extends Inimigo {
    public InimigoLadrao() {
        super("Trombadinha", "/com.daniel.Images/Inimigos/Medieval Bandit Child.png", 30, 30, 42, 30, 45, 270, 100, TiposElementais.NaoElemental, Comportamentos.fugitivo, 500, 5000);
        this.magias.add(new Roubo());
    }
}
