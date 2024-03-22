package com.daniel.Model.Dados.Entidades.Inimigos.MonteClaro;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.FragmentoFogo;
import com.daniel.Model.Magias.Poderes.Explosao;
import com.daniel.Model.Magias.Poderes.Fogo;
import com.daniel.Model.Magias.Poderes.Fortalecer;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoFetero extends Inimigo {
    public InimigoFetero() {
        super("Fetero", "/com.daniel.Images/Inimigos/Mountain Fetero.png", 22, 38, 26, 34, 27, 20,6000, 130, TiposElementais.NaoElemental, Comportamentos.padrao, 2400, 1200);
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.absorcao = new TiposElementais[]{TiposElementais.Fogo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Agua, TiposElementais.Gelo};
        this.magias.add(new Fogo());
        this.magias.add(new Explosao());
        this.magias.add(new Fortalecer());
        this.lootTable.AdicionarEntrada(new FragmentoFogo(), 1, 3, 0.7);
    }
}
