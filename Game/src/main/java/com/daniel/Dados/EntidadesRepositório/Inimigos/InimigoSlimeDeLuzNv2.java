package com.daniel.Dados.EntidadesRepositório.Inimigos;

import com.daniel.Modelo.ComportamentosInimigos.Comportamentos;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Itens.Comidas.CoxaFrango;
import com.daniel.Modelo.Magia.Poderes.Cura;
import com.daniel.Modelo.Magia.Poderes.IntUp;
import com.daniel.Modelo.Magia.Poderes.Luz;
import com.daniel.Modelo.Magia.TiposElementais;

public class InimigoSlimeDeLuzNv2 extends Inimigo {
    public InimigoSlimeDeLuzNv2() {
        super("Slime de luz médio", "/com.daniel.Images/Inimigos/Slime Holyii.png", 27,25, 45, 35, 30, 55, 150, TiposElementais.Luz, Comportamentos.padrao, 100, 5);
        this.magias.add(new Luz());
        this.magias.add(new IntUp());
        this.magias.add(new Cura());
        this.absorcao = new TiposElementais[]{TiposElementais.Fogo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Escuridao};
        this.imunidades = new TiposElementais[]{TiposElementais.Luz};
        this.lootTable.AdicionarEntrada(new CoxaFrango(), 1, 1, 0.3);

    }
}
