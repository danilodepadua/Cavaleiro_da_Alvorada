package com.daniel.Dados.EntidadesRepositório.Inimigos;

import com.daniel.Modelo.ComportamentosInimigos.Comportamentos;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Itens.Comidas.CoxaFrango;
import com.daniel.Modelo.Itens.Minerios.FragmentoEscuridao;
import com.daniel.Modelo.Magia.Poderes.Amolecer;
import com.daniel.Modelo.Magia.Poderes.Enfraquecer;
import com.daniel.Modelo.Magia.Poderes.Escuridao;
import com.daniel.Modelo.Magia.Poderes.IntDown;
import com.daniel.Modelo.Magia.TiposElementais;

public class InimigoSlimeDeEscuridaoNv3 extends Inimigo {
    public InimigoSlimeDeEscuridaoNv3() {
        super("Slime de escuridão grande", "/com.daniel.Images/Inimigos/Slime Darkiii.png", 25, 45, 25, 55, 25, 50, 25, TiposElementais.Escuridao, Comportamentos.padrao, 280, 120);
        this.absorcao = new TiposElementais[]{TiposElementais.Escuridao};
        this.imunidades = new TiposElementais[]{TiposElementais.Fogo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Luz};
        this.magias.add(new Escuridao());
        this.magias.add(new Amolecer());
        this.magias.add(new Enfraquecer());
        this.magias.add(new IntDown());
        this.lootTable.AdicionarEntrada(new FragmentoEscuridao(), 1, 2, 0.5);
        this.lootTable.AdicionarEntrada(new CoxaFrango(), 1, 2, 0.5);

    }
}
