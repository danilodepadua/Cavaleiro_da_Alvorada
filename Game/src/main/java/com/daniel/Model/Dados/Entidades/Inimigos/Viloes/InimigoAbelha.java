package com.daniel.Model.Dados.Entidades.Inimigos.Viloes;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Magias.Poderes.Escuridao;
import com.daniel.Model.Magias.Poderes.Veneno;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoAbelha extends Inimigo {
    public InimigoAbelha( ) {
        super("Abelha", "/com.daniel.Images/Inimigos/Insects Bee.png", 29, 20, 15, 35, -10, 15,10, 50, TiposElementais.NaoElemental, Comportamentos.padrao, 2000000, 50);
        this.fraquezas = new TiposElementais[]{TiposElementais.NaoElemental, TiposElementais.Terra};
        this.magias.add(new Veneno());
        this.magias.add(new Escuridao());
        this.lootTable.AdicionarEntrada(new Ferro(), 1, 1, 0.2);
    }
}
