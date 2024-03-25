package com.daniel.Model.Dados.Entidades.Inimigos.Desapoles;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.FragP.FragForce;
import com.daniel.Model.Itens.Minerios.FragP.FragRes;
import com.daniel.Model.Itens.Minerios.FragmentoFogo;
import com.daniel.Model.Itens.Pocoes.PocaoCura;
import com.daniel.Model.Itens.Pocoes.TonicoDeForca;
import com.daniel.Model.Magias.Poderes.Endurecer;
import com.daniel.Model.Magias.Poderes.Explosao;
import com.daniel.Model.Magias.Poderes.Fogo;
import com.daniel.Model.Magias.Poderes.Fortalecer;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoGoblin2 extends Inimigo {
    public InimigoGoblin2() {
        super("Goblin Elite", "/com.daniel.Images/Inimigos/Goblin Elite.png", 11, 28, 20, 28, 24, 20,6200, 100, TiposElementais.NaoElemental, Comportamentos.padrao, 1800, 900);
        this.resistencias = new TiposElementais[]{TiposElementais.NaoElemental};
        this.magias.add(new Endurecer());
        this.magias.add(new Fortalecer());
        this.lootTable.AdicionarEntrada(new FragForce(), 0, 1, 0.1);
        this.lootTable.AdicionarEntrada(new TonicoDeForca(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new PocaoCura(), 0, 3, 0.2);
    }
}
