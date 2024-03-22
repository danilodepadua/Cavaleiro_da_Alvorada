package com.daniel.Model.Itens.Minerios.FragP;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Minerio;

public class FragInt extends Minerio {
    public FragInt(){
        super("/com.daniel.Images/Itens/Joias/Crystals/Crystals 2/Crystals_Blue (2).png", new TextoNode("Lasca da sabedoria","Wisdom splinter"), 1, 0, new TextoNode("Lasca de uma joia de sabedoria", "Splinter of a wisdom gem"));
        this.precoVenda = 1;
    }

    public FragInt(int quant) {
        super("/com.daniel.Images/Itens/Joias/Crystals/Crystals 2/Crystals_Blue (2).png", new TextoNode("Lasca da sabedoria","Wisdom splinter"), quant, 0, new TextoNode("Lasca de uma joia da sabedoria", "Splinter of a wisdom gem"));
        this.precoVenda = 1;
    }
}
