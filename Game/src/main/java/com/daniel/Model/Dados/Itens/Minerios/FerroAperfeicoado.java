package com.daniel.Model.Dados.Itens.Minerios;

import com.daniel.Model.Dados.Itens.Minerio;

public class FerroAperfeicoado extends Minerio {
    public FerroAperfeicoado(){
        super("/com.daniel.Images/Itens/Minerios/FerroAperfeicoado.png", "Ferro aperfeiçoado", 1, 50, "Ferro aperfeiçoado e brilhante");
    }

    public FerroAperfeicoado(int quant) {
        super("/com.daniel.Images/Itens/Minerios/FerroAperfeicoado.png", "Ferro aperfeiçoado", quant, 50, "Ferro aperfeiçoado e brilhante");
    }
}