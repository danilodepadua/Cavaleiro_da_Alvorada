package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Itens.Comidas.Banana;
import com.daniel.PrimeiraCamada.Itens.Minerios.FragmentoFogo;
import com.daniel.PrimeiraCamada.Magias.*;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeLuzNv1 extends Inimigo {
    public InimigoSlimeDeLuzNv1() {
        super("Slime de luz pequeno", "/com.daniel.Images/Inimigos/Slime Holyi.png", 26, 20, 35, 15, 25, 45, 50, TiposElementais.Luz, Comportamentos.padrao, 250, 150);
        this.magias.add(new Luz());
        this.magias.add(new Cure());
        this.absorcao = new TiposElementais[]{TiposElementais.Fogo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Escuridao};
        this.imunidades = new TiposElementais[]{TiposElementais.Luz};
        this.lootTable.AdicionarEntrada(new Banana(), 1, 1, 0.3);
    }
}
