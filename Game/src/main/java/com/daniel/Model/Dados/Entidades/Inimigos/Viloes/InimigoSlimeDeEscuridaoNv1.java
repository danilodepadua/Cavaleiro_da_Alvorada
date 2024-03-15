package com.daniel.Model.Dados.Entidades.Inimigos.Viloes;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Magias.Poderes.Escuridao;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoSlimeDeEscuridaoNv1 extends Inimigo {
    public InimigoSlimeDeEscuridaoNv1() {
        super("Slime de escuridão pequeno", "/com.daniel.Images/Inimigos/Slime Darki.png", 23, 25, 15, 35, 5, 20,600, 15, TiposElementais.Escuridao, Comportamentos.padrao, 150, 55);
        this.absorcao = new TiposElementais[]{TiposElementais.Escuridao};
        this.imunidades = new TiposElementais[]{TiposElementais.Eletrico};
        this.fraquezas = new TiposElementais[]{TiposElementais.Luz};
        this.magias.add(new Escuridao());
        this.lootTable.AdicionarEntrada(new Ferro(), 1, 2, 0.8);
    }
}
