package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.ComportamentosInimigos.ComportamentoPadrao;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Magias.Splash;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoSlimeDeAguaNv1 extends Inimigo {
    public InimigoSlimeDeAguaNv1() {
        super("Slime de água pequeno", "/com.daniel.Images/Inimigos/Slime Wateri.png", 11, 20, 15, 15, 25, 30, 50, TiposElementais.Agua, Comportamentos.padrao, 200, 50);
        this.magias.add(new Splash());
        this.resistencias = new TiposElementais[]{TiposElementais.Terra};
        this.imunidades = new TiposElementais[]{ TiposElementais.NaoElemental};
        this.fraquezas = new TiposElementais[]{TiposElementais.Eletrico, TiposElementais.Fogo};
        this.absorcao = new TiposElementais[]{TiposElementais.Agua};
    }
}
