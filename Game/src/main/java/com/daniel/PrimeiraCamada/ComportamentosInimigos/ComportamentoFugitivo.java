package com.daniel.PrimeiraCamada.ComportamentosInimigos;

import com.daniel.PrimeiraCamada.Comportamento;
import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.PersonagemLuta;

import java.util.ArrayList;
import java.util.Random;

public class ComportamentoFugitivo extends Comportamento {

    int turnos = 0;
    ArrayList<Magia> magiasPossiveis = new ArrayList<>();
    public ComportamentoFugitivo(PersonagemLuta controlado, PersonagemLuta adversario) {
        super(controlado, adversario);
    }
    @Override
    public acoes LogicaEscolhaAcao() {
        Random rand = new Random();
        if(rand.nextInt(0, 100) < 33*turnos){
            return acoes.fugir;
        }
        turnos++;
        magiasPossiveis = new ArrayList<>();
        for(Magia m : this.controlado.getMagias()){
            if(this.controlado.getCurrentMp() >= m.getCusto()){
                magiasPossiveis.add(m);
            }
        }
        if(magiasPossiveis.isEmpty()){
            return acoes.atacar;
        }
        return acoes.usarMagia;
    }

    @Override
    public Magia EscolherMagia() {
        Random rand = new Random();
        int i = rand.nextInt(magiasPossiveis.size());
        System.out.println(magiasPossiveis.get(i).getNome());
        return magiasPossiveis.get(i);
    }
}
