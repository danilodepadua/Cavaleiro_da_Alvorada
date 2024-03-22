package com.daniel.Model.Dados.Entidades.Inimigos.Desapoles;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.FragP.FragForce;
import com.daniel.Model.Itens.Minerios.FragmentoFogo;
import com.daniel.Model.Itens.Pocoes.PocaoCura;
import com.daniel.Model.Itens.Pocoes.PocaoMp;
import com.daniel.Model.Itens.Pocoes.TonicoDeForca;
import com.daniel.Model.Magias.Poderes.Explosao;
import com.daniel.Model.Magias.Poderes.Fast;
import com.daniel.Model.Magias.Poderes.Fogo;
import com.daniel.Model.Magias.Poderes.Fortalecer;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoLobisomen extends Inimigo {
    public InimigoLobisomen() {
        super("Werewolf", "/com.daniel.Images/Inimigos/Werewolf Rigel.png", 15, 28, 28, 28, 28, 28,7000, 110, TiposElementais.NaoElemental, Comportamentos.padrao, 2200, 1100);
        this.resistencias = new TiposElementais[]{TiposElementais.NaoElemental,TiposElementais.Vento};
        this.fraquezas = new TiposElementais[]{TiposElementais.Eletrico};
        this.magias.add(new Fast());
        this.magias.add(new Fortalecer());
        this.lootTable.AdicionarEntrada(new FragForce(), 0, 1, 0.01);
        this.lootTable.AdicionarEntrada(new PocaoCura(), 0, 3, 0.5);
        this.lootTable.AdicionarEntrada(new PocaoMp(), 0, 3, 0.5);
        this.lootTable.AdicionarEntrada(new TonicoDeForca(), 0, 1, 0.05);
    }
}
