package com.daniel.Model.Dados.Entidades.Inimigos.MonteClaro;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.FragM.FragForceM;
import com.daniel.Model.Itens.Minerios.FragM.FragIntM;
import com.daniel.Model.Itens.Minerios.FragM.FragSorteM;
import com.daniel.Model.Itens.Minerios.FragP.FragForce;
import com.daniel.Model.Itens.Minerios.FragP.FragInt;
import com.daniel.Model.Itens.Minerios.FragP.FragSorte;
import com.daniel.Model.Itens.Minerios.FragmentoFogo;
import com.daniel.Model.Itens.Minerios.Ouro;
import com.daniel.Model.Itens.Pocoes.TonicoDeForca;
import com.daniel.Model.Itens.Pocoes.TonicoDeInteligencia;
import com.daniel.Model.Itens.Pocoes.TonicoDeSorte;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoFetero extends Inimigo {
    public InimigoFetero() {
        super("Fetero", "/com.daniel.Images/Inimigos/Mountain Fetero.png", 22, 38, 26, 34, 27, 20,6000, 130, TiposElementais.NaoElemental, Comportamentos.padrao, 2400, 1200);
        this.resistencias = new TiposElementais[]{TiposElementais.NaoElemental, TiposElementais.Terra};
        this.magias.add(new Fortalecer());
        this.magias.add(new Veneno());
        this.lootTable.AdicionarEntrada(new FragForce(), 0, 1, 0.1);
        this.lootTable.AdicionarEntrada(new FragForceM(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new Ouro(), 1, 3, 0.2);
        this.lootTable.AdicionarEntrada(new TonicoDeForca(), 0, 2, 0.05);
    }
}
