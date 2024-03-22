package com.daniel.Model.Dados.Entidades.Inimigos.Desapoles;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.FragP.FragInt;
import com.daniel.Model.Itens.Minerios.FragmentoFogo;
import com.daniel.Model.Itens.Pocoes.Antidoto;
import com.daniel.Model.Itens.Pocoes.PocaoMp;
import com.daniel.Model.Itens.Pocoes.PocaoVisao;
import com.daniel.Model.Itens.Pocoes.TonicoDeInteligencia;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoGoblin4 extends Inimigo {
    public InimigoGoblin4() {
        super("Goblin Mage", "/com.daniel.Images/Inimigos/Goblin Mage.png", 13, 25, 35, 20, 20, 25,6500, 200, TiposElementais.NaoElemental, Comportamentos.padrao, 2000, 1000);
        this.resistencias = new TiposElementais[]{TiposElementais.Fogo,TiposElementais.Terra,TiposElementais.Agua,TiposElementais.Eletrico,TiposElementais.Gelo,TiposElementais.Escuridao};
        this.fraquezas = new TiposElementais[]{TiposElementais.NaoElemental,TiposElementais.Luz};
        this.magias.add(new Fogo());
        this.magias.add(new Vento());
        this.magias.add(new Veneno());
        this.magias.add(new Gelo());
        this.magias.add(new Terra());
        this.magias.add(new Splash());
        this.magias.add(new Adormecer());
        this.magias.add(new Cegar());
        this.magias.add(new Raio());
        this.lootTable.AdicionarEntrada(new FragInt(), 0, 1, 0.01);
        this.lootTable.AdicionarEntrada(new TonicoDeInteligencia(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new Antidoto(), 0, 2, 0.2);
        this.lootTable.AdicionarEntrada(new PocaoVisao(), 0, 2, 0.2);
        this.lootTable.AdicionarEntrada(new PocaoMp(), 0, 2, 0.5);
    }
}
