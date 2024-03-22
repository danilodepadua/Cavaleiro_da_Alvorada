package com.daniel.Model.Dados.Entidades.Inimigos.CidadePortuaria;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.FragM.FragVelM;
import com.daniel.Model.Itens.Minerios.FragP.FragVel;
import com.daniel.Model.Itens.Minerios.FragmentoFogo;
import com.daniel.Model.Itens.Pocoes.PocaoCura;
import com.daniel.Model.Itens.Pocoes.PocaoMp;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoAvePirata extends Inimigo {
    public InimigoAvePirata() {
        super("Canario", "/com.daniel.Images/Inimigos/Pirate Parrot.png", 58, 51, 45, 40, 54, 50,15500, 35, TiposElementais.Vento, Comportamentos.padrao, 6200, 3100);
        this.resistencias = new TiposElementais[]{TiposElementais.Vento};
        this.fraquezas = new TiposElementais[]{TiposElementais.Terra,TiposElementais.NaoElemental};
        this.magias.add(new Vento());
        this.magias.add(new AirBlast());
        this.magias.add(new Roubo());
        this.lootTable.AdicionarEntrada(new PocaoCura(), 1, 3, 0.7);
        this.lootTable.AdicionarEntrada(new PocaoMp(), 1, 3, 0.7);
        this.lootTable.AdicionarEntrada(new FragVel(), 0, 1, 0.01);
        this.lootTable.AdicionarEntrada(new FragVelM(), 0, 1, 0.005);
    }
}
