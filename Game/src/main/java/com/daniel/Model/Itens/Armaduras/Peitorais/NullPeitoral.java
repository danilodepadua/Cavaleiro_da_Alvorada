package com.daniel.Model.Itens.Armaduras.Peitorais;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Armaduras.Peitoral;

public class NullPeitoral extends Peitoral {
    public NullPeitoral() {
        super("/com.daniel.Images/Itens/FundoPeitoral.png", new TextoNode("Nenhum","Empty"), 1, 100, new TextoNode("",""), 0, 0);
    }
}
