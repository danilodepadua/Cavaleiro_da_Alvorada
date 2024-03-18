package com.daniel.Model.Dados.Textos;

import com.daniel.View.ConfiguracoesUsuario;

import java.io.Serializable;
import java.util.Objects;
import java.util.prefs.Preferences;

public class TextoNode implements Serializable {
    private String ptbr;
    private String Eng;

    public TextoNode(String ptbr, String eng) {
        this.ptbr = ptbr;
        this.Eng = eng;
    }

    public String getTexto(){
        if(Objects.equals(ConfiguracoesUsuario.obterIdioma(), "Português")){
            return ptbr;
        }
        else{
            return Eng;
        }
    }
}
