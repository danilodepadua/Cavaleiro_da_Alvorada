package com.daniel.Model.Dados.Entidades.Inimigos.Bosses;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Armas.EspadaGeloAperfeicoada;
import com.daniel.Model.Itens.Minerios.BarraGlacial;
import com.daniel.Model.Itens.Minerios.FragM.*;
import com.daniel.Model.Itens.Minerios.FragP.*;
import com.daniel.Model.Itens.Minerios.Joias.*;
import com.daniel.Model.Itens.Pocoes.TonicoDoHeroi;
import com.daniel.Model.Magias.Poderes.Gelo;
import com.daniel.Model.Magias.Poderes.Slow;
import com.daniel.Model.Magias.Poderes.Stop;
import com.daniel.Model.Magias.TiposElementais;

public class BossMontanhaDoNorte extends Inimigo {
    public BossMontanhaDoNorte() {
        super("Cryo Maiden", "/com.daniel.Images/Inimigos/Megapack III Elemental Lords Ice Maiden.png", 78, 52, 57, 72, 57, 72, 45000, 5000, TiposElementais.NaoElemental, Comportamentos.BossNeve, 67500, 45000);
        this.absorcao = new TiposElementais[]{TiposElementais.Gelo};
        this.resistencias = new TiposElementais[]{TiposElementais.Agua};
        this.fraquezas = new TiposElementais[]{TiposElementais.Fogo};
        this.magias.add(new Gelo());
        this.magias.add(new Stop());
        this.magias.add(new Slow());
        this.lootTable.AdicionarEntrada(new EspadaGeloAperfeicoada(), 0, 1, 0.65);
        this.lootTable.AdicionarEntrada(new EspadaGeloAperfeicoada(), 0, 1, 0.55);
        this.lootTable.AdicionarEntrada(new BarraGlacial(), 0, 2, 0.7);
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
