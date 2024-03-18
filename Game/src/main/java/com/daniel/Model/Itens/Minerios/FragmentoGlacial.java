package com.daniel.Model.Itens.Minerios;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Minerio;

public class FragmentoGlacial extends Minerio {
    public FragmentoGlacial(){
        super("/com.daniel.Images/Itens/Minerios/FragmentoGlacial.png", new TextoNode("Fragmento Glacial","Ice fragment"), 1, 110, new TextoNode("Fragmento Glacial da Montanha","Ice fragment"));
    }

    public FragmentoGlacial(int quant) {
        super("/com.daniel.Images/Itens/Minerios/FragmentoGlacial.png", new TextoNode("Fragmento Glacial","Ice fragment"), quant, 110, new TextoNode("Fragmento Glacial da Montanha","Ice fragment"));
    }
}