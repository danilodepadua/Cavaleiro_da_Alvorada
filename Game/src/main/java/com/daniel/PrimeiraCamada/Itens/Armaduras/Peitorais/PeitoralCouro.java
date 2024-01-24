package com.daniel.PrimeiraCamada.Itens.Armaduras.Peitorais;

import com.daniel.PrimeiraCamada.Itens.Armaduras.Peitoral;

public class PeitoralCouro extends Peitoral  {

    public PeitoralCouro() {
        super("/com.daniel.Images/Itens/PeitoralCouro.png", "Armadura de Couro", 1, 200, "Concede um aumento de 60 na defesa física e um aumento de 20 na defesa mágica", 60, 20);
    }

    public PeitoralCouro(int quant) {
        super("/com.daniel.Images/Itens/PeitoralCouro.png", "Armadura de Couro", quant, 200, "Concede um aumento de 60 na defesa física e um aumento de 20 na defesa mágica", 60, 20);
    }
}
