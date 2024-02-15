package com.daniel.Model.Dados.Entidades.Inimigos.Viloes;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Magias.TiposElementais;

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
