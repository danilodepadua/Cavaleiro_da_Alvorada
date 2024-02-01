package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Itens.Comidas.CoxaFrango;
import com.daniel.PrimeiraCamada.Itens.Minerios.FragmentoEscuridao;
import com.daniel.PrimeiraCamada.Magias.Amolecer;
import com.daniel.PrimeiraCamada.Magias.Enfraquecer;
import com.daniel.PrimeiraCamada.Magias.Escuridao;
import com.daniel.PrimeiraCamada.Magias.IntDown;
import com.daniel.PrimeiraCamada.TiposElementais;

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
