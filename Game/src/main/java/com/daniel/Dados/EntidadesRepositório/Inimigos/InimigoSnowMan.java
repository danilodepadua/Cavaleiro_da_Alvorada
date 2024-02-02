package com.daniel.Dados.EntidadesRepositório.Inimigos;

import com.daniel.Modelo.ComportamentosInimigos.Comportamentos;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Magia.Poderes.Gelo;
import com.daniel.Modelo.Magia.Poderes.Slow;
import com.daniel.Modelo.Magia.TiposElementais;

public class InimigoSnowMan extends Inimigo {
    public InimigoSnowMan() {
        super("Abominavel boneco das neves", "/com.daniel.Images/Inimigos/Xmas Snowman.png", 35, 50, 25, 15, 25, 485, 105, TiposElementais.Gelo, Comportamentos.padrao, 5000, 500);
        this.magias.add(new Gelo());
        this.magias.add(new Slow());
        this.magias.add(new Slow());
        this.fraquezas = new TiposElementais[]{TiposElementais.Fogo};
        this.absorcao = new TiposElementais[]{TiposElementais.Gelo};
        this.resistencias = new TiposElementais[]{TiposElementais.Agua};
    }
}
