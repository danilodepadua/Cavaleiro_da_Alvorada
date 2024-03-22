package com.daniel.Model.Dados.Entidades.Inimigos.Desapoles;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.FragP.FragVel;
import com.daniel.Model.Itens.Minerios.FragmentoFogo;
import com.daniel.Model.Itens.Pocoes.TonicoDeVelocidade;
import com.daniel.Model.Magias.Poderes.Explosao;
import com.daniel.Model.Magias.Poderes.Fogo;
import com.daniel.Model.Magias.Poderes.Fortalecer;
import com.daniel.Model.Magias.Poderes.Roubo;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoCoelhoBandido extends Inimigo {
    public InimigoCoelhoBandido() {
        super("Rabbit Bandit", "/com.daniel.Images/Inimigos/Rabbit Warriors Bandit.png", 8, 10, 20, 20, 35, 30,6000, 110, TiposElementais.NaoElemental, Comportamentos.fugitivo, 30000, 15000);
        this.resistencias = new TiposElementais[]{TiposElementais.NaoElemental};
        this.fraquezas = new TiposElementais[]{TiposElementais.Fogo};
        this.magias.add(new Roubo());
        this.lootTable.AdicionarEntrada(new FragVel(), 0, 2, 0.05);
        this.lootTable.AdicionarEntrada(new TonicoDeVelocidade(), 0, 2, 0.1);
    }
}
