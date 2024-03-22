package com.daniel.Model.ComportamentosInimigos;

import com.daniel.Model.BatalhaDeTurnos.Comportamento;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Model.Magias.Magia;

public class ComportamentoBossPorto extends Comportamento {
    public ComportamentoBossPorto(PersonagemLuta controlado, PersonagemLuta adversario) {
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
