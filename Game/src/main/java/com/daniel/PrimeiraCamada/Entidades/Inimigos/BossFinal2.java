package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.Magias.*;
import com.daniel.PrimeiraCamada.TiposElementais;

public class BossFinal2 extends Inimigo {
    public BossFinal2() {
        super("Besta abissal", "/com.daniel.Images/Inimigos/Boss Eldritch God Shaccad'Yoggoth.png", 40, 80, 70, 40, 40, 10000, 10000, TiposElementais.Escuridao, Comportamentos.BossFinal2, 1000000, 999999);
        this.fraquezas = new TiposElementais[]{TiposElementais.Luz};
        this.absorcao = new TiposElementais[]{TiposElementais.Escuridao};
        this.magias.add(new Escuridao());
        this.magias.add(new IntDown());
        this.magias.add(new Amolecer());
        this.magias.add(new Slow());
        this.magias.add(new Enfraquecer());
    }
}
