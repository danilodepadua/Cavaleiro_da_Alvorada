package com.daniel.PrimeiraCamada.Magias;

import com.daniel.PrimeiraCamada.GerenciadorDeBatalha;
import com.daniel.PrimeiraCamada.Interfaces.IEffects;
import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.PersonagemLuta;
import com.daniel.PrimeiraCamada.TiposElementais;
import com.daniel.SegundaCamada.FireAnimation;

public class Fogo extends Magia{
    public Fogo() {
        super("Parvum ignem",10, 1, TiposElementais.Fogo, new FireAnimation(), true);
    }
}
