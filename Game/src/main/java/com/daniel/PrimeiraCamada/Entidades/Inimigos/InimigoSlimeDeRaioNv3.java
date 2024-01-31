package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Itens.Minerios.BarraOuro;
import com.daniel.PrimeiraCamada.Itens.Minerios.Ouro;
import com.daniel.PrimeiraCamada.Magias.Raio;
import com.daniel.PrimeiraCamada.Magias.ThunderBall;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeRaioNv3 extends Inimigo {
    public InimigoSlimeDeRaioNv3() {
        super("Slime de raio grande", "/com.daniel.Images/Inimigos/Slime Thunderiii.png", 16, 45, 35, 35, 50, 80, 55, TiposElementais.Eletrico, Comportamentos.padrao, 400, 250);
        this.absorcao = new TiposElementais[]{TiposElementais.Eletrico};
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.magias.add(new Raio());
        this.magias.add(new ThunderBall());
        this.lootTable.AdicionarEntrada(new Ouro(), 0, 3, 0.2);
        this.lootTable.AdicionarEntrada(new BarraOuro(), 0, 3, 0.2);

    }
}
