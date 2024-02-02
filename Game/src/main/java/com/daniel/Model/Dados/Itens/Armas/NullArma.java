package com.daniel.Model.Dados.Itens.Armas;

import com.daniel.Model.Dados.Itens.Arma;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class NullArma extends Arma {
    public NullArma() {
        super("/com.daniel.Images/Itens/FundoArma.png", "Nenhum", 1,0, "", 0,0,TiposElementais.NaoElemental);
    }
}
