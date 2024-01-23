package com.daniel.PrimeiraCamada.Magias;

import com.daniel.PrimeiraCamada.GerenciadorDeBatalha;
import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.PersonagemLuta;
import com.daniel.PrimeiraCamada.TiposElementais;
import com.daniel.SegundaCamada.HolyAnimation;

public class Luz extends Magia {
    public Luz() {
        super("Lux",20, 1.5, TiposElementais.Luz, new HolyAnimation(), true);
    }
}
