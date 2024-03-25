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
import com.daniel.Model.Itens.Minerios.FragmentoFogo;
import com.daniel.Model.Itens.Minerios.Ouro;
import com.daniel.Model.Itens.Pocoes.TonicoDeInteligencia;
import com.daniel.Model.Itens.Pocoes.TonicoDeResistencia;
import com.daniel.Model.Itens.Pocoes.TonicoDeSorte;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoMinhocaTerra extends Inimigo {
    public InimigoMinhocaTerra() {
        super("Earth Dragon", "/com.daniel.Images/Inimigos/Boss Earth Dragon.png", 26, 36, 24, 45, 15, 30,6500, 125, TiposElementais.Terra, Comportamentos.padrao, 2600, 1300);
        this.absorcao = new TiposElementais[]{TiposElementais.Terra};
        this.resistencias = new TiposElementais[]{TiposElementais.NaoElemental};
        this.magias.add(new Terra());
        this.magias.add(new ParedeTerra());
        this.lootTable.AdicionarEntrada(new FragRes(), 0, 1, 0.1);
        this.lootTable.AdicionarEntrada(new FragResM(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new Ferro(), 1, 3, 0.2);
        this.lootTable.AdicionarEntrada(new TonicoDeResistencia(), 0, 2, 0.05);
    }
}
