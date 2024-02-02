package com.daniel.Model.Dados.Entidades.Inimigos.Viloes;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class InimigoSlimeNv1 extends Inimigo {
    public InimigoSlimeNv1() {
        super("Slime pequeno", "/com.daniel.Images/Inimigos/slimei.png", 2, 15, 8, 15, 20, 15, 15, TiposElementais.NaoElemental, Comportamentos.padrao, 100, 5);
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
    }
}
