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

public class InimigoSapo2 extends Inimigo {
    public InimigoSapo2() {
        super("White Toxic Frog", "/com.daniel.Images/Inimigos/Toxic Frog B2.png", 35, 33, 30, 33, 36, 33,8000, 150, TiposElementais.NaoElemental, Comportamentos.padrao, 3200, 1600);
        this.absorcao = new TiposElementais[]{TiposElementais.Escuridao};
        this.magias.add(new Veneno());
        this.lootTable.AdicionarEntrada(new FragmentoEscuridao(), 1, 2, 0.5);
        this.lootTable.AdicionarEntrada(new FragIntM(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new FragInt(), 0, 1, 0.1);
        this.lootTable.AdicionarEntrada(new TonicoDeInteligencia(), 0, 1, 0.2);
    }
}
