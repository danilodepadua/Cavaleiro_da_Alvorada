package com.daniel.Dados.EntidadesRepositório.Inimigos;

import com.daniel.Modelo.ComportamentosInimigos.Comportamentos;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Itens.Minerios.BarraOuro;
import com.daniel.Modelo.Itens.Minerios.Ouro;
import com.daniel.Modelo.Magia.Poderes.Raio;
import com.daniel.Modelo.Magia.Poderes.ThunderBall;
import com.daniel.Modelo.Magia.TiposElementais;

public class InimigoSlimeDeRaioNv3 extends Inimigo {
    public InimigoSlimeDeRaioNv3() {
        super("Slime de raio grande", "/com.daniel.Images/Inimigos/Slime Thunderiii.png", 16, 45, 35, 35, 50, 80, 55, TiposElementais.Eletrico, Comportamentos.padrao, 400, 250);
        this.absorcao = new TiposElementais[]{TiposElementais.Eletrico};
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.magias.add(new Raio());
        this.magias.add(new ThunderBall());
        this.lootTable.AdicionarEntrada(new Ouro(), 1, 3, 0.2);
        this.lootTable.AdicionarEntrada(new BarraOuro(), 1, 3, 0.2);

    }
}
