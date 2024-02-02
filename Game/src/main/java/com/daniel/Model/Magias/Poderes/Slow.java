package com.daniel.Model.Magias.Poderes;

import com.daniel.Model.Interfaces.IEffects;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Model.Magias.Animation.SlowAnimation;
import com.daniel.Model.Magias.Magia;
import com.daniel.Model.Magias.TiposElementais;

public class Slow extends Magia implements IEffects {
    public Slow() {
        super("Tardus", 15, 0, TiposElementais.NaoElemental,new SlowAnimation(), false);
        this.autoUsavel = false;
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        System.out.println("Alvo: " + alvo.getNome());
        alvo.UpVel(-10);
        this.mensagem.add(alvo.getNome() + " teve sua velocidade diminuida em 10");
    }
}
