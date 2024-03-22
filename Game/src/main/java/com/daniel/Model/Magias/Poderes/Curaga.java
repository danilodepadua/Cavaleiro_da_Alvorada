package com.daniel.Model.Magias.Poderes;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Interfaces.IEffects;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Model.Magias.Animacoes.CuragaAnimation;
import com.daniel.Model.Magias.Magia;
import com.daniel.Model.Magias.TiposElementais;

public class Curaga extends Magia implements IEffects {
    public Curaga() {
        super("Sana multum", 30, 0, TiposElementais.NaoElemental,new CuragaAnimation(), false);
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        System.out.println("Alvo: " + alvo.getNome());
        alvo.RecuperarVida(500);
        this.mensagem.add(new TextoNode(alvo.getNome() + " teve sua vida curada em 500",alvo.getNome() + " has it's hp healed by 500"));
    }
}
