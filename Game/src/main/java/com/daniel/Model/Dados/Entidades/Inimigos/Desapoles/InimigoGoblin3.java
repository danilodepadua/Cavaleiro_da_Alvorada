package com.daniel.Model.Dados.Entidades.Inimigos.Desapoles;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Itens.Minerios.FragP.FragVel;
import com.daniel.Model.Itens.Minerios.FragmentoFogo;
import com.daniel.Model.Itens.Pocoes.TonicoDeVelocidade;
import com.daniel.Model.Magias.Poderes.Explosao;
import com.daniel.Model.Magias.Poderes.Fast;
import com.daniel.Model.Magias.Poderes.Fogo;
import com.daniel.Model.Magias.Poderes.Fortalecer;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoGoblin3 extends Inimigo {
    public InimigoGoblin3() {
        super("Goblin Grunt", "/com.daniel.Images/Inimigos/Goblin Grunt.png", 12, 30, 15, 24, 27, 24,5800, 60, TiposElementais.NaoElemental, Comportamentos.padrao, 1400, 700);
        this.magias.add(new Fast());
        this.lootTable.AdicionarEntrada(new FragVel(), 0, 1, 0.01);
        this.lootTable.AdicionarEntrada(new TonicoDeVelocidade(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new Ferro(), 0, 2, 0.05);
    }
}
