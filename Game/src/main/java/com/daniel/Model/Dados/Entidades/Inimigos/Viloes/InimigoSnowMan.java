package com.daniel.Model.Dados.Entidades.Inimigos.Viloes;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Magias.Poderes.Gelo;
import com.daniel.Model.Magias.Poderes.Slow;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoSnowMan extends Inimigo {
    public InimigoSnowMan() {
        super("Abominavel boneco das neves", "/com.daniel.Images/Inimigos/Xmas Snowman.png", 35, 50, 25, 15, 25, 30,485, 105, TiposElementais.Gelo, Comportamentos.padrao, 5000, 500);
        this.magias.add(new Gelo());
        this.magias.add(new Slow());
        this.magias.add(new Slow());
        this.fraquezas = new TiposElementais[]{TiposElementais.Fogo};
        this.absorcao = new TiposElementais[]{TiposElementais.Gelo};
        this.resistencias = new TiposElementais[]{TiposElementais.Agua};
    }
}
