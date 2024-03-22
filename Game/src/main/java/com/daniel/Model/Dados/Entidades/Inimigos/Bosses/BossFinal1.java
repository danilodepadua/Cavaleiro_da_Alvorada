package com.daniel.Model.Dados.Entidades.Inimigos.Bosses;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.BarraEscuridao;
import com.daniel.Model.Itens.Minerios.FragM.*;
import com.daniel.Model.Itens.Minerios.FragP.*;
import com.daniel.Model.Itens.Minerios.Joias.*;
import com.daniel.Model.Itens.Pocoes.TonicoDoHeroi;
import com.daniel.Model.Magias.*;
import com.daniel.Model.Magias.Poderes.*;

public class BossFinal1 extends Inimigo {
    public BossFinal1() {
        super("Mago abissal", "/com.daniel.Images/Inimigos/Dark Elves Crystal Mage.png", 81, 54, 49, 64, 74, 72,9000, 20000, TiposElementais.NaoElemental, Comportamentos.BossFinal1, 750000, 50000);
        this.absorcao = new TiposElementais[]{TiposElementais.Escuridao};
        this.magias.add(new Escuridao());
        this.magias.add(new Enfraquecer());
        this.magias.add(new Fortalecer());
        this.magias.add(new Amolecer());
        this.magias.add(new Endurecer());
        this.magias.add(new IntUp());
        this.magias.add(new IntDown());
        this.magias.add(new Stop());
        this.magias.add(new Fast());
        this.magias.add(new Slow());
        this.magias.add(new Fortalecer());
        this.magias.add(new Fortalecer());
        this.lootTable.AdicionarEntrada(new BarraEscuridao(),2,7,0.5);
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