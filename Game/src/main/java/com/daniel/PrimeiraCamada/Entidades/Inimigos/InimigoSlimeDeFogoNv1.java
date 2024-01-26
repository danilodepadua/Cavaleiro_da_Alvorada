package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Itens.Comidas.Banana;
import com.daniel.PrimeiraCamada.Itens.Comidas.CoxaFrango;
import com.daniel.PrimeiraCamada.Itens.Minerios.BarraFerro;
import com.daniel.PrimeiraCamada.Itens.Minerios.Ferro;
import com.daniel.PrimeiraCamada.Magias.Escuridao;
import com.daniel.PrimeiraCamada.Magias.Fogo;
import com.daniel.PrimeiraCamada.Magias.Gelo;
import com.daniel.PrimeiraCamada.Magias.Luz;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeFogoNv1 extends Inimigo {
    public InimigoSlimeDeFogoNv1() {
        super("Slime de fogo pequeno", "/com.daniel.Images/Inimigos/Slime Firei.png", 5, 5, 5, 5, 5, 5, 5, TiposElementais.Gelo, Comportamentos.padrao, 100, 5);
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.magias.add(new Fogo());
        this.magias.add(new Gelo());
        this.magias.add(new Luz());
        this.magias.add(new Escuridao());
        this.lootTable.AdicionarEntrada(new CoxaFrango(), 1, 2, 0.5);
        this.lootTable.AdicionarEntrada(new Banana(), 1, 2, 0.2);
        this.lootTable.AdicionarEntrada(new BarraFerro(), 1, 2, 0.1);
        this.lootTable.AdicionarEntrada(new Ferro(), 1, 2, 0.8);
    }
}
