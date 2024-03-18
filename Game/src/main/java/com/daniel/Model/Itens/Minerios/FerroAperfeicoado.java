package com.daniel.Model.Itens.Minerios;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Minerio;

public class FerroAperfeicoado extends Minerio {
    public FerroAperfeicoado(){
        super("/com.daniel.Images/Itens/Minerios/FerroAperfeicoado.png", new TextoNode("Ferro aperfeiçoado","Enchanted iron"), 1, 50, new TextoNode("Ferro aperfeiçoado e brilhante","Enchanted and shiny iron"));
    }

    public FerroAperfeicoado(int quant) {
        super("/com.daniel.Images/Itens/Minerios/FerroAperfeicoado.png", new TextoNode("Ferro aperfeiçoado","Enchanted iron"), quant, 50, new TextoNode("Ferro aperfeiçoado e brilhante","Enchanted and shiny iron"));
    }
}