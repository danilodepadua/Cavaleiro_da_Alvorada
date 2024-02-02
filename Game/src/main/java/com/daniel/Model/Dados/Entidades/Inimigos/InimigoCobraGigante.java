package com.daniel.Model.Dados.Entidades.Inimigos;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigo;
import com.daniel.Model.Magias.Poderes.Veneno;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoCobraGigante extends Inimigo {
    public InimigoCobraGigante() {
        super("Cobra gigante", "/com.daniel.Images/Inimigos/Colossal Snake Black.png", 31, 50, 45, 45, 45, 500, 250, TiposElementais.NaoElemental, Comportamentos.padrao, 25000, 3500);
        this.magias.add(new Veneno());
    }
}
