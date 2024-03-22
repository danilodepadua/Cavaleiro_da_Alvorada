package com.daniel.Model.Itens.Minerios.FragP;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Minerio;

public class FragVel extends Minerio {
    public FragVel(){
        super("/com.daniel.Images/Itens/Joias/Crystals/Crystals 2/Crystals_Yellow  (7).png", new TextoNode("Lasca do tempo","Time splinter"), 1, 0, new TextoNode("Lasca de uma joia do tempo", "Splinter of a time gem"));
        this.precoVenda = 1;
    }

    public FragVel(int quant) {
        super("/com.daniel.Images/Itens/Joias/Crystals/Crystals 2/Crystals_Yellow  (7).png", new TextoNode("Lasca do tempo","Time splinter"), quant, 0, new TextoNode("Lasca de uma joia do tempo", "Splinter of a time gem"));
        this.precoVenda = 1;
    }
}
