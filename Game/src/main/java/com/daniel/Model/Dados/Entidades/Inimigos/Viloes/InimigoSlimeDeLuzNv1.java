package com.daniel.Model.Dados.Entidades.Inimigos.Viloes;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Comidas.Banana;
import com.daniel.Model.Magias.Poderes.Cure;
import com.daniel.Model.Magias.Poderes.Luz;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoSlimeDeLuzNv1 extends Inimigo {
    public InimigoSlimeDeLuzNv1() {
        super("Slime de luz pequeno", "/com.daniel.Images/Inimigos/Slime Holyi.png", 26, 20, 35, 15, 25, 20,45, 50, TiposElementais.Luz, Comportamentos.padrao, 250, 150);
        this.magias.add(new Luz());
        this.magias.add(new Cure());
        this.absorcao = new TiposElementais[]{TiposElementais.Fogo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Escuridao};
        this.imunidades = new TiposElementais[]{TiposElementais.Luz};
        this.lootTable.AdicionarEntrada(new Banana(), 1, 1, 0.3);
    }
}
