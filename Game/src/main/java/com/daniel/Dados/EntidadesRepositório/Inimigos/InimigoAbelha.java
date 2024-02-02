package com.daniel.Dados.EntidadesRepositório.Inimigos;

import com.daniel.Modelo.ComportamentosInimigos.Comportamentos;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Itens.Comidas.Banana;
import com.daniel.Modelo.Itens.Minerios.Ferro;
import com.daniel.Modelo.Magia.Poderes.Escuridao;
import com.daniel.Modelo.Magia.Poderes.Veneno;
import com.daniel.Modelo.Magia.TiposElementais;

public class InimigoAbelha extends Inimigo {
    public InimigoAbelha( ) {
        super("Abelha", "/com.daniel.Images/Inimigos/Insects Bee.png", 29, 20, 15, 35, 28, 40, 50, TiposElementais.NaoElemental, Comportamentos.padrao, 200, 50);
        this.fraquezas = new TiposElementais[]{TiposElementais.NaoElemental, TiposElementais.Terra};
        this.magias.add(new Veneno());
        this.magias.add(new Escuridao());
        this.lootTable.AdicionarEntrada(new Banana(), 1, 1, 0.2);
        this.lootTable.AdicionarEntrada(new Ferro(), 1, 1, 0.2);
    }
}
