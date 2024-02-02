package com.daniel.Dados.EntidadesRepositório.Inimigos;

import com.daniel.Modelo.ComportamentosInimigos.Comportamentos;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Magia.Poderes.Redemoinho;
import com.daniel.Modelo.Magia.Poderes.Splash;
import com.daniel.Modelo.Magia.Poderes.WaterSpyke;
import com.daniel.Modelo.Magia.TiposElementais;

public class BossIlha extends Inimigo {
    public BossIlha() {
        super("Leviatahn", "/com.daniel.Images/Inimigos/Boss Sea Dragon Leviathan.png", 38, 50, 42, 30, 50, 3000, 5000, TiposElementais.NaoElemental, Comportamentos.BossAquatico, 30000, 25000);
        this.absorcao = new TiposElementais[]{TiposElementais.Agua};
        this.resistencias = new TiposElementais[]{TiposElementais.Gelo, TiposElementais.Vento};
        this.fraquezas = new TiposElementais[]{TiposElementais.Eletrico};
        this.magias.add(new Redemoinho());
        this.magias.add(new WaterSpyke());
        this.magias.add(new Splash());
    }
}
