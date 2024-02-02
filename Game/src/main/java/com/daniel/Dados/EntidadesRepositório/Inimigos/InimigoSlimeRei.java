package com.daniel.Dados.EntidadesRepositório.Inimigos;

import com.daniel.Modelo.ComportamentosInimigos.Comportamentos;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Magia.Poderes.*;
import com.daniel.Modelo.Magia.TiposElementais;

public class InimigoSlimeRei extends Inimigo {
    public InimigoSlimeRei() {
        super("Rei dos slimes", "/com.daniel.Images/Inimigos/Slime RPG King.png", 36, 60, 50, 10, 50, 2990, 5, TiposElementais.NaoElemental, Comportamentos.padrao, 50000, 15000);
        this.magias.add(new Enfraquecer());
        this.magias.add(new Amolecer());
        this.magias.add(new Fortalecer());
        this.magias.add(new IntDown());
        this.magias.add(new Slow());
        this.magias.add(new Curaga());
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
    }
}
