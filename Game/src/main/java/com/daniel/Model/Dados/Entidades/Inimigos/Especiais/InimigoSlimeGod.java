package com.daniel.Model.Dados.Entidades.Inimigos.Especiais;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.FragM.*;
import com.daniel.Model.Itens.Minerios.FragP.*;
import com.daniel.Model.Itens.Minerios.Joias.*;
import com.daniel.Model.Itens.Pocoes.TonicoDoHeroi;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoSlimeGod extends Inimigo {
    public InimigoSlimeGod() {
        super("Slime primordial", "com.daniel.Images/Inimigos/Slime RPG King.png", 80, 45, 87, 10, 73, 60,50000, 9999, TiposElementais.NaoElemental, Comportamentos.padrao, 75000, 50000);
        this.magias.add(new Enfraquecer());
        this.magias.add(new Enfraquecer());
        this.magias.add(new Amolecer());
        this.magias.add(new Fortalecer());
        this.magias.add(new IntDown());
        this.magias.add(new Endurecer());
        this.magias.add(new IntUp());
        this.magias.add(new Silenciar());
        this.magias.add(new Dessilenciar());
        this.magias.add(new Fast());
        this.magias.add(new Slow());
        this.magias.add(new Stop());
        this.magias.add(new Veneno());
        this.magias.add(new Desenvenenar());
        this.magias.add(new Adormecer());
        this.magias.add(new Curaga());
        this.magias.add(new Cegar());
        this.magias.add(new Visao());
        this.magias.add(new Recuperar());
        this.magias.add(new Redemoinho());
        this.magias.add(new Explosao());
        this.magias.add(new Escuridao());
        this.magias.add(new Luz());
        this.magias.add(new Gelo());
        this.magias.add(new Raio());
        this.magias.add(new ParedeTerra());
        this.magias.add(new AirBlast());
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
