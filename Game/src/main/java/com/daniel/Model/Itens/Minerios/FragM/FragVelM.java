package com.daniel.Model.Itens.Minerios.FragM;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Minerio;

public class FragVelM extends Minerio {
    public FragVelM(){
        super("/com.daniel.Images/Itens/Joias/Crystals/Crystals/Crystals (8).png", new TextoNode("Fragmento do tempo","Time fragment"), 1, 0, new TextoNode("Fragmento de uma joia do tempo", "Fragment of a time gem"));
        this.precoVenda = 1;
    }

    public FragVelM(int quant) {
        super("/com.daniel.Images/Itens/Joias/Crystals/Crystals/Crystals (8).png", new TextoNode("Fragmento do tempo","Time fragment"), quant, 0, new TextoNode("Fragmento de uma joia do tempo", "Fragment of a time gem"));
        this.precoVenda = 1;
    }
}
