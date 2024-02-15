package com.daniel.Model.Itens.Minerios;

import com.daniel.Model.Itens.Minerio;

public class FragmentoFogo extends Minerio {
    public FragmentoFogo(){
        super("/com.daniel.Images/Itens/Minerios/FragmentoFogo.png", "Fragmento de Fogo", 1, 60, "Pequeno fragmento de fogo mágico");
    }

    public FragmentoFogo(int quant) {
        super("/com.daniel.Images/Itens/Minerios/FragmentoFogo.png", "Fragmento de Fogo", quant, 60, "Pequeno fragmento de fogo mágico");
    }
}
