package com.daniel.Model.Dados.Entidades.Inimigos.CidadeMorta;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Itens.Minerios.FragM.FragForceM;
import com.daniel.Model.Itens.Minerios.FragM.FragSorteM;
import com.daniel.Model.Itens.Minerios.FragP.FragForce;
import com.daniel.Model.Itens.Minerios.FragP.FragSorte;
import com.daniel.Model.Itens.Minerios.FragmentoEscuridao;
import com.daniel.Model.Itens.Pocoes.TonicoDeForca;
import com.daniel.Model.Itens.Pocoes.TonicoDeSorte;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoArvoreMorta extends Inimigo {
    public InimigoArvoreMorta() {
        super("Dead tree", "/com.daniel.Images/Inimigos/Toxic Root B.png", 43, 35, 35, 35, 30, 40,9000, 200, TiposElementais.NaoElemental, Comportamentos.padrao, 3600, 1800);
        this.absorcao = new TiposElementais[]{TiposElementais.Escuridao};
        this.fraquezas = new TiposElementais[]{TiposElementais.Luz,TiposElementais.Fogo};
        this.magias.add(new Veneno());
        this.magias.add(new Cegar());
        this.magias.add(new Silenciar());
        this.lootTable.AdicionarEntrada(new FragmentoEscuridao(), 1, 2, 0.5);
        this.lootTable.AdicionarEntrada(new FragSorteM(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new FragSorte(), 0, 1, 0.1);
        this.lootTable.AdicionarEntrada(new TonicoDeSorte(), 0, 1, 0.2);
    }
}
