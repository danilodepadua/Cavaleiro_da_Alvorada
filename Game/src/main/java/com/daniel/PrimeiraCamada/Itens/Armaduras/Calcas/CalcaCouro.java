package com.daniel.PrimeiraCamada.Itens.Armaduras.Calcas;

import com.daniel.PrimeiraCamada.Itens.Armaduras.Calca;

public class CalcaCouro extends Calca {
    public CalcaCouro() {
        this.imagem = "/com.daniel.Images/Itens/CalcaCouro.png";
        this.descricao = "Concede um aumento de defesa física e de defesa mágica";
        this.nome ="Calça de Couro";
        this.preço = 5;
        this.aumentoDefesaFisica = 10;
        this.aumentoDefesaMagica = 3;
    }
}
