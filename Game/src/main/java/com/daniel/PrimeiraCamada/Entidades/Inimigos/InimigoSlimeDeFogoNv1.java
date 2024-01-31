package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Itens.Comidas.Banana;
import com.daniel.PrimeiraCamada.Itens.Comidas.CoxaFrango;
import com.daniel.PrimeiraCamada.Itens.Minerios.BarraFerro;
import com.daniel.PrimeiraCamada.Itens.Minerios.Ferro;
import com.daniel.PrimeiraCamada.Itens.Minerios.FragmentoFogo;
import com.daniel.PrimeiraCamada.Magias.Escuridao;
import com.daniel.PrimeiraCamada.Magias.Fogo;
import com.daniel.PrimeiraCamada.Magias.Gelo;
import com.daniel.PrimeiraCamada.Magias.Luz;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeFogoNv1 extends Inimigo {
    public InimigoSlimeDeFogoNv1() {
        super("Slime de fogo pequeno", "/com.daniel.Images/Inimigos/Slime Firei.png", 5, 35, 15, 15, 15, 25, 28, TiposElementais.Fogo, Comportamentos.padrao, 150, 50);
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.absorcao = new TiposElementais[]{TiposElementais.Fogo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Agua, TiposElementais.Gelo};
        this.magias.add(new Fogo());
        this.lootTable.AdicionarEntrada(new FragmentoFogo(), 1, 1, 0.5);
        this.lootTable.AdicionarEntrada(new Banana(), 0, 1, 0.2);
    }
}
