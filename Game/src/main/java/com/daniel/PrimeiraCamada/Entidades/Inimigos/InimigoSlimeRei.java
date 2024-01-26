package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Magias.*;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeRei extends Inimigo {
    public InimigoSlimeRei() {
        super("Rei dos slimes", "/com.daniel.Images/Inimigos/Slime RPG King.png", 35, 60, 50, 10, 50, 2990, 5, TiposElementais.NaoElemental, Comportamentos.padrao, 50000, 15000);
        this.magias.add(new Enfraquecer());
        this.magias.add(new Amolecer());
        this.magias.add(new Fortalecer());
        this.magias.add(new IntDown());
        this.magias.add(new Slow());
        this.magias.add(new Curaga());
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
    }
}
