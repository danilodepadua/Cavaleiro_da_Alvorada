package com.daniel.Model.Dados.Entidades.Inimigos.Ilha;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Itens.Minerios.FragM.FragIntM;
import com.daniel.Model.Itens.Minerios.FragM.FragResM;
import com.daniel.Model.Itens.Minerios.FragP.FragInt;
import com.daniel.Model.Itens.Minerios.FragP.FragRes;
import com.daniel.Model.Itens.Pocoes.PocaoMp;
import com.daniel.Model.Itens.Pocoes.PocaoMpGrande;
import com.daniel.Model.Itens.Pocoes.TonicoDeResistencia;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoGolenTartaruga extends Inimigo {
    public InimigoGolenTartaruga() {
        super("Turtle Golem", "/com.daniel.Images/Inimigos/Sea Beach Turtle Golem.png", 64, 53, 50, 72, 40, 50,18000, 300, TiposElementais.NaoElemental, Comportamentos.padrao, 7200, 3600);
        this.resistencias = new TiposElementais[]{TiposElementais.Terra};
        this.imunidades = new TiposElementais[]{ TiposElementais.Fogo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Eletrico};
        this.absorcao = new TiposElementais[]{TiposElementais.Agua};
        this.magias.add(new Splash());
        this.magias.add(new WaterSpyke());
        this.magias.add(new Redemoinho());
        this.magias.add(new Fortalecer());
        this.magias.add(new Endurecer());
        this.lootTable.AdicionarEntrada(new Ferro(), 1, 1, 0.6);
        this.lootTable.AdicionarEntrada(new FragResM(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new FragRes(), 0, 2, 0.1);
        this.lootTable.AdicionarEntrada(new PocaoMpGrande(), 0, 1, 0.1);
        this.lootTable.AdicionarEntrada(new PocaoMp(), 0, 1, 0.3);
        this.lootTable.AdicionarEntrada(new TonicoDeResistencia(),0,1,0.1);
    }
}
