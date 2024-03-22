package com.daniel.Model.Dados.Entidades.Inimigos.MonteClaro;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.FragmentoFogo;
import com.daniel.Model.Magias.Poderes.Explosao;
import com.daniel.Model.Magias.Poderes.Fogo;
import com.daniel.Model.Magias.Poderes.Fortalecer;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoTouroDragao extends Inimigo {
    public InimigoTouroDragao() {
        super("Bull Dragon", "/com.daniel.Images/Inimigos/Mountain Bull Dragon.png", 25, 32, 32, 32, 32, 32,65, 35, TiposElementais.Gelo, Comportamentos.padrao, 370, 105);
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.absorcao = new TiposElementais[]{TiposElementais.Fogo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Agua, TiposElementais.Gelo};
        this.magias.add(new Fogo());
        this.magias.add(new Explosao());
        this.magias.add(new Fortalecer());
        this.lootTable.AdicionarEntrada(new FragmentoFogo(), 1, 3, 0.7);
    }
}
