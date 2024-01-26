package com.daniel.PrimeiraCamada.ComportamentosInimigos;

import com.daniel.PrimeiraCamada.Comportamento;
import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.PersonagemLuta;

import java.util.ArrayList;
import java.util.Random;

public class ComportamentoPadrao extends Comportamento {
    public ComportamentoPadrao(PersonagemLuta controlado, PersonagemLuta adversario) {
        super(controlado, adversario);
    }

    ArrayList<Magia> magiasPossiveis;
    @Override
    public acoes EscolherAcao() {
        magiasPossiveis = new ArrayList<>();
        for(Magia m : this.controlado.getMagias()){
            if(this.controlado.getCurrentMp() >= m.getCusto()){
                magiasPossiveis.add(m);
            }
        }
        if(this.controlado.getCurrentHp() < (this.controlado.getHP()/2)){
            System.out.println("Fugir");
            return acoes.fugir;
        }
        else if(this.controlado.getCurrentHp() == (this.controlado.getHP())){
            System.out.println("Atacar");
            return acoes.atacar;
        }
        else{
            if(magiasPossiveis.isEmpty() || this.controlado.getSilenciado()){
                System.out.println("Atacar");
                return acoes.atacar;
            }
            System.out.println("Usar magia");
            return acoes.usarMagia;
        }
    }

    @Override
    public Magia EscolherMagia() {
        Random rand = new Random();
        int i = rand.nextInt(0, magiasPossiveis.size()-1);
        System.out.println(magiasPossiveis.get(i).getNome());
        return magiasPossiveis.get(i);
    }
}
