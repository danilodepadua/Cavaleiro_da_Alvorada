package com.daniel.PrimeiraCamada.Itens.Armaduras.Capacetes;

import com.daniel.PrimeiraCamada.Itens.Armaduras.Capacete;

public class CapaceteCouro extends Capacete {
    public CapaceteCouro() {
        super("/com.daniel.Images/Itens/CapaceteCouro.png", "Capacete de Couro", 1, 100, "Concede um aumento de 30 na defesa física e um aumento de 7 na defesa mágica", 30, 7);
    }

    public CapaceteCouro(int quant) {
        super("/com.daniel.Images/Itens/CapaceteCouro.png", "Capacete de Couro", quant, 100, "Concede um aumento de 30 na defesa física e um aumento de 7 na defesa mágica", 30, 7);
    }
}
