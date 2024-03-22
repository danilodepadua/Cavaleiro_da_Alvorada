package com.daniel.Model.Dados.Entidades.Inimigos.CidadePortuaria;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.FragM.FragForceM;
import com.daniel.Model.Itens.Minerios.FragM.FragVelM;
import com.daniel.Model.Itens.Minerios.FragP.FragForce;
import com.daniel.Model.Itens.Minerios.FragP.FragVel;
import com.daniel.Model.Itens.Minerios.FragmentoFogo;
import com.daniel.Model.Itens.Pocoes.Antidoto;
import com.daniel.Model.Itens.Pocoes.PocaoCura;
import com.daniel.Model.Itens.Pocoes.PocaoMp;
import com.daniel.Model.Itens.Pocoes.PocaoVisao;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoPirata extends Inimigo {
    public InimigoPirata() {
        super("Pirata", "/com.daniel.Images/Inimigos/Pirate Bandit.png", 60, 58, 45, 45, 50, 52,16500, 150, TiposElementais.NaoElemental, Comportamentos.padrao, 6600, 3300);
        this.magias.add(new Fortalecer());
        this.magias.add(new Fast());
        this.magias.add(new Roubo());
        this.magias.add(new Cegar());
        this.magias.add(new Veneno());
        this.lootTable.AdicionarEntrada(new PocaoCura(), 1, 3, 0.7);
        this.lootTable.AdicionarEntrada(new PocaoMp(), 1, 3, 0.7);
        this.lootTable.AdicionarEntrada(new FragForce(), 0, 1, 0.01);
        this.lootTable.AdicionarEntrada(new FragForceM(), 0, 1, 0.005);
        this.lootTable.AdicionarEntrada(new Antidoto(), 0, 3, 0.5);
        this.lootTable.AdicionarEntrada(new PocaoVisao(), 0, 3, 0.5);
    }
}
