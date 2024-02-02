package com.daniel.Modelo.Magia.Poderes;

import com.daniel.Modelo.Interfaces.IEffects;
import com.daniel.Modelo.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Dados.MagiasRepositório.FastAnimation;
import com.daniel.Modelo.Magia.Magia;
import com.daniel.Modelo.Magia.TiposElementais;

public class Fast extends Magia implements IEffects {
    public Fast() {
        super("Celer", 15, 0, TiposElementais.NaoElemental,new FastAnimation(), false);
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        System.out.println("Alvo: " + alvo.getNome());
        alvo.UpVel(10);
        this.mensagem.add(alvo.getNome() + " teve sua velocidade aumentada em 10");
    }
}