package com.daniel.Model.Dados.Entidades.Inimigos.CidadePortuaria;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.FragM.FragSorteM;
import com.daniel.Model.Itens.Minerios.FragM.FragVelM;
import com.daniel.Model.Itens.Minerios.FragP.FragSorte;
import com.daniel.Model.Itens.Minerios.FragP.FragVel;
import com.daniel.Model.Itens.Minerios.FragmentoFogo;
import com.daniel.Model.Itens.Pocoes.PocaoCura;
import com.daniel.Model.Itens.Pocoes.PocaoMp;
import com.daniel.Model.Itens.Pocoes.TonicoDeSorte;
import com.daniel.Model.Itens.Pocoes.TonicoDeVelocidade;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoMacacoPirata extends Inimigo {
    public InimigoMacacoPirata() {
        super("Macaco pirata", "/com.daniel.Images/Inimigos/Pirate Monkey.png", 59, 58, 40, 44, 54, 49,16000, 200, TiposElementais.NaoElemental, Comportamentos.padrao, 6400, 3200);
        this.resistencias = new TiposElementais[]{TiposElementais.Fogo};
        this.magias.add(new Fogo());
        this.magias.add(new Explosao());
        this.magias.add(new Cegar());
        this.magias.add(new Roubo());
        this.lootTable.AdicionarEntrada(new PocaoCura(), 1, 3, 0.7);
        this.lootTable.AdicionarEntrada(new PocaoMp(), 1, 3, 0.7);
        this.lootTable.AdicionarEntrada(new TonicoDeVelocidade(), 0, 1, 0.1);
        this.lootTable.AdicionarEntrada(new TonicoDeSorte(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new FragVel(), 0, 1, 0.01);
        this.lootTable.AdicionarEntrada(new FragVelM(), 0, 1, 0.005);
        this.lootTable.AdicionarEntrada(new FragSorte(), 0, 1, 0.01);
        this.lootTable.AdicionarEntrada(new FragSorteM(), 0, 1, 0.005);
    }
}
