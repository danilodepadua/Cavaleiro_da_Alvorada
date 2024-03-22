package com.daniel.Model.Dados.Entidades.Inimigos.MonteClaro;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Magias.Poderes.Curaga;
import com.daniel.Model.Magias.Poderes.IntUp;
import com.daniel.Model.Magias.Poderes.Luz;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoSlimeDeLuzNv3 extends Inimigo {
    public InimigoSlimeDeLuzNv3() {
        super("Slime de luz grande", "/com.daniel.Images/Inimigos/Slime Holyiii.png", 17, 20, 36, 20, 25, 34,5000, 90, TiposElementais.Luz, Comportamentos.padrao, 2000, 1000);
        this.magias.add(new Luz());
        this.magias.add(new IntUp());
        this.magias.add(new Curaga());
        this.absorcao = new TiposElementais[]{TiposElementais.Fogo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Escuridao};
        this.imunidades = new TiposElementais[]{TiposElementais.Luz};
    }
}
