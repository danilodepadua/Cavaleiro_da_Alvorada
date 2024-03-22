package com.daniel.Model.Itens.Minerios.FragP;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Minerio;

public class FragForce extends Minerio {
    public FragForce(){
        super("/com.daniel.Images/Itens/Joias/Crystals/Crystals 2/Crystals_Dull_Red  (3).png", new TextoNode("Lasca do poder","Power splinter"), 1, 0, new TextoNode("Lasca de uma joia do poder", "Splinter of a power gem"));
        this.precoVenda = 1;
    }

    public FragForce(int quant) {
        super("/com.daniel.Images/Itens/Joias/Crystals/Crystals 2/Crystals_Dull_Red  (3).png", new TextoNode("Lasca do poder","Power splinter"), quant, 0, new TextoNode("Lasca de uma joia do poder", "Splinter of a power gem"));
        this.precoVenda = 1;
    }
}
