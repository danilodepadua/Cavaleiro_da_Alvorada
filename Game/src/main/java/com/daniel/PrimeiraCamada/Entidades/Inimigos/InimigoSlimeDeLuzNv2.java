package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Magias.*;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeLuzNv2 extends Inimigo {
    public InimigoSlimeDeLuzNv2() {
        super("Slime de luz médio", "/com.daniel.Images/Inimigos/Slime Holyii.png", 27,25, 45, 35, 30, 55, 150, TiposElementais.Luz, Comportamentos.padrao, 100, 5);
        this.magias.add(new Luz());
        this.magias.add(new IntUp());
        this.magias.add(new Cura());
        this.absorcao = new TiposElementais[]{TiposElementais.Luz};
        this.fraquezas = new TiposElementais[]{TiposElementais.Escuridao};
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
    }
}
