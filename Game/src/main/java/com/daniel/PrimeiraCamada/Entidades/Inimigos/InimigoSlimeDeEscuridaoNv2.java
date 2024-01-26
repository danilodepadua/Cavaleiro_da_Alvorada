package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Magias.Amolecer;
import com.daniel.PrimeiraCamada.Magias.Enfraquecer;
import com.daniel.PrimeiraCamada.Magias.Escuridao;
import com.daniel.PrimeiraCamada.Magias.IntDown;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeEscuridaoNv2 extends Inimigo {
    public InimigoSlimeDeEscuridaoNv2() {
        super("Slime de escuridão médio", "/com.daniel.Images/Inimigos/Slime Darkii.png", 24, 35, 20, 45, 20, 40, 20, TiposElementais.Escuridao, Comportamentos.padrao, 200, 85);
        this.absorcao = new TiposElementais[]{TiposElementais.Escuridao};
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.fraquezas = new TiposElementais[]{TiposElementais.Luz};
        this.magias.add(new Escuridao());
        this.magias.add(new Amolecer());
        this.magias.add(new Enfraquecer());
        this.magias.add(new IntDown());
    }
}
