package com.daniel.Modelo.Magia.Poderes;

import com.daniel.Modelo.Interfaces.IEffects;
import com.daniel.Modelo.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Dados.MagiasRepositório.BuffAnimation;
import com.daniel.Modelo.Magia.Magia;
import com.daniel.Modelo.Magia.TiposElementais;

public class IntUp extends Magia implements IEffects {
    public IntUp() {
        super("Discite", 20,0, TiposElementais.NaoElemental, new BuffAnimation(), false);
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        System.out.println("Alvo: " + alvo.getNome());
        alvo.UpInt(10);
        this.mensagem.add(alvo.getNome() + " teve sua inteligencia aumentada em 10");
    }
}
