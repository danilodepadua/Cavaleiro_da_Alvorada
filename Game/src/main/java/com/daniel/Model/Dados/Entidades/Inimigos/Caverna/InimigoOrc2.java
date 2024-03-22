package com.daniel.Model.Dados.Entidades.Inimigos.Caverna;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Itens.Minerios.FragM.FragResM;
import com.daniel.Model.Itens.Minerios.FragP.FragForce;
import com.daniel.Model.Itens.Minerios.FragP.FragRes;
import com.daniel.Model.Itens.Pocoes.TonicoDeForca;
import com.daniel.Model.Itens.Pocoes.TonicoDeResistencia;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoOrc2 extends Inimigo {
    public InimigoOrc2() {
        super("Orc Sword", "/com.daniel.Images/Inimigos/Orc Sword Warrior.png", 51, 65, 25, 45, 55, 35,14000, 325, TiposElementais.NaoElemental, Comportamentos.padrao, 5600, 2800);
        this.lootTable.AdicionarEntrada(new TonicoDeForca(), 1, 2, 0.4);
        this.lootTable.AdicionarEntrada(new FragForce(), 0, 1, 0.6);
        this.lootTable.AdicionarEntrada(new FragForce(), 0, 1, 0.4);
        this.resistencias = new TiposElementais[]{TiposElementais.NaoElemental};
    }
}
