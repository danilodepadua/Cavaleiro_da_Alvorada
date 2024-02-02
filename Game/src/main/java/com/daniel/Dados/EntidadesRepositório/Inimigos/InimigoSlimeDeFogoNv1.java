package com.daniel.Dados.EntidadesRepositório.Inimigos;

import com.daniel.Modelo.ComportamentosInimigos.Comportamentos;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Itens.Comidas.Banana;
import com.daniel.Modelo.Itens.Minerios.FragmentoFogo;
import com.daniel.Modelo.Magia.Poderes.Fogo;
import com.daniel.Modelo.Magia.TiposElementais;

public class InimigoSlimeDeFogoNv1 extends Inimigo {
    public InimigoSlimeDeFogoNv1() {
        super("Slime de fogo pequeno", "/com.daniel.Images/Inimigos/Slime Firei.png", 5, 35, 15, 15, 15, 25, 28, TiposElementais.Fogo, Comportamentos.padrao, 150, 50);
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.absorcao = new TiposElementais[]{TiposElementais.Fogo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Agua, TiposElementais.Gelo};
        this.magias.add(new Fogo());
        this.lootTable.AdicionarEntrada(new FragmentoFogo(), 1, 1, 0.5);
        this.lootTable.AdicionarEntrada(new Banana(), 1, 1, 0.2);
    }
}
