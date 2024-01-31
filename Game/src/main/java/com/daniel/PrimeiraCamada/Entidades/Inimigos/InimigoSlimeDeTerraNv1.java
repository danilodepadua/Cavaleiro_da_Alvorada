package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Itens.Comidas.Banana;
import com.daniel.PrimeiraCamada.Magias.Endurecer;
import com.daniel.PrimeiraCamada.Magias.ParedeTerra;
import com.daniel.PrimeiraCamada.Magias.Terra;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeTerraNv1 extends Inimigo {
    public InimigoSlimeDeTerraNv1() {
        super("Slime de terra pequeno", "/com.daniel.Images/Inimigos/Slime Earthi.png", 20, 20, 25, 35, 15, 75, 25, TiposElementais.Terra, Comportamentos.padrao, 150, 50);
        this.absorcao = new TiposElementais[]{TiposElementais.Terra};
        this.imunidades = new TiposElementais[]{TiposElementais.Agua};
        this.resistencias = new TiposElementais[]{TiposElementais.Eletrico, TiposElementais.Vento};
        this.fraquezas = new TiposElementais[]{TiposElementais.Agua};
        this.magias.add(new Terra());
        this.magias.add(new Endurecer());
        this.lootTable.AdicionarEntrada(new Banana(), 0, 1, 0.3);

    }
}
