package com.daniel.Model.Itens.Minerios;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Itens.Minerio;

public class FragmentoEscuridao extends Minerio {
    public FragmentoEscuridao(){
        super("/com.daniel.Images/Itens/Minerios/FragmentoEscuridao.png", new TextoNode("Fragmento da Escuridão","Shadow fragment"), 1, 70, new TextoNode("Pequeno fragmento da Escuridão","Tiny shadow fragment"));
    }

    public FragmentoEscuridao(int quant) {
        super("/com.daniel.Images/Itens/Minerios/FragmentoEscuridao.png", new TextoNode("Fragmento da Escuridão","Shadow fragment"), quant, 70, new TextoNode("Pequeno fragmento da Escuridão","Tiny shadow fragment"));
    }
}
