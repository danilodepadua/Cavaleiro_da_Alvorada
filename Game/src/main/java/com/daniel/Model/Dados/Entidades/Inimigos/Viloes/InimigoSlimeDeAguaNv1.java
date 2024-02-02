package com.daniel.Model.Dados.Entidades.Inimigos.Viloes;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Dados.Itens.Minerios.Ferro;
import com.daniel.Model.Dados.Magias.Poderes.Splash;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class InimigoSlimeDeAguaNv1 extends Inimigo {
    public InimigoSlimeDeAguaNv1() {
        super("Slime de água pequeno", "/com.daniel.Images/Inimigos/Slime Wateri.png", 11, 20, 15, 15, 25, 35, 50, TiposElementais.Agua, Comportamentos.padrao, 250, 150);
        this.magias.add(new Splash());
        this.resistencias = new TiposElementais[]{TiposElementais.Terra};
        this.imunidades = new TiposElementais[]{ TiposElementais.Fogo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Eletrico};
        this.absorcao = new TiposElementais[]{TiposElementais.Agua};
        this.lootTable.AdicionarEntrada(new Ferro(), 1, 2, 0.8);


    }
}
