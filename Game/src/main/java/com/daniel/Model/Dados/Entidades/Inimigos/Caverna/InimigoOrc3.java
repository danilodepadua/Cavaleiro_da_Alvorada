package com.daniel.Model.Dados.Entidades.Inimigos.Caverna;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.FragM.FragResM;
import com.daniel.Model.Itens.Minerios.FragP.FragRes;
import com.daniel.Model.Itens.Pocoes.TonicoDeResistencia;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoOrc3 extends Inimigo {
    public InimigoOrc3() {
        super("Orc Axe", "/com.daniel.Images/Inimigos/Orc Axe Warrior.png", 52, 55, 25, 40, 55, 30,13500, 300, TiposElementais.NaoElemental, Comportamentos.padrao, 5400, 2700);
        this.lootTable.AdicionarEntrada(new TonicoDeResistencia(), 1, 2, 0.4);
        this.lootTable.AdicionarEntrada(new FragRes(), 0, 1, 0.6);
        this.lootTable.AdicionarEntrada(new FragResM(), 0, 1, 0.4);
        this.resistencias = new TiposElementais[]{TiposElementais.NaoElemental};
    }
}
