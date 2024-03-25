package com.daniel.Model.Dados.Entidades.Inimigos.CidadeMorta;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.FragM.FragForceM;
import com.daniel.Model.Itens.Minerios.FragP.FragForce;
import com.daniel.Model.Itens.Minerios.FragmentoEscuridao;
import com.daniel.Model.Itens.Pocoes.TonicoDeForca;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoCobraGigante extends Inimigo {
    public InimigoCobraGigante() {
        super("Cobra gigante", "/com.daniel.Images/Inimigos/Colossal Snake Black.png", 42, 46, 44, 30, 38, 32,10500, 250, TiposElementais.NaoElemental, Comportamentos.padrao, 4200, 2100);
        this.absorcao = new TiposElementais[]{TiposElementais.Escuridao};
        this.fraquezas = new TiposElementais[]{TiposElementais.Luz};
        this.magias.add(new Veneno());
        this.magias.add(new Cegar());
        this.lootTable.AdicionarEntrada(new FragmentoEscuridao(), 1, 2, 0.5);
        this.lootTable.AdicionarEntrada(new FragForceM(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new FragForce(), 0, 1, 0.1);
        this.lootTable.AdicionarEntrada(new TonicoDeForca(), 0, 1, 0.2);
    }
}
