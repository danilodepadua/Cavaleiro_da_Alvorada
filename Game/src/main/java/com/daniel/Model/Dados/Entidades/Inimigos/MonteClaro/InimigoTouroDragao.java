package com.daniel.Model.Dados.Entidades.Inimigos.MonteClaro;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Itens.Minerios.FragM.FragForceM;
import com.daniel.Model.Itens.Minerios.FragM.FragResM;
import com.daniel.Model.Itens.Minerios.FragP.FragForce;
import com.daniel.Model.Itens.Minerios.FragP.FragRes;
import com.daniel.Model.Itens.Minerios.FragmentoFogo;
import com.daniel.Model.Itens.Minerios.Ouro;
import com.daniel.Model.Itens.Pocoes.TonicoDeForca;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoTouroDragao extends Inimigo {
    public InimigoTouroDragao() {
        super("Bull Dragon", "/com.daniel.Images/Inimigos/Mountain Bull Dragon.png", 25, 35, 25, 38, 30, 30,7500, 140, TiposElementais.Terra, Comportamentos.padrao, 3000, 1500);
        this.resistencias = new TiposElementais[]{TiposElementais.NaoElemental, TiposElementais.Terra,TiposElementais.Vento};
        this.fraquezas = new TiposElementais[]{TiposElementais.Eletrico};
        this.magias.add(new Fortalecer());
        this.magias.add(new Endurecer());
        this.magias.add(new Terra());
        this.magias.add(new ParedeTerra());
        this.lootTable.AdicionarEntrada(new FragRes(), 0, 1, 0.1);
        this.lootTable.AdicionarEntrada(new FragResM(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new Ouro(), 1, 3, 0.1);
        this.lootTable.AdicionarEntrada(new TonicoDeForca(), 0, 3, 0.1);
    }
}
