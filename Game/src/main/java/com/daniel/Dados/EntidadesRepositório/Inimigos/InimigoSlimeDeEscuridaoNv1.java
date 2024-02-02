package com.daniel.Dados.EntidadesRepositório.Inimigos;

import com.daniel.Modelo.ComportamentosInimigos.Comportamentos;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Magia.Poderes.Escuridao;
import com.daniel.Modelo.Itens.Minerios.Ferro;
import com.daniel.Modelo.Magia.TiposElementais;

public class InimigoSlimeDeEscuridaoNv1 extends Inimigo {
    public InimigoSlimeDeEscuridaoNv1() {
        super("Slime de escuridão pequeno", "/com.daniel.Images/Inimigos/Slime Darki.png", 23, 25, 15, 35, 5, 35, 15, TiposElementais.Escuridao, Comportamentos.padrao, 150, 55);
        this.absorcao = new TiposElementais[]{TiposElementais.Escuridao};
        this.imunidades = new TiposElementais[]{TiposElementais.Eletrico};
        this.fraquezas = new TiposElementais[]{TiposElementais.Luz};
        this.magias.add(new Escuridao());
        this.lootTable.AdicionarEntrada(new Ferro(), 1, 2, 0.8);
    }
}
