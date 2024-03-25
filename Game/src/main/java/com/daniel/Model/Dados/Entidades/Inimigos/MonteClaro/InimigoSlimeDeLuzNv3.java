package com.daniel.Model.Dados.Entidades.Inimigos.MonteClaro;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Itens.Minerios.FragM.FragIntM;
import com.daniel.Model.Itens.Minerios.FragM.FragResM;
import com.daniel.Model.Itens.Minerios.FragM.FragSorteM;
import com.daniel.Model.Itens.Minerios.FragP.FragInt;
import com.daniel.Model.Itens.Minerios.FragP.FragRes;
import com.daniel.Model.Itens.Minerios.FragP.FragSorte;
import com.daniel.Model.Itens.Minerios.Ouro;
import com.daniel.Model.Itens.Pocoes.TonicoDeInteligencia;
import com.daniel.Model.Itens.Pocoes.TonicoDeResistencia;
import com.daniel.Model.Itens.Pocoes.TonicoDeSorte;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoSlimeDeLuzNv3 extends Inimigo {
    public InimigoSlimeDeLuzNv3() {
        super("Slime de luz grande", "/com.daniel.Images/Inimigos/Slime Holyiii.png", 17, 20, 36, 20, 25, 34,5000, 90, TiposElementais.Luz, Comportamentos.padrao, 2000, 1000);
        this.absorcao = new TiposElementais[]{TiposElementais.Luz};
        this.fraquezas = new TiposElementais[]{TiposElementais.Escuridao};
        this.resistencias = new TiposElementais[]{TiposElementais.NaoElemental};
        this.magias.add(new Luz());
        this.magias.add(new Regen());
        this.magias.add(new Cure());
        this.lootTable.AdicionarEntrada(new FragSorte(), 0, 1, 0.1);
        this.lootTable.AdicionarEntrada(new FragSorteM(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new FragInt(), 0, 1, 0.1);
        this.lootTable.AdicionarEntrada(new FragIntM(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new Ouro(), 1, 3, 0.2);
        this.lootTable.AdicionarEntrada(new TonicoDeSorte(), 0, 2, 0.1);
        this.lootTable.AdicionarEntrada(new TonicoDeInteligencia(), 0, 2, 0.1);
    }
}
