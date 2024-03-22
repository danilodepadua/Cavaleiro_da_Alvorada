package com.daniel.Model.Itens.Minerios.FragM;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Minerio;

public class FragSorteM extends Minerio {
    public FragSorteM(){
        super("/com.daniel.Images/Itens/Joias/Crystals/Crystals/Crystals (11).png", new TextoNode("Fragmento da sorte","Luck fragment"), 1, 0, new TextoNode("Fragmento de uma joia da sorte", "Fragment of a luck gem"));
        this.precoVenda = 3;
    }

    public FragSorteM(int quant) {
        super("/com.daniel.Images/Itens/Joias/Crystals/Crystals/Crystals (11).png", new TextoNode("Fragmento da sorte","Luck fragment"), quant, 0, new TextoNode("Fragmento de uma joia da sorte", "Fragment of a luck gem"));
        this.precoVenda = 3;
    }
}
