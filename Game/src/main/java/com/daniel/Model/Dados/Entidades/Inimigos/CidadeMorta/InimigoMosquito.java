package com.daniel.Model.Dados.Entidades.Inimigos.CidadeMorta;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Itens.Minerios.FragM.FragForceM;
import com.daniel.Model.Itens.Minerios.FragM.FragVelM;
import com.daniel.Model.Itens.Minerios.FragP.FragForce;
import com.daniel.Model.Itens.Minerios.FragP.FragVel;
import com.daniel.Model.Itens.Minerios.FragmentoEscuridao;
import com.daniel.Model.Itens.Pocoes.TonicoDeForca;
import com.daniel.Model.Itens.Pocoes.TonicoDeVelocidade;
import com.daniel.Model.Magias.Poderes.Amolecer;
import com.daniel.Model.Magias.Poderes.Enfraquecer;
import com.daniel.Model.Magias.Poderes.Escuridao;
import com.daniel.Model.Magias.Poderes.IntDown;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoMosquito extends Inimigo {
    public InimigoMosquito() {
        super("Fly", "/com.daniel.Images/Inimigos/Vampiric Creatures Giant Mosquito.png", 44, 38, 30, 30, 38, 34,8500, 170, TiposElementais.NaoElemental, Comportamentos.padrao, 3400, 1700);
        this.absorcao = new TiposElementais[]{TiposElementais.Escuridao};
        this.fraquezas = new TiposElementais[]{TiposElementais.Terra, TiposElementais.Fogo, TiposElementais.Eletrico};
        this.magias.add(new Escuridao());
        this.magias.add(new Amolecer());
        this.magias.add(new Enfraquecer());
        this.magias.add(new IntDown());
        this.lootTable.AdicionarEntrada(new FragmentoEscuridao(), 1, 2, 0.5);
        this.lootTable.AdicionarEntrada(new FragVelM(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new FragVel(), 0, 1, 0.1);
        this.lootTable.AdicionarEntrada(new TonicoDeVelocidade(), 0, 1, 0.2);
    }
}
