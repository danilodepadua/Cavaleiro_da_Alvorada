package com.daniel.Model.Itens.Minerios.FragM;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Minerio;

public class FragIntM extends Minerio {
    public FragIntM(){
        super("/com.daniel.Images/Itens/Joias/Crystals/Crystals/Crystals (9).png", new TextoNode("Fragmento da sabedoria","Wisdom fragment"), 1, 0, new TextoNode("Fragmento de uma joia da sabedoria", "Fragment of a wisdom gem"));
        this.precoVenda = 3;
    }

    public FragIntM(int quant) {
        super("/com.daniel.Images/Itens/Joias/Crystals/Crystals/Crystals (9).png", new TextoNode("Fragmento da sabedoria","Wisdom fragment"), quant, 0, new TextoNode("Fragmento de uma joia da sabedoria", "Fragment of a wisdom gem"));
        this.precoVenda = 3;
    }
}
