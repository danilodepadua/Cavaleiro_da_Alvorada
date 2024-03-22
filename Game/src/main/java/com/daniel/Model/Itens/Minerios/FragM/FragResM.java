package com.daniel.Model.Itens.Minerios.FragM;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Minerio;

public class FragResM extends Minerio {
    public FragResM(){
        super("/com.daniel.Images/Itens/Joias/Crystals/Crystals/Crystals (10).png", new TextoNode("Fragmento da resiliência","Resilience fragment"), 1, 0, new TextoNode("Fragmento de uma joia da resiliência", "Fragment of a resilience gem"));
        this.precoVenda = 3;
    }

    public FragResM(int quant) {
        super("/com.daniel.Images/Itens/Joias/Crystals/Crystals/Crystals (10).png", new TextoNode("Fragmento da resiliência","Resilience fragment"), quant, 0, new TextoNode("Fragmento de uma joia da resiliência", "Fragment of a resilience gem"));
        this.precoVenda = 3;
    }
}
