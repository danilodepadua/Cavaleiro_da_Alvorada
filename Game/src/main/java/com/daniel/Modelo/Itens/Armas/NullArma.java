package com.daniel.Modelo.Itens.Armas;

import com.daniel.Modelo.Itens.Arma;
import com.daniel.Modelo.Magia.TiposElementais;

public class NullArma extends Arma {
    public NullArma() {
        super("/com.daniel.Images/Itens/FundoArma.png", "Nenhum", 1,0, "", 0,0,TiposElementais.NaoElemental);
    }
}
