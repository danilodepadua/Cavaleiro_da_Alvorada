package com.daniel.PrimeiraCamada.Itens.Minerios;

import com.daniel.PrimeiraCamada.Itens.Item;

public class Ferro extends Item {
    public Ferro(){
        super("/com.daniel.Images/Itens/Minerios/Ferro.png", "Minério de Ferro", 1, 10, "Minério Bruto de Ferro");
    }

    public Ferro(int quant) {
        super("/com.daniel.Images/Itens/Minerios/Ferro.png", "Minério de Ferro", quant, 10, "Minério Bruto de Ferro");
    }
}
