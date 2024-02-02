package com.daniel.Dados.EntidadesRepositório.Inimigos;

import com.daniel.Modelo.ComportamentosInimigos.Comportamentos;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Magia.Poderes.Veneno;
import com.daniel.Modelo.Magia.TiposElementais;

public class InimigoCobraGigante extends Inimigo {
    public InimigoCobraGigante() {
        super("Cobra gigante", "/com.daniel.Images/Inimigos/Colossal Snake Black.png", 31, 50, 45, 45, 45, 500, 250, TiposElementais.NaoElemental, Comportamentos.padrao, 25000, 3500);
        this.magias.add(new Veneno());
    }
}
