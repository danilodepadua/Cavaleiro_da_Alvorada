package com.daniel.Model.Itens.Minerios.FragM;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Minerio;

public class FragForceM extends Minerio {
    public FragForceM(){
        super("/com.daniel.Images/Itens/Joias/Crystals/Crystals/Crystals (7).png", new TextoNode("Fragmento do sorte","Power fragment"), 1, 0, new TextoNode("Fragmento de uma joia do poder", "Fragment of a power gem"));
        this.precoVenda = 3;
    }

    public FragForceM(int quant) {
        super("/com.daniel.Images/Itens/Joias/Crystals/Crystals/Crystals (7).png", new TextoNode("Fragmento do poder","Power fragment"), quant, 0, new TextoNode("Fragmento de uma joia do poder", "Fragment of a power gem"));
        this.precoVenda = 3;
    }
}
