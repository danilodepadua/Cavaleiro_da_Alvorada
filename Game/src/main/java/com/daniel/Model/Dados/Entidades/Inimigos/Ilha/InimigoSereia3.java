package com.daniel.Model.Dados.Entidades.Inimigos.Ilha;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Itens.Minerios.FragM.FragIntM;
import com.daniel.Model.Itens.Minerios.FragP.FragInt;
import com.daniel.Model.Itens.Pocoes.PocaoMp;
import com.daniel.Model.Itens.Pocoes.PocaoMpGrande;
import com.daniel.Model.Magias.Poderes.Redemoinho;
import com.daniel.Model.Magias.Poderes.Splash;
import com.daniel.Model.Magias.Poderes.WaterSpyke;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoSereia3 extends Inimigo {
    public InimigoSereia3() {
        super("Sword mermaid", "/com.daniel.Images/Inimigos/Sea Mermaid Warrior Sasha.png", 68, 64, 50, 50, 56, 40,17500, 300, TiposElementais.NaoElemental, Comportamentos.padrao, 7000, 3500);
        this.resistencias = new TiposElementais[]{TiposElementais.Terra};
        this.imunidades = new TiposElementais[]{ TiposElementais.Fogo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Eletrico};
        this.absorcao = new TiposElementais[]{TiposElementais.Agua};
        this.magias.add(new Splash());
        this.magias.add(new WaterSpyke());
        this.magias.add(new Redemoinho());
        this.lootTable.AdicionarEntrada(new FragIntM(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new FragInt(), 0, 2, 0.1);
        this.lootTable.AdicionarEntrada(new PocaoMpGrande(), 0, 2, 0.1);
        this.lootTable.AdicionarEntrada(new PocaoMp(), 0, 2, 0.3);
    }
}
