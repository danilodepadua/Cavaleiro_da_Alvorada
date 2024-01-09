package com.daniel.PrimeiraCamada.Magias;

import com.daniel.PrimeiraCamada.GerenciadorDeBatalha;
import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.PersonagemLuta;
import com.daniel.PrimeiraCamada.TiposElementais;
import com.daniel.SegundaCamada.DarkAnimation;

public class Escuridao extends Magia {
    public Escuridao() {
        super("Dark",20, 1.5, TiposElementais.Escuridao, new DarkAnimation(), true);
    }
}
