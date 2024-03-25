package com.daniel.Model.Itens.Minerios;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Minerio;

public class FragmentoFogo extends Minerio {
    public FragmentoFogo(){
        super("/com.daniel.Images/Itens/Minerios/FragmentoFogo.png", new TextoNode("Fragmento de Fogo","Fire fragment"), 1, 6000, new TextoNode("Pequeno fragmento de fogo","Tiny fire fragment"));
    }

    public FragmentoFogo(int quant) {
        super("/com.daniel.Images/Itens/Minerios/FragmentoFogo.png", new TextoNode("Fragmento de Fogo","Fire fragment"), quant, 6000, new TextoNode("Pequeno fragmento de fogo","Tiny fire fragment"));
    }
}
