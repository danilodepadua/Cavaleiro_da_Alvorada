package com.daniel.PrimeiraCamada.Itens.Armas;

import com.daniel.PrimeiraCamada.Itens.Arma;
import com.daniel.PrimeiraCamada.TiposElementais;

public class NullArma extends Arma {
    public NullArma() {
        super("/com.daniel.Images/Itens/FundoArma.png", "Nenhum", 1,0, "", 0,0,TiposElementais.NaoElemental);
    }
}
