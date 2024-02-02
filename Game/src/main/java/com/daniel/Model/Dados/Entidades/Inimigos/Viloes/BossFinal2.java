package com.daniel.Model.Dados.Entidades.Inimigos.Viloes;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Dados.Magias.Poderes.*;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class BossFinal2 extends Inimigo {
    public BossFinal2() {
        super("Besta abissal", "/com.daniel.Images/Inimigos/Boss Eldritch God Shaccad'Yoggoth.png", 40, 80, 70, 40, 40, 10000, 10000, TiposElementais.Escuridao, Comportamentos.BossFinal2, 1000000, 999999);
        this.fraquezas = new TiposElementais[]{TiposElementais.Luz};
        this.absorcao = new TiposElementais[]{TiposElementais.Escuridao};
        this.magias.add(new Escuridao());
        this.magias.add(new IntDown());
        this.magias.add(new Amolecer());
        this.magias.add(new Slow());
        this.magias.add(new Enfraquecer());
    }
}
