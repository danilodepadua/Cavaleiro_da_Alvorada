package com.daniel.PrimeiraCamada.Itens.Armaduras.Peitorais;

import com.daniel.PrimeiraCamada.Itens.Armaduras.Peitoral;

public class PeitoralFerro extends Peitoral  {

    public PeitoralFerro() {
        super("/com.daniel.Images/Itens/PeitoralFerro.png", "Peitoral de Ferro", 1, 600, "Concede um aumento de 240 na defesa física e um aumento de 80 na defesa mágica", 240, 80);
    }

    public PeitoralFerro(int quant) {
        super("/com.daniel.Images/Itens/PeitoralFerro.png", "Peitoral de Ferro", quant, 600, "Concede um aumento de 240 na defesa física e um aumento de 80 na defesa mágica", 240, 80);
    }

}
