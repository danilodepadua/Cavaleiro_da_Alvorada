package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Magias.Amolecer;
import com.daniel.PrimeiraCamada.Magias.Enfraquecer;
import com.daniel.PrimeiraCamada.Magias.Escuridao;
import com.daniel.PrimeiraCamada.Magias.IntDown;
import com.daniel.PrimeiraCamada.Itens.Comidas.Banana;
import com.daniel.PrimeiraCamada.Itens.Comidas.CoxaFrango;
import com.daniel.PrimeiraCamada.Itens.Minerios.BarraFerro;
import com.daniel.PrimeiraCamada.Itens.Minerios.Ferro;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeEscuridaoNv1 extends Inimigo {
    public InimigoSlimeDeEscuridaoNv1() {
        super("Slime de escuridão pequeno", "/com.daniel.Images/Inimigos/Slime Darki.png", 23, 25, 15, 35, 5, 35, 15, TiposElementais.Escuridao, Comportamentos.padrao, 150, 55);
        this.absorcao = new TiposElementais[]{TiposElementais.Escuridao};
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.fraquezas = new TiposElementais[]{TiposElementais.Luz};
        this.magias.add(new Escuridao());
        this.lootTable.AdicionarEntrada(new CoxaFrango(), 1, 2, 0.5);
        this.lootTable.AdicionarEntrada(new Banana(), 1, 2, 0.2);
        this.lootTable.AdicionarEntrada(new BarraFerro(), 1, 2, 0.1);
        this.lootTable.AdicionarEntrada(new Ferro(), 1, 2, 0.8);
    }
}
