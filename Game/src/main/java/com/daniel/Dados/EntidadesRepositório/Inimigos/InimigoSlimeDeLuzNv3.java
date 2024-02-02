package com.daniel.Dados.EntidadesRepositório.Inimigos;

import com.daniel.Modelo.ComportamentosInimigos.Comportamentos;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Itens.Comidas.Banana;
import com.daniel.Modelo.Itens.Comidas.CoxaFrango;
import com.daniel.Modelo.Magia.Poderes.Curaga;
import com.daniel.Modelo.Magia.Poderes.IntUp;
import com.daniel.Modelo.Magia.Poderes.Luz;
import com.daniel.Modelo.Magia.TiposElementais;

public class InimigoSlimeDeLuzNv3 extends Inimigo {
    public InimigoSlimeDeLuzNv3() {
        super("Slime de luz grande", "/com.daniel.Images/Inimigos/Slime Holyiii.png", 28, 35, 55, 45, 40, 65, 250, TiposElementais.Luz, Comportamentos.padrao, 350, 150);
        this.magias.add(new Luz());
        this.magias.add(new IntUp());
        this.magias.add(new Curaga());
        this.absorcao = new TiposElementais[]{TiposElementais.Fogo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Escuridao};
        this.imunidades = new TiposElementais[]{TiposElementais.Luz};
        this.lootTable.AdicionarEntrada(new CoxaFrango(), 1, 2, 0.3);
        this.lootTable.AdicionarEntrada(new Banana(), 1, 2, 0.3);

    }
}
