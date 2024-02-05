package com.daniel.Model.Dados.Entidades.Inimigos.Viloes;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Dados.Itens.Comidas.Banana;
import com.daniel.Model.Dados.Itens.Minerios.Ferro;
import com.daniel.Model.Dados.Magias.Poderes.Escuridao;
import com.daniel.Model.Dados.Magias.Poderes.Veneno;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class InimigoAbelha extends Inimigo {
    public InimigoAbelha( ) {
        super("Abelha", "/com.daniel.Images/Inimigos/Insects Bee.png", 29, 20, 15, 35, 15, 500, 50, TiposElementais.NaoElemental, Comportamentos.padrao, 200, 50);
        this.fraquezas = new TiposElementais[]{TiposElementais.NaoElemental, TiposElementais.Terra};
        this.magias.add(new Veneno());
        this.magias.add(new Escuridao());
        this.lootTable.AdicionarEntrada(new Banana(), 1, 1, 0.2);
        this.lootTable.AdicionarEntrada(new Ferro(), 1, 1, 0.2);
    }
}
