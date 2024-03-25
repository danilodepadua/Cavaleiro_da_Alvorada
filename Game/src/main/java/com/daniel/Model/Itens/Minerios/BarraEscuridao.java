package com.daniel.Model.Itens.Minerios;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Minerio;

public class BarraEscuridao extends Minerio {
    public BarraEscuridao(){
        super("/com.daniel.Images/Itens/Minerios/BarraEscuridao.png", new TextoNode("Barra da Escuridão","Shadow bar"), 1, 20000, new TextoNode("Barra refinada de fragmentos de escuridão", "Refined bar of shadow fragments"));
    }

    public BarraEscuridao(int quant) {
        super("/com.daniel.Images/Itens/Minerios/BarraEscuridao.png", new TextoNode("Barra da Escuridão","Shadow bar"), quant, 20000, new TextoNode("Barra refinada de fragmentos de escuridão", "Refined bar of shadow fragments"));
    }
}
