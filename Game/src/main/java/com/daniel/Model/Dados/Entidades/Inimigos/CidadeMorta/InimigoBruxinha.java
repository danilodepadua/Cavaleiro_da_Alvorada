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
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoBruxinha extends Inimigo {
    public InimigoBruxinha() {
        super("Bruxa", "/com.daniel.Images/Inimigos/Halloween Witch.png", 47, 30, 48, 38, 40, 39,11000, 280, TiposElementais.NaoElemental, Comportamentos.padrao, 4400, 2200);
        this.absorcao = new TiposElementais[]{TiposElementais.Escuridao};
        this.fraquezas = new TiposElementais[]{TiposElementais.Luz};
        this.magias.add(new Escuridao());
        this.magias.add(new Amolecer());
        this.magias.add(new Enfraquecer());
        this.magias.add(new IntDown());
        this.magias.add(new Silenciar());
        this.magias.add(new Cegar());
        this.magias.add(new Veneno());
        this.lootTable.AdicionarEntrada(new FragmentoEscuridao(), 1, 2, 0.5);
        this.lootTable.AdicionarEntrada(new FragIntM(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new FragInt(), 0, 1, 0.1);
        this.lootTable.AdicionarEntrada(new TonicoDeInteligencia(), 0, 1, 0.2);
    }
}
