package com.daniel.PrimeiraCamada.Itens.Armaduras.Capacetes;

import com.daniel.PrimeiraCamada.Itens.Armaduras.Capacete;

public class CapaceteFerro extends Capacete  {
    public CapaceteFerro() {
        super("/com.daniel.Images/Itens/CapaceteFerro.png", "Capacete de Ferro", 1, 400, "Concede um aumento de 120 na defesa física e um aumento de 30 na defesa mágica", 120, 30);
    }

    public CapaceteFerro(int quant) {
        super("/com.daniel.Images/Itens/CapaceteFerro.png", "Capacete de Ferro", quant, 400, "Concede um aumento de 120 na defesa física e um aumento de 30 na defesa mágica", 120, 30);
    }


}
