package com.daniel.PrimeiraCamada.Itens.Armaduras.Peitorais;

import com.daniel.PrimeiraCamada.Itens.Armaduras.Peitoral;

public class PeitoralMalha extends Peitoral {
    public PeitoralMalha() {
        super("/com.daniel.Images/Itens/Peitoral Malha.png", "Peitoral de Malha", 1, 400, "Concede um aumento de 120 na defesa física e um aumento de 40 na defesa mágica", 120, 40);
    }

    public PeitoralMalha(int quant) {
        super("/com.daniel.Images/Itens/Peitoral Malha.png", "Peitoral de Malha", quant, 400, "Concede um aumento de 120 na defesa física e um aumento de 40 na defesa mágica", 120, 40);
    }
}
