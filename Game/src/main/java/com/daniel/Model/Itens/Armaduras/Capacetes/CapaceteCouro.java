package com.daniel.Model.Itens.Armaduras.Capacetes;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Armaduras.Capacete;

public class CapaceteCouro extends Capacete {
    public CapaceteCouro() {
        super("/com.daniel.Images/Itens/CapaceteCouro.png", new TextoNode("Capacete de Couro","Leather helmet"), 1, 8000, new TextoNode("Concede um aumento de 30 na defesa física e um aumento de 7 na defesa mágica", "Increases physical defense by 30 and magic defense by 7"), 30, 7);
    }

    public CapaceteCouro(int quant) {
        super("/com.daniel.Images/Itens/CapaceteCouro.png", new TextoNode("Capacete de Couro","leather helmet"), quant, 8000, new TextoNode("Concede um aumento de 30 na defesa física e um aumento de 7 na defesa mágica", "Increases physical defense by 30 and magic defense by 7"), 30, 7);
    }
}
