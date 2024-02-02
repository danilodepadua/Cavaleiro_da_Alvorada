package com.daniel.Model.Dados.Entidades.Inimigos.Viloes;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class InimigoSlimeNv3 extends Inimigo {
    public InimigoSlimeNv3() {
        super("Slime grande", "/com.daniel.Images/Inimigos/slimeiii.png", 4, 25, 20, 20, 30, 25, 25, TiposElementais.Gelo, Comportamentos.padrao, 250, 75);
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
    }
}
