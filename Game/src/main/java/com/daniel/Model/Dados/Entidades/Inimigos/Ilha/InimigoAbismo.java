package com.daniel.Model.Dados.Entidades.Inimigos.Ilha;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Armas.Tridente;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Itens.Minerios.FragM.FragIntM;
import com.daniel.Model.Itens.Minerios.FragP.FragInt;
import com.daniel.Model.Itens.Pocoes.PocaoMp;
import com.daniel.Model.Itens.Pocoes.PocaoMpGrande;
import com.daniel.Model.Itens.Pocoes.TonicoDeForca;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoAbismo extends Inimigo {
    public InimigoAbismo() {
        super("Abissal", "/com.daniel.Images/Inimigos/Sea Abismos.png", 69, 64, 50, 44, 58, 54,18500, 400, TiposElementais.NaoElemental, Comportamentos.padrao, 7400, 3700);
        this.resistencias = new TiposElementais[]{TiposElementais.Terra};
        this.imunidades = new TiposElementais[]{ TiposElementais.Fogo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Eletrico};
        this.absorcao = new TiposElementais[]{TiposElementais.Agua};
        this.magias.add(new Splash());
        this.magias.add(new WaterSpyke());
        this.magias.add(new Redemoinho());
        this.magias.add(new Fortalecer());
        this.magias.add(new Fast());
        this.lootTable.AdicionarEntrada(new FragIntM(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new FragInt(), 0, 2, 0.1);
        this.lootTable.AdicionarEntrada(new PocaoMpGrande(), 0, 1, 0.1);
        this.lootTable.AdicionarEntrada(new PocaoMp(), 0, 1, 0.3);
        this.lootTable.AdicionarEntrada(new TonicoDeForca(), 0,1,0.1);
        this.lootTable.AdicionarEntrada(new Tridente(),0,1,0.05);
    }
}
