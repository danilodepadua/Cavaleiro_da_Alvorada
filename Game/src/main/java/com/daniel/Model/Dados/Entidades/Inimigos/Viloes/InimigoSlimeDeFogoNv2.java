package com.daniel.Model.Dados.Entidades.Inimigos.Viloes;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Comidas.Pao;
import com.daniel.Model.Itens.Minerios.FragmentoFogo;
import com.daniel.Model.Magias.Poderes.Explosao;
import com.daniel.Model.Magias.Poderes.Fogo;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoSlimeDeFogoNv2 extends Inimigo {
    public InimigoSlimeDeFogoNv2() {
        super("Slime de fogo médio", "/com.daniel.Images/Inimigos/Slime Fireii.png", 6, 45, 25, 25, 25, 20,45, 30, TiposElementais.Fogo, Comportamentos.padrao, 250, 75);
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.absorcao = new TiposElementais[]{TiposElementais.Fogo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Agua, TiposElementais.Gelo};
        this.magias.add(new Fogo());
        this.magias.add(new Explosao());
        this.lootTable.AdicionarEntrada(new FragmentoFogo(), 1, 2, 0.5);
        this.lootTable.AdicionarEntrada(new Pao(), 1, 1, 0.2);
    }
}
