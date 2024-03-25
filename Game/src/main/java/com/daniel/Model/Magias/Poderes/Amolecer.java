package com.daniel.Model.Magias.Poderes;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Interfaces.IEffects;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Model.Magias.Animacoes.DebufAnimation;
import com.daniel.Model.Magias.Magia;
import com.daniel.Model.Magias.TiposElementais;

public class Amolecer extends Magia implements IEffects {
    public Amolecer() {
        super("Emollire", 5,0, TiposElementais.NaoElemental, new DebufAnimation(), false);
        this.autoUsavel = false;
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        System.out.println("Alvo: " + alvo.getNome());
        alvo.UpRes(-1);
        this.mensagem.add(new TextoNode(alvo.getNome() + " teve sua resistencia diminuida em 1",alvo.getNome() + " has it's resistance decreased by 1"));
    }
}
