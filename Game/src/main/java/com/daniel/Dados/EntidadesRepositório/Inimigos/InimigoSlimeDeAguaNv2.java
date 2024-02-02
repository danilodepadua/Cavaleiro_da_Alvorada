package com.daniel.Dados.EntidadesRepositório.Inimigos;

import com.daniel.Modelo.ComportamentosInimigos.Comportamentos;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Itens.Minerios.FragmentoGlacial;
import com.daniel.Modelo.Magia.Poderes.Splash;
import com.daniel.Modelo.Magia.Poderes.WaterSpyke;
import com.daniel.Modelo.Magia.TiposElementais;

public class InimigoSlimeDeAguaNv2 extends Inimigo {
    public InimigoSlimeDeAguaNv2() {
        super("Slime de água médio", "/com.daniel.Images/Inimigos/Slime Waterii.png", 12, 30, 25, 25, 35,  75, 70, TiposElementais.Agua, Comportamentos.padrao, 350, 250);
        this.magias.add(new Splash());
        this.magias.add(new WaterSpyke());
        this.resistencias = new TiposElementais[]{TiposElementais.Terra};
        this.imunidades = new TiposElementais[]{ TiposElementais.Fogo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Eletrico};
        this.absorcao = new TiposElementais[]{TiposElementais.Agua};
        this.lootTable.AdicionarEntrada(new FragmentoGlacial(), 1, 1, 0.5);

    }
}
