package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Itens.Comidas.Banana;
import com.daniel.PrimeiraCamada.Itens.Comidas.CoxaFrango;
import com.daniel.PrimeiraCamada.Itens.Minerios.FragmentoFogo;
import com.daniel.PrimeiraCamada.Itens.Minerios.FragmentoGlacial;
import com.daniel.PrimeiraCamada.Magias.Gelo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeGeloNv1 extends Inimigo {
    public InimigoSlimeDeGeloNv1() {
        super("Slime de gelo pequeno", "/com.daniel.Images/Inimigos/Slime Icei.png", 8, 20, 15, 25, 25, 5, 5, TiposElementais.Gelo, Comportamentos.padrao, 150, 50);
        this.magias.add(new Gelo());
        this.absorcao = new TiposElementais[]{TiposElementais.Terra};
        this.fraquezas = new TiposElementais[]{TiposElementais.Fogo};
        this.resistencias = new TiposElementais[]{TiposElementais.Agua};
        this.imunidades = new TiposElementais[]{TiposElementais.Gelo};
        this.lootTable.AdicionarEntrada(new FragmentoGlacial(), 1, 1, 0.5);
        this.lootTable.AdicionarEntrada(new Banana(), 1, 1, 0.2);
    }
}
