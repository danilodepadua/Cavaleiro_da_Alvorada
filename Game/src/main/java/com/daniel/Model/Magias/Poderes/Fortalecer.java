package com.daniel.Model.Magias.Poderes;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Interfaces.IEffects;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Model.Magias.Animacoes.BuffAnimation;
import com.daniel.Model.Magias.Magia;
import com.daniel.Model.Magias.TiposElementais;

public class Fortalecer extends Magia implements IEffects {
    public Fortalecer() {
        super("Fortis", 5,0, TiposElementais.NaoElemental, new BuffAnimation(), false);
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        System.out.println("Alvo: " + alvo.getNome());
        alvo.UpForca(1);
        this.mensagem.add(new TextoNode(alvo.getNome() + " teve sua força aumentada em 1",alvo.getNome() + " has it's strength increased by 1"));
    }
}
