package com.daniel.Model.Magias.Poderes;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Interfaces.IEffects;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Model.Magias.Animacoes.CuraAnimation;
import com.daniel.Model.Magias.Magia;
import com.daniel.Model.Magias.TiposElementais;

public class Cura extends Magia implements IEffects {
    public Cura() {
        super("Sana magis", 20, 0, TiposElementais.NaoElemental,new CuraAnimation(), false);
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        System.out.println("Alvo: " + alvo.getNome());
        alvo.RecuperarVida(100);
        this.mensagem.add(new TextoNode(alvo.getNome() + " teve sua vida curada em 100",alvo.getNome() + " has it's hp healed by 100"));
    }
}
