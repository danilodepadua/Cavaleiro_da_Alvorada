package com.daniel.Model.Magias.Poderes;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Interfaces.IEffects;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Model.Magias.Animacoes.BuffAnimation;
import com.daniel.Model.Magias.Magia;
import com.daniel.Model.Magias.TiposElementais;

public class IntUp extends Magia implements IEffects {
    public IntUp() {
        super("Discite", 5,0, TiposElementais.NaoElemental, new BuffAnimation(), false);
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        System.out.println("Alvo: " + alvo.getNome());
        alvo.UpInt(1);
        this.mensagem.add(new TextoNode(alvo.getNome() + " teve sua inteligencia aumentada em 1",alvo.getNome() + " has it's intelligence increased by 1"));
    }
}
