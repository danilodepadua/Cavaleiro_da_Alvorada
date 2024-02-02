package com.daniel.Model.Dados.Magias.Poderes;

import com.daniel.Model.Interfaces.IEffects;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Model.Dados.Magias.Animation.BuffAnimation;
import com.daniel.Model.Dados.Magias.Magia;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class Fortalecer extends Magia implements IEffects {
    public Fortalecer() {
        super("Fortis", 20,0, TiposElementais.NaoElemental, new BuffAnimation(), false);
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        System.out.println("Alvo: " + alvo.getNome());
        alvo.UpForca(10);
        this.mensagem.add(alvo.getNome() + " teve sua força aumentada em 10");
    }
}
