package com.daniel.Model.Dados.Entidades.Inimigos.MonteClaro;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.FragM.FragForceM;
import com.daniel.Model.Itens.Minerios.FragM.FragIntM;
import com.daniel.Model.Itens.Minerios.FragM.FragSorteM;
import com.daniel.Model.Itens.Minerios.FragM.FragVelM;
import com.daniel.Model.Itens.Minerios.FragP.FragForce;
import com.daniel.Model.Itens.Minerios.FragP.FragInt;
import com.daniel.Model.Itens.Minerios.FragP.FragSorte;
import com.daniel.Model.Itens.Minerios.FragP.FragVel;
import com.daniel.Model.Itens.Minerios.Ouro;
import com.daniel.Model.Itens.Pocoes.TonicoDeForca;
import com.daniel.Model.Itens.Pocoes.TonicoDeInteligencia;
import com.daniel.Model.Itens.Pocoes.TonicoDeSorte;
import com.daniel.Model.Itens.Pocoes.TonicoDeVelocidade;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoCorvoGigante extends Inimigo {
    public InimigoCorvoGigante() {
        super("Corvo gigante", "/com.daniel.Images/Inimigos/Colossal Dark Crow.png", 20, 33, 25, 29, 38, 20,6000, 130, TiposElementais.NaoElemental, Comportamentos.padrao, 2400, 1200);
        this.fraquezas = new TiposElementais[]{TiposElementais.Terra};
        this.resistencias = new TiposElementais[]{TiposElementais.Vento};
        this.magias.add(new Vento());
        this.magias.add(new AirBlast());
        this.magias.add(new Regen());
        this.lootTable.AdicionarEntrada(new FragForce(), 0, 1, 0.1);
        this.lootTable.AdicionarEntrada(new FragForceM(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new FragVel(), 0, 1, 0.01);
        this.lootTable.AdicionarEntrada(new FragVelM(), 0, 1, 0.005);
        this.lootTable.AdicionarEntrada(new TonicoDeVelocidade(), 0, 2, 0.05);
        this.lootTable.AdicionarEntrada(new TonicoDeForca(), 0, 2, 0.05);
    }
}
