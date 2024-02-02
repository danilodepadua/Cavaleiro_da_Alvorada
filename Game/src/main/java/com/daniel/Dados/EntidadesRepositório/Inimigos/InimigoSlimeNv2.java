package com.daniel.Dados.EntidadesRepositório.Inimigos;

import com.daniel.Modelo.ComportamentosInimigos.Comportamentos;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Magia.TiposElementais;

public class InimigoSlimeNv2 extends Inimigo {
    public InimigoSlimeNv2() {
        super("Slime médio", "/com.daniel.Images/Inimigos/slimeii.png", 3, 20, 15, 18, 25, 20, 20, TiposElementais.Gelo, Comportamentos.padrao, 150, 25);
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
    }
}
