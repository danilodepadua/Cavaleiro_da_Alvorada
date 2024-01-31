package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Itens.Minerios.Ouro;
import com.daniel.PrimeiraCamada.Magias.Vento;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeVentoNv1 extends Inimigo {
    public InimigoSlimeDeVentoNv1() {
        super("Slime de vento pequeno", "/com.daniel.Images/Inimigos/Slime Windi.png", 17, 20, 15, 15, 45, 25, 35, TiposElementais.Vento, Comportamentos.padrao, 100, 5);
        this.absorcao = new TiposElementais[]{TiposElementais.Vento};
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.fraquezas = new TiposElementais[]{TiposElementais.Terra};
        this.magias.add(new Vento());
        this.lootTable.AdicionarEntrada(new Ouro(), 0, 1, 0.2);

    }
}
