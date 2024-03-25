package com.daniel.Model.Dados.Entidades.Inimigos.Ilha;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.FragM.FragIntM;
import com.daniel.Model.Itens.Minerios.FragP.FragInt;
import com.daniel.Model.Itens.Minerios.FragmentoGlacial;
import com.daniel.Model.Itens.Pocoes.PocaoMp;
import com.daniel.Model.Itens.Pocoes.PocaoMpGrande;
import com.daniel.Model.Magias.Poderes.Redemoinho;
import com.daniel.Model.Magias.Poderes.Splash;
import com.daniel.Model.Magias.Poderes.WaterSpyke;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoSlimeDeAguaNv3 extends Inimigo {
    public InimigoSlimeDeAguaNv3() {
        super("Slime de água grande", "/com.daniel.Images/Inimigos/Slime Wateriii.png", 63, 49, 49, 49, 49, 49,16000, 400, TiposElementais.Agua, Comportamentos.padrao, 6400, 3200);
        this.resistencias = new TiposElementais[]{TiposElementais.Terra};
        this.imunidades = new TiposElementais[]{ TiposElementais.Fogo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Eletrico};
        this.absorcao = new TiposElementais[]{TiposElementais.Agua};
        this.magias.add(new Splash());
        this.lootTable.AdicionarEntrada(new FragIntM(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new FragInt(), 0, 2, 0.1);
        this.lootTable.AdicionarEntrada(new PocaoMpGrande(), 0, 1, 0.1);
        this.lootTable.AdicionarEntrada(new PocaoMp(), 0, 1, 0.3);
    }
}
