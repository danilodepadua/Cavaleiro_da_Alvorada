package com.daniel.Model.Dados.Entidades.Inimigos.Caverna;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Itens.Minerios.FragM.FragIntM;
import com.daniel.Model.Itens.Minerios.FragM.FragResM;
import com.daniel.Model.Itens.Minerios.FragP.FragInt;
import com.daniel.Model.Itens.Minerios.FragP.FragRes;
import com.daniel.Model.Itens.Pocoes.TonicoDeResistencia;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoOrc1 extends Inimigo {
    public InimigoOrc1() {
        super("Orc Warlock", "/com.daniel.Images/Inimigos/Orc Warlock.png", 50, 42, 62, 42, 44, 40,14500, 2000, TiposElementais.NaoElemental, Comportamentos.padrao, 5800, 2900);
        this.lootTable.AdicionarEntrada(new TonicoDeResistencia(), 1, 2, 0.4);
        this.lootTable.AdicionarEntrada(new FragInt(), 0, 1, 0.6);
        this.lootTable.AdicionarEntrada(new FragIntM(), 0, 1, 0.4);
        this.resistencias = new TiposElementais[]{TiposElementais.Fogo,TiposElementais.Vento,TiposElementais.Gelo,TiposElementais.Agua,TiposElementais.Terra};
        this.fraquezas = new TiposElementais[]{TiposElementais.Luz};
        this.imunidades = new TiposElementais[]{TiposElementais.Escuridao};
    }
}
