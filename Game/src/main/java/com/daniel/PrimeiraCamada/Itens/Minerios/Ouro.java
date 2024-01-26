package com.daniel.PrimeiraCamada.Itens.Minerios;

import com.daniel.PrimeiraCamada.Itens.Item;

public class Ouro extends Item {
    public Ouro(){
        super("/com.daniel.Images/Itens/Minerios/Ouro.png", "Minério de Ouro", 1, 80, "Minério Bruto de Ouro");
    }

    public Ouro(int quant) {
        super("/com.daniel.Images/Itens/Minerios/Ouro.png", "Minério de Ouro", quant, 80, "Minério Bruto de Ouro");
    }
}