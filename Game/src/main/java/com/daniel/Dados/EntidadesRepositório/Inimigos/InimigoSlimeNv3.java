package com.daniel.Dados.EntidadesRepositório.Inimigos;

import com.daniel.Modelo.ComportamentosInimigos.Comportamentos;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Magia.TiposElementais;

public class InimigoSlimeNv3 extends Inimigo {
    public InimigoSlimeNv3() {
        super("Slime grande", "/com.daniel.Images/Inimigos/slimeiii.png", 4, 25, 20, 20, 30, 25, 25, TiposElementais.Gelo, Comportamentos.padrao, 250, 75);
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
    }
}
