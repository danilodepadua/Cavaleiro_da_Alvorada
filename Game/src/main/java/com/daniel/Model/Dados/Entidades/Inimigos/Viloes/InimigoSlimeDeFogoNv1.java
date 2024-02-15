package com.daniel.Model.Dados.Entidades.Inimigos.Viloes;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Comidas.Banana;
import com.daniel.Model.Itens.Minerios.FragmentoFogo;
import com.daniel.Model.Magias.Poderes.Fogo;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoSlimeDeFogoNv1 extends Inimigo {
    public InimigoSlimeDeFogoNv1() {
        super("Slime de fogo pequeno", "/com.daniel.Images/Inimigos/Slime Firei.png", 5, 35, 15, 15, 15, 25, 28, TiposElementais.Fogo, Comportamentos.padrao, 150, 50);
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.absorcao = new TiposElementais[]{TiposElementais.Fogo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Agua, TiposElementais.Gelo};
        this.magias.add(new Fogo());
        this.lootTable.AdicionarEntrada(new FragmentoFogo(), 1, 1, 0.5);
        this.lootTable.AdicionarEntrada(new Banana(), 1, 1, 0.2);
    }
}
