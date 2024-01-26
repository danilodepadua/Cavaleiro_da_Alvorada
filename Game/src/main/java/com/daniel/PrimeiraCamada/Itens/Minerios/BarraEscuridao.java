package com.daniel.PrimeiraCamada.Itens.Minerios;

import com.daniel.PrimeiraCamada.Itens.Item;

public class BarraEscuridao extends Item {
    public BarraEscuridao(){
        super("/com.daniel.Images/Itens/Minerios/BarraEscuridao.png", "Barra da Escuridão", 1, 200, "Barra refinada de fragmentos de escuridão");
    }

    public BarraEscuridao(int quant) {
        super("/com.daniel.Images/Itens/Minerios/BarraEscuridao.png", "Barra da Escuridão", quant, 200, "Barra refinada de fragmentos de escuridão");
    }
}
