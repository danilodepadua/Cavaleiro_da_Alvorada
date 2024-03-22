package com.daniel.Model.Dados.Entidades.Inimigos.CidadePortuaria;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.FragM.FragVelM;
import com.daniel.Model.Itens.Minerios.FragP.FragVel;
import com.daniel.Model.Itens.Pocoes.TonicoDoHeroi;
import com.daniel.Model.Magias.Poderes.Roubo;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoLadrao extends Inimigo {
    public InimigoLadrao() {
        super("Trombadinha", "/com.daniel.Images/Inimigos/Medieval Bandit Child.png", 57, 15, 30, 30, 70, 70,22000, 150, TiposElementais.NaoElemental, Comportamentos.fugitivo, 150000, 75000);
        this.magias.add(new Roubo());
        this.lootTable.AdicionarEntrada(new FragVelM(),1,2,0.05);
        this.lootTable.AdicionarEntrada(new FragVel(),1,2,0.1);
        this.lootTable.AdicionarEntrada(new TonicoDoHeroi(),0,2,0.1);
    }
}
