package com.daniel.Model.Dados.Entidades.Inimigos.Viloes;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Magias.Poderes.Cura;
import com.daniel.Model.Magias.Poderes.IntUp;
import com.daniel.Model.Magias.Poderes.Luz;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoSlimeDeLuzNv2 extends Inimigo {
    public InimigoSlimeDeLuzNv2() {
        super("Slime de luz médio", "/com.daniel.Images/Inimigos/Slime Holyii.png", 27,25, 45, 35, 30, 30,55, 150, TiposElementais.Luz, Comportamentos.padrao, 100, 5);
        this.magias.add(new Luz());
        this.magias.add(new IntUp());
        this.magias.add(new Cura());
        this.absorcao = new TiposElementais[]{TiposElementais.Fogo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Escuridao};
        this.imunidades = new TiposElementais[]{TiposElementais.Luz};
    }
}
