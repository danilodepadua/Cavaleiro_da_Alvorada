package com.daniel.Modelo.Magia.Poderes;

import com.daniel.Modelo.Interfaces.IEffects;
import com.daniel.Modelo.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Dados.MagiasRepositório.CleanceAnimation;
import com.daniel.Modelo.Magia.Magia;
import com.daniel.Modelo.Magia.TiposElementais;

public class Visao extends Magia implements IEffects {
    public Visao() {
        super("Visio", 20, 0, TiposElementais.NaoElemental, new CleanceAnimation(), false);
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        System.out.println("Alvo: " + alvo.getNome());
        this.mensagem.add(alvo.descegar());
    }
}
