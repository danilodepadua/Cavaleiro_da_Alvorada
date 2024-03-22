package com.daniel.Model.Itens.Minerios.FragP;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Minerio;

public class FragRes extends Minerio {
    public FragRes(){
        super("/com.daniel.Images/Itens/Joias/Crystals/Crystals 2/Crystals_Yellow  (5).png", new TextoNode("Lasca da resiliência","Resilience splinter"), 1, 0, new TextoNode("Lasca de uma joia da resiliência", "Splinter of a resilience gem"));
        this.precoVenda = 1;
    }

    public FragRes(int quant) {
        super("/com.daniel.Images/Itens/Joias/Crystals/Crystals 2/Crystals_Yellow  (5).png", new TextoNode("Lasca da resiliência","Resilience splinter"), quant, 0, new TextoNode("Lasca de uma joia da resiliência", "Splinter of a resilience gem"));
        this.precoVenda = 1;
    }
}
