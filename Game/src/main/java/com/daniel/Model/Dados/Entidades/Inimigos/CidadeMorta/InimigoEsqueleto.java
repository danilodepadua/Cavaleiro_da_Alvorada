package com.daniel.Model.Dados.Entidades.Inimigos.CidadeMorta;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Itens.Minerios.FragM.FragForceM;
import com.daniel.Model.Itens.Minerios.FragP.FragForce;
import com.daniel.Model.Itens.Minerios.FragmentoEscuridao;
import com.daniel.Model.Itens.Pocoes.TonicoDeForca;
import com.daniel.Model.Magias.Poderes.Amolecer;
import com.daniel.Model.Magias.Poderes.Enfraquecer;
import com.daniel.Model.Magias.Poderes.Escuridao;
import com.daniel.Model.Magias.Poderes.IntDown;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoEsqueleto extends Inimigo {
    public InimigoEsqueleto() {
        super("Bones", "/com.daniel.Images/Inimigos/Halloween Skeleton.png", 40, 45, 30, 33, 33, 39,9500, 240, TiposElementais.NaoElemental, Comportamentos.padrao, 3800, 1900);
        this.absorcao = new TiposElementais[]{TiposElementais.Escuridao};
        this.imunidades = new TiposElementais[]{TiposElementais.Fogo};
        this.resistencias = new TiposElementais[]{TiposElementais.NaoElemental};
        this.fraquezas = new TiposElementais[]{TiposElementais.Luz};
        this.lootTable.AdicionarEntrada(new FragmentoEscuridao(), 1, 2, 0.5);
        this.lootTable.AdicionarEntrada(new FragForceM(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new FragForce(), 0, 1, 0.1);
        this.lootTable.AdicionarEntrada(new TonicoDeForca(), 0, 1, 0.2);
    }
}
