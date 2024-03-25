package com.daniel.Model.Magias.Poderes;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Interfaces.IEffects;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Model.Magias.Animacoes.SlowAnimation;
import com.daniel.Model.Magias.Magia;
import com.daniel.Model.Magias.TiposElementais;

public class Slow extends Magia implements IEffects {
    public Slow() {
        super("Tardus", 5, 0, TiposElementais.NaoElemental,new SlowAnimation(), false);
        this.autoUsavel = false;
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        System.out.println("Alvo: " + alvo.getNome());
        alvo.UpVel(-1);
        this.mensagem.add(new TextoNode(alvo.getNome() + " teve sua velocidade diminuida em 1",alvo.getNome() + " has it's speed decreased by 1"));
    }
}
