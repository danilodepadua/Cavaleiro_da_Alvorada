package com.daniel.Model.Dados.Entidades.Inimigos.Viloes;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Comidas.Banana;
import com.daniel.Model.Magias.Poderes.Endurecer;
import com.daniel.Model.Magias.Poderes.Terra;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoSlimeDeTerraNv1 extends Inimigo {
    public InimigoSlimeDeTerraNv1() {
        super("Slime de terra pequeno", "/com.daniel.Images/Inimigos/Slime Earthi.png", 20, 20, 25, 35, 15, 20,75, 25, TiposElementais.Terra, Comportamentos.padrao, 150, 50);
        this.absorcao = new TiposElementais[]{TiposElementais.Terra};
        this.imunidades = new TiposElementais[]{TiposElementais.Agua};
        this.resistencias = new TiposElementais[]{TiposElementais.Eletrico, TiposElementais.Vento};
        this.fraquezas = new TiposElementais[]{TiposElementais.Agua};
        this.magias.add(new Terra());
        this.magias.add(new Endurecer());
        this.lootTable.AdicionarEntrada(new Banana(), 1, 1, 0.3);

    }
}
