package com.daniel.Model.Dados.Magias.Poderes;

import com.daniel.Model.Interfaces.IEffects;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Model.Dados.Magias.Animation.CureAnimation;
import com.daniel.Model.Dados.Magias.Magia;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class Cure extends Magia implements IEffects {
    public Cure() {
        super("Sana", 10, 0, TiposElementais.NaoElemental,new CureAnimation(), false);
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        System.out.println("Alvo: " + alvo.getNome());
        alvo.RecuperarVida(50);
    }
}
