package com.daniel.Dados.EntidadesRepositório.Inimigos;

import com.daniel.Modelo.ComportamentosInimigos.Comportamentos;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Itens.Comidas.Pao;
import com.daniel.Modelo.Itens.Minerios.FragmentoFogo;
import com.daniel.Modelo.Magia.Poderes.Explosao;
import com.daniel.Modelo.Magia.Poderes.Fogo;
import com.daniel.Modelo.Magia.TiposElementais;

public class InimigoSlimeDeFogoNv2 extends Inimigo {
    public InimigoSlimeDeFogoNv2() {
        super("Slime de fogo médio", "/com.daniel.Images/Inimigos/Slime Fireii.png", 6, 45, 25, 25, 25, 45, 30, TiposElementais.Fogo, Comportamentos.padrao, 250, 75);
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.absorcao = new TiposElementais[]{TiposElementais.Fogo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Agua, TiposElementais.Gelo};
        this.magias.add(new Fogo());
        this.magias.add(new Explosao());
        this.lootTable.AdicionarEntrada(new FragmentoFogo(), 1, 2, 0.5);
        this.lootTable.AdicionarEntrada(new Pao(), 1, 1, 0.2);
    }
}
