package com.daniel.Model.Magias.Poderes;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Interfaces.IEffects;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Model.Magias.Animacoes.StopAnimation;
import com.daniel.Model.Magias.Magia;
import com.daniel.Model.Magias.TiposElementais;

import java.util.Random;

public class Stop extends Magia implements IEffects {
    public Stop() {
        super("Prohibere", 15, 0, TiposElementais.NaoElemental,new StopAnimation(), false);
        this.autoUsavel = false;
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        System.out.println("Alvo: " + alvo.getNome() + "/" + this.getClass().getName());
        Random random = new Random();
        int i = random.nextInt(0,1);
        if(i>0.4) {
            alvo.aplicarStun();
            this.mensagem.add(new TextoNode(alvo.getNome() + " foi paralizado", alvo.getNome() + " was paralyzed"));
        }
    }
}
