package com.daniel.Model.Itens.Armaduras.Capacetes;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Armaduras.Capacete;

public class NullCapacete extends Capacete {
    public NullCapacete() {
        super("/com.daniel.Images/Itens/FundoCapacete.png", new TextoNode("Nenhum","Empty"), 1, 0, new TextoNode("",""), 0, 0);
    }
}
