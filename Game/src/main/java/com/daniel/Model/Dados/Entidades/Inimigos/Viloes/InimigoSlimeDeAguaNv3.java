package com.daniel.Model.Dados.Entidades.Inimigos.Viloes;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.FragmentoGlacial;
import com.daniel.Model.Magias.Poderes.Redemoinho;
import com.daniel.Model.Magias.Poderes.Splash;
import com.daniel.Model.Magias.Poderes.WaterSpyke;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoSlimeDeAguaNv3 extends Inimigo {
    public InimigoSlimeDeAguaNv3() {
        super("Slime de água grande", "/com.daniel.Images/Inimigos/Slime Wateriii.png", 13, 35, 30, 35, 40, 30,115, 90, TiposElementais.Agua, Comportamentos.padrao, 500, 350);
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
