package com.daniel.Model.Dados.Entidades.Inimigos.Bosses;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Armaduras.Calcas.CalcaMalha;
import com.daniel.Model.Itens.Armas.EspadaGeloAperfeicoada;
import com.daniel.Model.Itens.Armas.EspadaLuz;
import com.daniel.Model.Itens.Minerios.FragM.*;
import com.daniel.Model.Itens.Minerios.FragP.*;
import com.daniel.Model.Itens.Minerios.Joias.*;
import com.daniel.Model.Itens.Pocoes.TonicoDoHeroi;
import com.daniel.Model.Magias.Poderes.Redemoinho;
import com.daniel.Model.Magias.Poderes.Splash;
import com.daniel.Model.Magias.Poderes.WaterSpyke;
import com.daniel.Model.Magias.TiposElementais;

public class BossIlha extends Inimigo {
    public BossIlha() {
        super("Leviatahn", "/com.daniel.Images/Inimigos/Boss Sea Dragon Leviathan.png", 70, 55, 25, 40, 65, 70,38000, 5000, TiposElementais.Agua, Comportamentos.BossAquatico, 57000, 38000);
        this.absorcao = new TiposElementais[]{TiposElementais.Agua};
        this.resistencias = new TiposElementais[]{TiposElementais.Gelo, TiposElementais.Vento};
        this.fraquezas = new TiposElementais[]{TiposElementais.Eletrico};
        this.magias.add(new Redemoinho());
        this.magias.add(new WaterSpyke());
        this.magias.add(new Splash());
        this.lootTable.AdicionarEntrada(new EspadaLuz(),0,1,0.65);
        this.lootTable.AdicionarEntrada(new CalcaMalha(),0,1,0.75);
        this.lootTable.AdicionarEntrada(new JoiaForce(),1,2,0.1);
        this.lootTable.AdicionarEntrada(new JoiaInt(),1,2,0.1);
        this.lootTable.AdicionarEntrada(new JoiaRes(),1,2,0.1);
        this.lootTable.AdicionarEntrada(new JoiaVel(),1,2,0.1);
        this.lootTable.AdicionarEntrada(new JoiaSorte(),1,2,0.1);
        this.lootTable.AdicionarEntrada(new FragForce(),0,2,0.2);
        this.lootTable.AdicionarEntrada(new FragInt(),0,2,0.2);
        this.lootTable.AdicionarEntrada(new FragRes(),0,2,0.2);
        this.lootTable.AdicionarEntrada(new FragSorte(),0,2,0.2);
        this.lootTable.AdicionarEntrada(new FragVel(),0,2,0.2);
        this.lootTable.AdicionarEntrada(new FragVelM(),0,1,0.2);
        this.lootTable.AdicionarEntrada(new FragSorteM(),0,1,0.2);
        this.lootTable.AdicionarEntrada(new FragIntM(),0,1,0.2);
        this.lootTable.AdicionarEntrada(new FragForceM(),0,1,0.2);
        this.lootTable.AdicionarEntrada(new FragResM(),0,1,0.2);
        this.lootTable.AdicionarEntrada(new TonicoDoHeroi(),1,1,1);
    }
}
