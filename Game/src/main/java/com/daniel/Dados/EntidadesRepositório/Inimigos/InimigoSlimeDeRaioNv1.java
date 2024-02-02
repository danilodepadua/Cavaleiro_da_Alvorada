package com.daniel.Dados.EntidadesRepositório.Inimigos;

import com.daniel.Modelo.ComportamentosInimigos.Comportamentos;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Itens.Minerios.Ouro;
import com.daniel.Modelo.Magia.Poderes.ThunderBall;
import com.daniel.Modelo.Magia.TiposElementais;

public class InimigoSlimeDeRaioNv1 extends Inimigo {
    public InimigoSlimeDeRaioNv1() {
        super("Slime de raio pequeno", "/com.daniel.Images/Inimigos/Slime Thunderi.png", 14, 30, 15, 20, 25, 40, 45, TiposElementais.Eletrico, Comportamentos.padrao, 150, 50);
        this.absorcao = new TiposElementais[]{TiposElementais.Eletrico};
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.magias.add(new ThunderBall());
        this.lootTable.AdicionarEntrada(new Ouro(), 1, 1, 0.2);

    }
}
