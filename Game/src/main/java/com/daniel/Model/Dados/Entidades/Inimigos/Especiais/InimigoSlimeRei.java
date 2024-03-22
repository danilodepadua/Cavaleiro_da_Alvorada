package com.daniel.Model.Dados.Entidades.Inimigos.Especiais;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.FragM.*;
import com.daniel.Model.Itens.Minerios.FragP.*;
import com.daniel.Model.Itens.Minerios.Joias.*;
import com.daniel.Model.Itens.Pocoes.TonicoDoHeroi;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoSlimeRei extends Inimigo {
    public InimigoSlimeRei() {
        super("Rei dos slimes", "/com.daniel.Images/Inimigos/Slime RPG King.png", 79, 60, 50, 10, 50, 50,40000, 5555, TiposElementais.NaoElemental, Comportamentos.padrao, 60000, 40000);
        this.magias.add(new Enfraquecer());
        this.magias.add(new Amolecer());
        this.magias.add(new Fortalecer());
        this.magias.add(new IntDown());
        this.magias.add(new Slow());
        this.magias.add(new Curaga());
        this.magias.add(new Regen());
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
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
