package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Itens.Comidas.Banana;
import com.daniel.PrimeiraCamada.Itens.Comidas.CoxaFrango;
import com.daniel.PrimeiraCamada.Itens.Minerios.Ferro;
import com.daniel.PrimeiraCamada.Itens.Minerios.FragmentoFogo;
import com.daniel.PrimeiraCamada.Magias.Explosao;
import com.daniel.PrimeiraCamada.Magias.Fogo;
import com.daniel.PrimeiraCamada.Magias.Fortalecer;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeFogoNv3 extends Inimigo {
    public InimigoSlimeDeFogoNv3() {
        super("Slime de fogo grande", "/com.daniel.Images/Inimigos/Slime Fireiii.png", 7, 55, 30, 35, 35, 65, 35, TiposElementais.Gelo, Comportamentos.padrao, 370, 105);
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.absorcao = new TiposElementais[]{TiposElementais.Fogo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Agua, TiposElementais.Gelo};
        this.magias.add(new Fogo());
        this.magias.add(new Explosao());
        this.magias.add(new Fortalecer());
        this.lootTable.AdicionarEntrada(new FragmentoFogo(), 1, 3, 0.7);
        this.lootTable.AdicionarEntrada(new CoxaFrango(), 1, 2, 0.2);
    }
}
