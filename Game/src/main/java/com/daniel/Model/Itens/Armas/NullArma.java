package com.daniel.Model.Itens.Armas;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Arma;
import com.daniel.Model.Magias.TiposElementais;

public class NullArma extends Arma {
    public NullArma() {
        super("/com.daniel.Images/Itens/FundoArma.png", new TextoNode("Nenhum", "Empty"), 1,0, new TextoNode("",""), 0,0,TiposElementais.NaoElemental);
    }
}
