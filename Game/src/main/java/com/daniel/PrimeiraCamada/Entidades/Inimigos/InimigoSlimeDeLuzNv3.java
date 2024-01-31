package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Itens.Comidas.Banana;
import com.daniel.PrimeiraCamada.Itens.Comidas.CoxaFrango;
import com.daniel.PrimeiraCamada.Magias.Curaga;
import com.daniel.PrimeiraCamada.Magias.Fast;
import com.daniel.PrimeiraCamada.Magias.IntUp;
import com.daniel.PrimeiraCamada.Magias.Luz;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeLuzNv3 extends Inimigo {
    public InimigoSlimeDeLuzNv3() {
        super("Slime de luz grande", "/com.daniel.Images/Inimigos/Slime Holyiii.png", 28, 35, 55, 45, 40, 65, 250, TiposElementais.Luz, Comportamentos.padrao, 350, 150);
        this.magias.add(new Luz());
        this.magias.add(new IntUp());
        this.magias.add(new Curaga());
        this.absorcao = new TiposElementais[]{TiposElementais.Fogo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Escuridao};
        this.imunidades = new TiposElementais[]{TiposElementais.Luz};
        this.lootTable.AdicionarEntrada(new CoxaFrango(), 0, 2, 0.3);
        this.lootTable.AdicionarEntrada(new Banana(), 0, 2, 0.3);

    }
}
