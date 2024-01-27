package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Magias.Redemoinho;
import com.daniel.PrimeiraCamada.Magias.Splash;
import com.daniel.PrimeiraCamada.Magias.WaterSpyke;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeAguaNv3 extends Inimigo {
    public InimigoSlimeDeAguaNv3() {
        super("Slime de água grande", "/com.daniel.Images/Inimigos/Slime Wateriii.png", 13, 35, 30, 35, 40, 115, 90, TiposElementais.Agua, Comportamentos.padrao, 500, 350);
        this.resistencias = new TiposElementais[]{TiposElementais.Terra};
        this.imunidades = new TiposElementais[]{ TiposElementais.NaoElemental};
        this.fraquezas = new TiposElementais[]{TiposElementais.Eletrico, TiposElementais.Fogo};
        this.absorcao = new TiposElementais[]{TiposElementais.Agua};
        this.magias.add(new Splash());
        this.magias.add(new WaterSpyke());
        this.magias.add(new Redemoinho());
    }
}
