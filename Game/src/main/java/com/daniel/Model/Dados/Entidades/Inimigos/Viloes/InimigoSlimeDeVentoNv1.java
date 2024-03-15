package com.daniel.Model.Dados.Entidades.Inimigos.Viloes;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ouro;
import com.daniel.Model.Magias.Poderes.Vento;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoSlimeDeVentoNv1 extends Inimigo {
    public InimigoSlimeDeVentoNv1() {
        super("Slime de vento pequeno", "/com.daniel.Images/Inimigos/Slime Windi.png", 17, 20, 15, 15, 45, 20,25, 35, TiposElementais.Vento, Comportamentos.padrao, 100, 5);
        this.absorcao = new TiposElementais[]{TiposElementais.Vento};
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.fraquezas = new TiposElementais[]{TiposElementais.Terra};
        this.magias.add(new Vento());
        this.lootTable.AdicionarEntrada(new Ouro(), 1, 1, 0.2);

    }
}
