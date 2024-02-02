package com.daniel.Dados.EntidadesRepositório.Inimigos;

import com.daniel.Modelo.ComportamentosInimigos.Comportamentos;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Itens.Minerios.FragmentoEscuridao;
import com.daniel.Modelo.Magia.Poderes.Amolecer;
import com.daniel.Modelo.Magia.Poderes.Enfraquecer;
import com.daniel.Modelo.Magia.Poderes.Escuridao;
import com.daniel.Modelo.Magia.Poderes.IntDown;
import com.daniel.Modelo.Magia.TiposElementais;

public class InimigoSlimeDeEscuridaoNv2 extends Inimigo {
    public InimigoSlimeDeEscuridaoNv2() {
        super("Slime de escuridão médio", "/com.daniel.Images/Inimigos/Slime Darkii.png", 24, 35, 20, 45, 20, 40, 20, TiposElementais.Escuridao, Comportamentos.padrao, 200, 85);
        this.absorcao = new TiposElementais[]{TiposElementais.Escuridao};
        this.imunidades = new TiposElementais[]{TiposElementais.Fogo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Luz};
        this.magias.add(new Escuridao());
        this.magias.add(new Amolecer());
        this.magias.add(new Enfraquecer());
        this.magias.add(new IntDown());
        this.lootTable.AdicionarEntrada(new FragmentoEscuridao(), 1, 1, 0.5);

    }
}
