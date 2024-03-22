package com.daniel.Model.Dados.Entidades.Inimigos.Bosses;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Armas.EspadaDemoniaca;
import com.daniel.Model.Itens.Minerios.BarraEscuridao;
import com.daniel.Model.Itens.Minerios.FragM.*;
import com.daniel.Model.Itens.Minerios.FragP.*;
import com.daniel.Model.Itens.Minerios.Joias.*;
import com.daniel.Model.Itens.Pocoes.TonicoDoHeroi;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Magias.TiposElementais;

public class BossFinal2 extends Inimigo {
    public BossFinal2() {
        super("Besta abissal", "/com.daniel.Images/Inimigos/Boss Eldritch God Shaccad'Yoggoth.png", 82, 72, 72, 72, 72, 72,55000, 10000, TiposElementais.Escuridao, Comportamentos.BossFinal2, 82500, 55000);
        this.fraquezas = new TiposElementais[]{TiposElementais.Luz};
        this.absorcao = new TiposElementais[]{TiposElementais.Escuridao};
        this.magias.add(new Escuridao());
        this.magias.add(new IntDown());
        this.magias.add(new Amolecer());
        this.magias.add(new Slow());
        this.magias.add(new Enfraquecer());
        this.magias.add(new Stop());
        this.lootTable.AdicionarEntrada(new BarraEscuridao(), 5,10,0.7);
        this.lootTable.AdicionarEntrada(new EspadaDemoniaca(),1,1,1);
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
