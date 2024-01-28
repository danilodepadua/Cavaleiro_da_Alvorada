package com.daniel.PrimeiraCamada.ComportamentosInimigos;

import com.daniel.PrimeiraCamada.Comportamento;
import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.PersonagemLuta;

public class ComportamentoBoss extends Comportamento {
    public ComportamentoBoss(PersonagemLuta controlado, PersonagemLuta adversario) {
        super(controlado, adversario);
    }

    @Override
    public acoes LogicaEscolhaAcao() {
        return null;
    }

    @Override
    public Magia EscolherMagia() {
        return null;
    }
}
