package com.daniel.Model.Itens.Minerios;

import com.daniel.Model.Itens.Minerio;

public class Ferro extends Minerio {
    public Ferro(){
        super("/com.daniel.Images/Itens/Minerios/Ferro.png", "Minério de Ferro", 1, 10, "Minério Bruto de Ferro");
    }

    public Ferro(int quant) {
        super("/com.daniel.Images/Itens/Minerios/Ferro.png", "Minério de Ferro", quant, 10, "Minério Bruto de Ferro");
    }
}