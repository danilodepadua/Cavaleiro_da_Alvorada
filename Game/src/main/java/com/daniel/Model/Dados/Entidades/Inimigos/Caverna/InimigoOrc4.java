package com.daniel.Model.Dados.Entidades.Inimigos.Caverna;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Itens.Minerios.FragM.FragVelM;
import com.daniel.Model.Itens.Minerios.FragP.FragVel;
import com.daniel.Model.Itens.Pocoes.TonicoDeVelocidade;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoOrc4 extends Inimigo {
    public InimigoOrc4() {
        super("Orc Archer", "/com.daniel.Images/Inimigos/Orc Archer.png", 53, 40, 35, 40, 55, 45,13000, 250, TiposElementais.NaoElemental, Comportamentos.padrao, 5200, 2600);
        this.lootTable.AdicionarEntrada(new TonicoDeVelocidade(), 1, 2, 0.4);
        this.lootTable.AdicionarEntrada(new FragVel(), 0, 1, 0.6);
        this.lootTable.AdicionarEntrada(new FragVelM(), 0, 1, 0.4);
    }
}
