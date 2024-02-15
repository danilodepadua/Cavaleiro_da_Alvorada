package com.daniel.Model.Itens.Minerios;

import com.daniel.Model.Itens.Minerio;

public class FragmentoEscuridao extends Minerio {
    public FragmentoEscuridao(){
        super("/com.daniel.Images/Itens/Minerios/FragmentoEscuridao.png", "Fragmento da Escuridão", 1, 70, "Pequeno fragmento da Escuridão");
    }

    public FragmentoEscuridao(int quant) {
        super("/com.daniel.Images/Itens/Minerios/FragmentoEscuridao.png", "Fragmento da Escuridão", quant, 70, "Pequeno fragmento da Escuridão");
    }
}
