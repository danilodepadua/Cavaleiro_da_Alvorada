package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Itens.Comidas.Banana;
import com.daniel.PrimeiraCamada.Itens.Minerios.FragmentoGlacial;
import com.daniel.PrimeiraCamada.Magias.Gelo;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeGeloNv3 extends Inimigo {
    public InimigoSlimeDeGeloNv3() {
        super("Slime de gelo grande", "/com.daniel.Images/Inimigos/Slime Iceiii.png", 10, 40, 35, 45, 40, 5, 5, TiposElementais.Gelo, Comportamentos.padrao, 300, 105);
        this.magias.add(new Gelo());
        this.absorcao = new TiposElementais[]{TiposElementais.Terra};
        this.fraquezas = new TiposElementais[]{TiposElementais.Fogo};
        this.resistencias = new TiposElementais[]{TiposElementais.Agua};
        this.imunidades = new TiposElementais[]{TiposElementais.Gelo};
        this.lootTable.AdicionarEntrada(new FragmentoGlacial(), 1, 3, 0.5);
        this.lootTable.AdicionarEntrada(new Banana(), 1, 2, 0.3);
    }
}
