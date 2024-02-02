package com.daniel.Model.Dados.Magias.Poderes;

import com.daniel.Model.Interfaces.IEffects;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Model.Dados.Magias.Animation.DebufAnimation;
import com.daniel.Model.Dados.Magias.Magia;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class Enfraquecer extends Magia implements IEffects {
    public Enfraquecer() {
        super("Debilitare", 20,0, TiposElementais.NaoElemental, new DebufAnimation(), false);
        this.autoUsavel = false;
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        System.out.println("Alvo: " + alvo.getNome());
        alvo.UpForca(-10);
        this.mensagem.add(alvo.getNome() + " teve sua força diminuida em 10");
    }
}
