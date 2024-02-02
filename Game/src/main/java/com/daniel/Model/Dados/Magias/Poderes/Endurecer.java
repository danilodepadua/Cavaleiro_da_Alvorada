package com.daniel.Model.Dados.Magias.Poderes;

import com.daniel.Model.Interfaces.IEffects;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Model.Dados.Magias.Animation.BuffAnimation;
import com.daniel.Model.Dados.Magias.Magia;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class Endurecer extends Magia implements IEffects {
    public Endurecer() {
        super("Indura", 20,0, TiposElementais.NaoElemental, new BuffAnimation(), false);
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        System.out.println("Alvo: " + alvo.getNome());
        alvo.UpRes(10);
        this.mensagem.add(alvo.getNome() + " teve sua resistencia aumentada em 10");
    }
}
