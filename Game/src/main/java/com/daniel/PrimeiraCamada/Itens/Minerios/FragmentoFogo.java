package com.daniel.PrimeiraCamada.Itens.Minerios;

import com.daniel.PrimeiraCamada.Itens.Item;

public class FragmentoFogo extends Item {
    public FragmentoFogo(){
        super("/com.daniel.Images/Itens/Minerios/FragmentoFogo.png", "Fragmento de Fogo", 1, 60, "Pequeno fragmento de fogo mágico");
    }

    public FragmentoFogo(int quant) {
        super("/com.daniel.Images/Itens/Minerios/FragmentoFogo.png", "Fragmento de Fogo", quant, 60, "Pequeno fragmento de fogo mágico");
    }
}
