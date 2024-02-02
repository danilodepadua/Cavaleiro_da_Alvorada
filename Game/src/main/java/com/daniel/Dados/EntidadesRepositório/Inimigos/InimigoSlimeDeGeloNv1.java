package com.daniel.Dados.EntidadesRepositório.Inimigos;

import com.daniel.Modelo.ComportamentosInimigos.Comportamentos;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Itens.Comidas.Banana;
import com.daniel.Modelo.Itens.Minerios.FragmentoGlacial;
import com.daniel.Modelo.Magia.Poderes.Gelo;
import com.daniel.Modelo.Magia.TiposElementais;

public class InimigoSlimeDeGeloNv1 extends Inimigo {
    public InimigoSlimeDeGeloNv1() {
        super("Slime de gelo pequeno", "/com.daniel.Images/Inimigos/Slime Icei.png", 8, 20, 15, 25, 25, 5, 5, TiposElementais.Gelo, Comportamentos.padrao, 150, 50);
        this.magias.add(new Gelo());
        this.absorcao = new TiposElementais[]{TiposElementais.Terra};
        this.fraquezas = new TiposElementais[]{TiposElementais.Fogo};
        this.resistencias = new TiposElementais[]{TiposElementais.Agua};
        this.imunidades = new TiposElementais[]{TiposElementais.Gelo};
        this.lootTable.AdicionarEntrada(new FragmentoGlacial(), 1, 1, 0.5);
        this.lootTable.AdicionarEntrada(new Banana(), 1, 1, 0.2);
    }
}
