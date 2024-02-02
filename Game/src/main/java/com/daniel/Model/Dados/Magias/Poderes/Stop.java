package com.daniel.Model.Dados.Magias.Poderes;

import com.daniel.Model.Interfaces.IEffects;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Model.Dados.Magias.Animation.StopAnimation;
import com.daniel.Model.Dados.Magias.Magia;
import com.daniel.Model.Dados.Magias.TiposElementais;

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
