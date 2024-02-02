package com.daniel.Model.Dados.Entidades.Inimigos.Viloes;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Dados.Itens.Minerios.Ouro;
import com.daniel.Model.Dados.Magias.Poderes.Raio;
import com.daniel.Model.Dados.Magias.Poderes.ThunderBall;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class InimigoSlimeDeRaioNv2 extends Inimigo {
    public InimigoSlimeDeRaioNv2() {
        super("Slime de raio médio", "/com.daniel.Images/Inimigos/Slime Thunderii.png", 15, 35, 25, 25, 40,  60, 50, TiposElementais.Eletrico, Comportamentos.padrao, 250, 150);
        this.absorcao = new TiposElementais[]{TiposElementais.Eletrico};
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.magias.add(new Raio());
        this.magias.add(new ThunderBall());
        this.lootTable.AdicionarEntrada(new Ouro(), 1, 2, 0.2);

    }
}
