package com.daniel.Dados.EntidadesRepositório.Inimigos;

import com.daniel.Modelo.ComportamentosInimigos.Comportamentos;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Itens.Minerios.FragmentoGlacial;
import com.daniel.Modelo.Magia.Poderes.Redemoinho;
import com.daniel.Modelo.Magia.Poderes.Splash;
import com.daniel.Modelo.Magia.Poderes.WaterSpyke;
import com.daniel.Modelo.Magia.TiposElementais;

public class InimigoSlimeDeAguaNv3 extends Inimigo {
    public InimigoSlimeDeAguaNv3() {
        super("Slime de água grande", "/com.daniel.Images/Inimigos/Slime Wateriii.png", 13, 35, 30, 35, 40, 115, 90, TiposElementais.Agua, Comportamentos.padrao, 500, 350);
        this.resistencias = new TiposElementais[]{TiposElementais.Terra};
        this.imunidades = new TiposElementais[]{ TiposElementais.Fogo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Eletrico};
        this.absorcao = new TiposElementais[]{TiposElementais.Agua};
        this.magias.add(new Splash());
        this.magias.add(new WaterSpyke());
        this.magias.add(new Redemoinho());
        this.lootTable.AdicionarEntrada(new FragmentoGlacial(), 1, 1, 0.5);

    }
}
