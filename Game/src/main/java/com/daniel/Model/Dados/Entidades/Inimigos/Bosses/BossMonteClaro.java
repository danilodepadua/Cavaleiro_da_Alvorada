package com.daniel.Model.Dados.Entidades.Inimigos.Bosses;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Itens.Minerios.FragM.*;
import com.daniel.Model.Itens.Minerios.FragP.*;
import com.daniel.Model.Itens.Minerios.Joias.*;
import com.daniel.Model.Itens.Minerios.Ouro;
import com.daniel.Model.Itens.Pocoes.TonicoDoHeroi;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Magias.TiposElementais;

public class BossMonteClaro extends Inimigo {
    public BossMonteClaro() {
        super("Behemoth", "com.daniel.Images/Inimigos/Megapack III Behemoth.png", 32, 47, 27, 57, 22, 32,20000, 5000, TiposElementais.Terra, Comportamentos.BossMontanha, 30000, 20000);
        this.absorcao = new TiposElementais[]{TiposElementais.Terra};
        this.resistencias = new TiposElementais[]{TiposElementais.Fogo, TiposElementais.Vento,TiposElementais.NaoElemental};
        this.fraquezas = new TiposElementais[]{TiposElementais.Eletrico};
        this.lootTable.AdicionarEntrada(new Ferro(),4,7,0.4);
        this.lootTable.AdicionarEntrada(new Ouro(),2,6,0.6);
        this.magias.add(new Terra());
        this.magias.add(new ParedeTerra());
        this.magias.add(new Endurecer());
        this.magias.add(new Recuperar());
        this.magias.add(new Cegar());
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
