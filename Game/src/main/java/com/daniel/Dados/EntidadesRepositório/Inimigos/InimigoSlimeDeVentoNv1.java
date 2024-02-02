package com.daniel.Dados.EntidadesRepositório.Inimigos;

import com.daniel.Modelo.ComportamentosInimigos.Comportamentos;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Itens.Minerios.Ouro;
import com.daniel.Modelo.Magia.Poderes.Vento;
import com.daniel.Modelo.Magia.TiposElementais;

public class InimigoSlimeDeVentoNv1 extends Inimigo {
    public InimigoSlimeDeVentoNv1() {
        super("Slime de vento pequeno", "/com.daniel.Images/Inimigos/Slime Windi.png", 17, 20, 15, 15, 45, 25, 35, TiposElementais.Vento, Comportamentos.padrao, 100, 5);
        this.absorcao = new TiposElementais[]{TiposElementais.Vento};
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.fraquezas = new TiposElementais[]{TiposElementais.Terra};
        this.magias.add(new Vento());
        this.lootTable.AdicionarEntrada(new Ouro(), 1, 1, 0.2);

    }
}
