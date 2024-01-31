package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Magias.Redemoinho;
import com.daniel.PrimeiraCamada.Magias.Splash;
import com.daniel.PrimeiraCamada.Magias.WaterSpyke;
import com.daniel.PrimeiraCamada.TiposElementais;

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
