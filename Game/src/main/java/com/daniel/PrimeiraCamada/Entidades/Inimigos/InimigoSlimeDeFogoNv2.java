package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Itens.Comidas.Banana;
import com.daniel.PrimeiraCamada.Itens.Comidas.Pao;
import com.daniel.PrimeiraCamada.Itens.Minerios.Ferro;
import com.daniel.PrimeiraCamada.Itens.Minerios.FragmentoFogo;
import com.daniel.PrimeiraCamada.Magias.Explosao;
import com.daniel.PrimeiraCamada.Magias.Fogo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeFogoNv2 extends Inimigo {
    public InimigoSlimeDeFogoNv2() {
        super("Slime de fogo médio", "/com.daniel.Images/Inimigos/Slime Fireii.png", 6, 45, 25, 25, 25, 45, 30, TiposElementais.Fogo, Comportamentos.padrao, 250, 75);
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.absorcao = new TiposElementais[]{TiposElementais.Fogo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Agua, TiposElementais.Gelo};
        this.magias.add(new Fogo());
        this.magias.add(new Explosao());
        this.lootTable.AdicionarEntrada(new FragmentoFogo(), 1, 2, 0.5);
        this.lootTable.AdicionarEntrada(new Pao(), 0, 1, 0.2);
    }
}
