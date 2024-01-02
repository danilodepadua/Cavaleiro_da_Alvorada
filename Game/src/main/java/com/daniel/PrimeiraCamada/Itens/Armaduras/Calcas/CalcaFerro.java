package com.daniel.PrimeiraCamada.Itens.Armaduras.Calcas;

import com.daniel.PrimeiraCamada.Itens.Armaduras.Calca;

public class CalcaFerro extends Calca {
    public CalcaFerro() {
        this.imagem = "/com.daniel.Images/Itens/CalcaFerro.png";
        this.descricao = "Concede um aumento de defesa física e de defesa mágica";
        this.nome ="Calça de Ferro";
        this.preço = 30;
        this.aumentoDefesaFisica = 50;
        this.aumentoDefesaMagica = 20;
    }
}
