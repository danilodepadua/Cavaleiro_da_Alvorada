package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.*;
import com.daniel.PrimeiraCamada.Magias.*;

public class BossFinal1 extends Inimigo {
    public BossFinal1() {
        super("Mago abissal", "/com.daniel.Images/Inimigos/Dark Elves Crystal Mage.png", 38, 75, 80, 60, 55, 9000, 20000, TiposElementais.NaoElemental, Comportamentos.BossFinal1, 100000, 150000);
        this.absorcao = new TiposElementais[]{TiposElementais.Escuridao};
        this.magias.add(new Escuridao());
        this.magias.add(new Enfraquecer());
        this.magias.add(new Fortalecer());
        this.magias.add(new Amolecer());
        this.magias.add(new Endurecer());
        this.magias.add(new IntUp());
        this.magias.add(new IntDown());
        this.magias.add(new Stop());
        this.magias.add(new Fast());
        this.magias.add(new Slow());
        this.magias.add(new Fortalecer());
        this.magias.add(new Fortalecer());
    }
}