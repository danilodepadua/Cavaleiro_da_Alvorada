package com.daniel.Model.Dados.Entidades.Inimigos.Desapoles;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.FragP.FragVel;
import com.daniel.Model.Itens.Minerios.FragmentoFogo;
import com.daniel.Model.Itens.Pocoes.Antidoto;
import com.daniel.Model.Itens.Pocoes.PocaoCura;
import com.daniel.Model.Itens.Pocoes.TonicoDeVelocidade;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoGoblin1 extends Inimigo {
    public InimigoGoblin1() {
        super("Goblin Archer", "/com.daniel.Images/Inimigos/Goblin Archer.png", 10, 20, 20, 20, 29, 26,5600, 40, TiposElementais.NaoElemental, Comportamentos.padrao, 1200, 600);
        this.magias.add(new Fast());
        this.magias.add(new Veneno());
        this.magias.add(new Slow());
        this.lootTable.AdicionarEntrada(new FragVel(), 0, 1, 0.1);
        this.lootTable.AdicionarEntrada(new TonicoDeVelocidade(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new Antidoto(), 0, 2, 0.5);
        this.lootTable.AdicionarEntrada(new PocaoCura(), 0, 5, 0.5);
    }
}
