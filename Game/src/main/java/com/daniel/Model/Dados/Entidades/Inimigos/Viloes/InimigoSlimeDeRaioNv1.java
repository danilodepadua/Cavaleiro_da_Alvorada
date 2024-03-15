package com.daniel.Model.Dados.Entidades.Inimigos.Viloes;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ouro;
import com.daniel.Model.Magias.Poderes.ThunderBall;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoSlimeDeRaioNv1 extends Inimigo {
    public InimigoSlimeDeRaioNv1() {
        super("Slime de raio pequeno", "/com.daniel.Images/Inimigos/Slime Thunderi.png", 14, 30, 15, 20, 25, 20,40, 45, TiposElementais.Eletrico, Comportamentos.padrao, 150, 50);
        this.absorcao = new TiposElementais[]{TiposElementais.Eletrico};
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.magias.add(new ThunderBall());
        this.lootTable.AdicionarEntrada(new Ouro(), 1, 1, 0.2);

    }
}
