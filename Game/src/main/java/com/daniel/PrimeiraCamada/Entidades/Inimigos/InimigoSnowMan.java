package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Magias.Gelo;
import com.daniel.PrimeiraCamada.Magias.Slow;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSnowMan extends Inimigo {
    public InimigoSnowMan() {
        super("Abominavel boneco das neves", "/com.daniel.Images/Inimigos/Xmas Snowman.png", 34, 50, 25, 15, 25, 485, 105, TiposElementais.Gelo, Comportamentos.padrao, 5000, 500);
        this.magias.add(new Gelo());
        this.magias.add(new Slow());
        this.magias.add(new Slow());
        this.fraquezas = new TiposElementais[]{TiposElementais.Fogo};
        this.absorcao = new TiposElementais[]{TiposElementais.Gelo};
        this.resistencias = new TiposElementais[]{TiposElementais.Agua};
    }
}
