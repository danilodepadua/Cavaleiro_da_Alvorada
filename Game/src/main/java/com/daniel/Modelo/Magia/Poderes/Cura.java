package com.daniel.Modelo.Magia.Poderes;

import com.daniel.Modelo.Interfaces.IEffects;
import com.daniel.Modelo.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Dados.MagiasRepositório.CuraAnimation;
import com.daniel.Modelo.Magia.Magia;
import com.daniel.Modelo.Magia.TiposElementais;

public class Cura extends Magia implements IEffects {
    public Cura() {
        super("Sana magis", 20, 0, TiposElementais.NaoElemental,new CuraAnimation(), false);
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        System.out.println("Alvo: " + alvo.getNome());
        alvo.RecuperarVida(100);
    }
}
