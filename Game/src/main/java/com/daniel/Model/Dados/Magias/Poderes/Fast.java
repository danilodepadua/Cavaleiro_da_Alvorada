package com.daniel.Model.Dados.Magias.Poderes;

import com.daniel.Model.Interfaces.IEffects;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Model.Dados.Magias.Animation.FastAnimation;
import com.daniel.Model.Dados.Magias.Magia;
import com.daniel.Model.Dados.Magias.TiposElementais;

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