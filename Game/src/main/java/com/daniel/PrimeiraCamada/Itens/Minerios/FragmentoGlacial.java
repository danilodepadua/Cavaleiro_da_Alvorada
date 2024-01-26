package com.daniel.PrimeiraCamada.Itens.Minerios;

import com.daniel.PrimeiraCamada.Itens.Item;

public class FragmentoGlacial extends Item {
    public FragmentoGlacial(){
        super("/com.daniel.Images/Itens/Minerios/FragmentoGlacial.png", "Fragmento Glacial", 1, 110, "Fragmento Glacial da Montanha");
    }

    public FragmentoGlacial(int quant) {
        super("/com.daniel.Images/Itens/Minerios/FragmentoGlacial.png", "Fragmento Glacial", quant, 110, "Fragmento Glacial da Montanha");
    }
}