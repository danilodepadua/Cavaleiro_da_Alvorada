package com.daniel.Dados.EntidadesRepositório.Inimigos;

import com.daniel.Modelo.ComportamentosInimigos.Comportamentos;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Itens.Minerios.Ouro;
import com.daniel.Modelo.Magia.Poderes.Raio;
import com.daniel.Modelo.Magia.Poderes.ThunderBall;
import com.daniel.Modelo.Magia.TiposElementais;

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
