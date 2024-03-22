package com.daniel.Model.Magias.Poderes;

import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Interfaces.IEffects;
import com.daniel.Model.Magias.Animacoes.BuffAnimation;
import com.daniel.Model.Magias.Magia;
import com.daniel.Model.Magias.TiposElementais;

public class Regen extends Magia implements IEffects {
    public Regen() {
        super("Regen", 20, 1.5, TiposElementais.NaoElemental,new BuffAnimation(), false);
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        alvo.aplicarRegen();
        this.mensagem.add(new TextoNode(alvo.getNome()+" começou a se regenerar",alvo.getNome()+" began to regenerate"));
    }
}
