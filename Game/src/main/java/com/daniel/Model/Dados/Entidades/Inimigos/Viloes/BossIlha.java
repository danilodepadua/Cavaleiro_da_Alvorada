package com.daniel.Model.Dados.Entidades.Inimigos.Viloes;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Dados.Magias.Poderes.Redemoinho;
import com.daniel.Model.Dados.Magias.Poderes.Splash;
import com.daniel.Model.Dados.Magias.Poderes.WaterSpyke;
import com.daniel.Model.Dados.Magias.TiposElementais;

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
