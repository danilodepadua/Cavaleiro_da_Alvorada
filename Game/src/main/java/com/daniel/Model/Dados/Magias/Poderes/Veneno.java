package com.daniel.Model.Dados.Magias.Poderes;

import com.daniel.Model.Interfaces.IEffects;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Model.Dados.Magias.Animation.VenenoAnimation;
import com.daniel.Model.Dados.Magias.Magia;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class Veneno extends Magia implements IEffects {
    public Veneno() {
        super("Venenum", 15, 1.5, TiposElementais.NaoElemental,new VenenoAnimation(), true);
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        System.out.println("Alvo: " + alvo.getNome());
        this.mensagem.add(alvo.Envenenar());
    }
}
