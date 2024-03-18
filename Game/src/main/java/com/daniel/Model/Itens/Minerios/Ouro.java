package com.daniel.Model.Itens.Minerios;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Minerio;

public class Ouro extends Minerio {
    public Ouro(){
        super("/com.daniel.Images/Itens/Minerios/Ouro.png", new TextoNode("Minério de Ouro", "Gold ore"), 1, 80, new TextoNode("Minério Bruto de Ouro","Gold ore"));
    }

    public Ouro(int quant) {
        super("/com.daniel.Images/Itens/Minerios/Ouro.png", new TextoNode("Minério de Ouro", "Gold ore"), quant, 80, new TextoNode("Minério Bruto de Ouro","Gold ore"));
    }
}