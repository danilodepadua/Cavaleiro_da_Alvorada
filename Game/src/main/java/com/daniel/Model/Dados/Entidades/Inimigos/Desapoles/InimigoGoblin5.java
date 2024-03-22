package com.daniel.Model.Dados.Entidades.Inimigos.Desapoles;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Itens.Minerios.FragP.FragVel;
import com.daniel.Model.Itens.Minerios.FragmentoFogo;
import com.daniel.Model.Magias.Poderes.Explosao;
import com.daniel.Model.Magias.Poderes.Fast;
import com.daniel.Model.Magias.Poderes.Fogo;
import com.daniel.Model.Magias.Poderes.Fortalecer;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoGoblin5 extends Inimigo {
    public InimigoGoblin5() {
        super("Goblin Raider", "/com.daniel.Images/Inimigos/Goblin Raider.png", 14, 30, 15, 20, 30, 20,6000, 80, TiposElementais.NaoElemental, Comportamentos.padrao, 1600, 800);
        this.magias.add(new Fast());
        this.magias.add(new Fortalecer());
        this.lootTable.AdicionarEntrada(new FragVel(), 0, 1, 0.01);
        this.lootTable.AdicionarEntrada(new Ferro(), 0, 2, 0.05);
    }
}
