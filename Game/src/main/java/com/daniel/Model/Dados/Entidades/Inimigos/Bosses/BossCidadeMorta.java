package com.daniel.Model.Dados.Entidades.Inimigos.Bosses;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Armas.EspadaEletricaAperfeicoada;
import com.daniel.Model.Itens.Armas.EspadaSombriaAperfeicoada;
import com.daniel.Model.Itens.Armas.EspadaSombriaBasica;
import com.daniel.Model.Itens.Minerios.FragM.*;
import com.daniel.Model.Itens.Minerios.FragP.*;
import com.daniel.Model.Itens.Minerios.Joias.*;
import com.daniel.Model.Itens.Pocoes.TonicoDoHeroi;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Magias.TiposElementais;

public class BossCidadeMorta extends Inimigo {
    public BossCidadeMorta() {
        super("Master Witch", "/com.daniel.Images/Inimigos/Halloween Witch Baba.png", 49, 37, 57, 27, 47, 47,26000, 7000, TiposElementais.Escuridao, Comportamentos.BossBruxa, 39000, 26000);
        this.absorcao = new TiposElementais[]{TiposElementais.Escuridao};
        this.resistencias = new TiposElementais[]{TiposElementais.Gelo, TiposElementais.Vento};
        this.fraquezas = new TiposElementais[]{TiposElementais.Luz,TiposElementais.Fogo};
        this.magias.add(new Enfraquecer());
        this.magias.add(new Stop());
        this.magias.add(new Slow());
        this.magias.add(new IntDown());
        this.magias.add(new Amolecer());
        this.magias.add(new Veneno());
        this.lootTable.AdicionarEntrada(new EspadaSombriaAperfeicoada(),0,1,0.55);
        this.lootTable.AdicionarEntrada(new EspadaSombriaBasica(),1,1,1);
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
