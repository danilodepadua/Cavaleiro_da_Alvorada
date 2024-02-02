package com.daniel.Model.Dados.Entidades.Inimigos;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigo;
import com.daniel.Model.Itens.Comidas.CoxaFrango;
import com.daniel.Model.Itens.Minerios.FragmentoEscuridao;
import com.daniel.Model.Magias.Poderes.Amolecer;
import com.daniel.Model.Magias.Poderes.Enfraquecer;
import com.daniel.Model.Magias.Poderes.Escuridao;
import com.daniel.Model.Magias.Poderes.IntDown;
import com.daniel.Model.Magias.TiposElementais;

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
