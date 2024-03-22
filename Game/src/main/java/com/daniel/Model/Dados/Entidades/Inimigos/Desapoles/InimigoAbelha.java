package com.daniel.Model.Dados.Entidades.Inimigos.Desapoles;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Magias.Poderes.Escuridao;
import com.daniel.Model.Magias.Poderes.Veneno;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoAbelha extends Inimigo {
    public InimigoAbelha( ) {
        super("Abelha", "/com.daniel.Images/Inimigos/Insects Bee.png", 7, 24, 20, 18, 28, 20,5200, 75, TiposElementais.NaoElemental, Comportamentos.padrao, 1000, 500);
        this.fraquezas = new TiposElementais[]{TiposElementais.NaoElemental, TiposElementais.Terra};
        this.magias.add(new Veneno());
        this.lootTable.AdicionarEntrada(new Ferro(), 0, 2, 0.2);
    }
}
