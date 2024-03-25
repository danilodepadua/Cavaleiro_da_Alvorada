package com.daniel.Model.Dados.Entidades.Inimigos.CidadeMorta;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Itens.Minerios.FragM.FragForceM;
import com.daniel.Model.Itens.Minerios.FragP.FragForce;
import com.daniel.Model.Itens.Minerios.FragmentoEscuridao;
import com.daniel.Model.Itens.Pocoes.TonicoDeForca;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoCogumelo extends Inimigo {
    public InimigoCogumelo() {
        super("Toxic Shroom", "/com.daniel.Images/Inimigos/Toxic Shroom C.png", 41, 41, 44, 40, 30, 30,10000, 230, TiposElementais.NaoElemental, Comportamentos.padrao, 4000, 2000);
        this.absorcao = new TiposElementais[]{TiposElementais.Escuridao};
        this.fraquezas = new TiposElementais[]{TiposElementais.Luz,TiposElementais.Fogo};
        this.magias.add(new Veneno());
        this.magias.add(new Fortalecer());
        this.magias.add(new Enfraquecer());
        this.magias.add(new IntDown());
        this.lootTable.AdicionarEntrada(new FragmentoEscuridao(), 1, 2, 0.5);
        this.lootTable.AdicionarEntrada(new FragForceM(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new FragForce(), 0, 1, 0.1);
        this.lootTable.AdicionarEntrada(new TonicoDeForca(), 0, 1, 0.2);
    }
}
