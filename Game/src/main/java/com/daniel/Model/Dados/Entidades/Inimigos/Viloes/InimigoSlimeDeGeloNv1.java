package com.daniel.Model.Dados.Entidades.Inimigos.Viloes;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.FragmentoGlacial;
import com.daniel.Model.Magias.Poderes.Gelo;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoSlimeDeGeloNv1 extends Inimigo {
    public InimigoSlimeDeGeloNv1() {
        super("Slime de gelo pequeno", "/com.daniel.Images/Inimigos/Slime Icei.png", 8, 20, 15, 25, 25, 20,5, 5, TiposElementais.Gelo, Comportamentos.padrao, 150, 50);
        this.magias.add(new Gelo());
        this.absorcao = new TiposElementais[]{TiposElementais.Terra};
        this.fraquezas = new TiposElementais[]{TiposElementais.Fogo};
        this.resistencias = new TiposElementais[]{TiposElementais.Agua};
        this.imunidades = new TiposElementais[]{TiposElementais.Gelo};
        this.lootTable.AdicionarEntrada(new FragmentoGlacial(), 1, 1, 0.5);
    }
}
