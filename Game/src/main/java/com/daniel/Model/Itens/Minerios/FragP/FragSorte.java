package com.daniel.Model.Itens.Minerios.FragP;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Minerio;

public class FragSorte extends Minerio {
    public FragSorte(){
        super("/com.daniel.Images/Itens/Joias/Crystals/Crystals 2/Crystals_Dull_Green (9).png", new TextoNode("Lasca da sorte","Luck splinter"), 1, 0, new TextoNode("Lasca de uma joia da sorte", "Splinter of a luck gem"));
        this.precoVenda = 1;
    }

    public FragSorte(int quant) {
        super("/com.daniel.Images/Itens/Joias/Crystals/Crystals 2/Crystals_Dull_Green (9).png", new TextoNode("Lasca da sorte","Luck splinter"), quant, 0, new TextoNode("Lasca de uma joia da sorte", "Splinter of a luck gem"));
        this.precoVenda = 1;
    }
}
