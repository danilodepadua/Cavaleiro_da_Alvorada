package com.daniel.Dados.EntidadesRepositório.Inimigos;

import com.daniel.Modelo.ComportamentosInimigos.Comportamentos;
import com.daniel.Dados.EntidadesRepositório.Inimigo;
import com.daniel.Modelo.Itens.Minerios.Ferro;
import com.daniel.Modelo.Magia.Poderes.Splash;
import com.daniel.Modelo.Magia.TiposElementais;

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
