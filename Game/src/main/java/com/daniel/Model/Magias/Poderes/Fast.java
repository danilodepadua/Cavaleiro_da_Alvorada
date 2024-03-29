package com.daniel.Model.Magias.Poderes;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Interfaces.IEffects;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Model.Magias.Animacoes.FastAnimation;
import com.daniel.Model.Magias.Magia;
import com.daniel.Model.Magias.TiposElementais;

public class Fast extends Magia implements IEffects {
    public Fast() {
        super("Celer", 5, 0, TiposElementais.NaoElemental,new FastAnimation(), false);
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        System.out.println("Alvo: " + alvo.getNome());
        alvo.UpVel(1);
        this.mensagem.add(new TextoNode(alvo.getNome() + " teve sua velocidade aumentada em 1",alvo.getNome() + " has its speed increased by 1"));
    }
}