package com.daniel.Model.Dados.Entidades.Inimigos.CidadeMorta;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Itens.Minerios.FragM.FragForceM;
import com.daniel.Model.Itens.Minerios.FragM.FragIntM;
import com.daniel.Model.Itens.Minerios.FragP.FragForce;
import com.daniel.Model.Itens.Minerios.FragP.FragInt;
import com.daniel.Model.Itens.Minerios.FragmentoEscuridao;
import com.daniel.Model.Itens.Pocoes.TonicoDeForca;
import com.daniel.Model.Itens.Pocoes.TonicoDeInteligencia;
import com.daniel.Model.Magias.Poderes.Amolecer;
import com.daniel.Model.Magias.Poderes.Enfraquecer;
import com.daniel.Model.Magias.Poderes.Escuridao;
import com.daniel.Model.Magias.Poderes.IntDown;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoAboboraCavalheira extends Inimigo {
    public InimigoAboboraCavalheira() {
        super("Abobora", "/com.daniel.Images/Inimigos/Halloween Pumpkin Gentleman.png", 48, 40, 50, 35, 40, 40,12000, 330, TiposElementais.NaoElemental, Comportamentos.padrao, 4800, 2400);
        this.absorcao = new TiposElementais[]{TiposElementais.Escuridao};
        this.resistencias = new TiposElementais[]{TiposElementais.NaoElemental};
        this.fraquezas = new TiposElementais[]{TiposElementais.Luz};
        this.magias.add(new Escuridao());
        this.magias.add(new Amolecer());
        this.magias.add(new Enfraquecer());
        this.magias.add(new IntDown());
        this.lootTable.AdicionarEntrada(new FragmentoEscuridao(), 1, 2, 0.5);
        this.lootTable.AdicionarEntrada(new FragIntM(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new FragInt(), 0, 1, 0.1);
        this.lootTable.AdicionarEntrada(new TonicoDeInteligencia(), 0, 1, 0.2);
    }
}
