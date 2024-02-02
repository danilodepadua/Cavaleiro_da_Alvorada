package com.daniel.Modelo.Magia.Poderes;

import com.daniel.Modelo.Interfaces.IEffects;
import com.daniel.Modelo.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Dados.MagiasRepositório.StopAnimation;
import com.daniel.Modelo.Magia.Magia;
import com.daniel.Modelo.Magia.TiposElementais;

public class Stop extends Magia implements IEffects {
    public Stop() {
        super("Prohibere", 15, 0, TiposElementais.NaoElemental,new StopAnimation(), false);
        this.autoUsavel = false;
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        System.out.println("Alvo: " + alvo.getNome() + "/" + this.getClass().getName());
        alvo.aplicarStun();
        this.mensagem.add(alvo.getNome() + " foi paralizado");
    }
}
