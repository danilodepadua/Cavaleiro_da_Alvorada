package com.daniel.Modelo.ComportamentosInimigos;

import com.daniel.Modelo.BatalhaDeTurnos.Comportamento;
import com.daniel.Modelo.Interfaces.IEffects;
import com.daniel.Modelo.Magia.Magia;
import com.daniel.Modelo.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Modelo.Magia.TiposElementais;
import com.daniel.Dados.MagiasRepositório.BuffAnimation;

import java.util.*;

public class ComportamentoBossFinal1 extends Comportamento {
    int vidaProx;
    Magia magiaPropria = new MagiaPropria();
    ArrayList<Magia> magiasPossiveis = new ArrayList<>();
    public ComportamentoBossFinal1(PersonagemLuta controlado, PersonagemLuta adversario) {
        super(controlado, adversario);
        vidaProx = controlado.getHP() - 600;
        System.out.println("Prox: " + vidaProx);
    }

    @Override
    public acoes LogicaEscolhaAcao() {
        Random rand = new Random();
        System.out.println("Vida atual: " + controlado.getCurrentHp());
        System.out.println("Prox: " + vidaProx);
        double d = rand.nextDouble(0,1);
        if(d > 0.8){
            return acoes.atacar;
        }
        else{
            magiasPossiveis.clear();
            for(Magia m : controlado.getMagias()){
                if(controlado.getCurrentMp() >= m.getCusto()){
                    magiasPossiveis.add(m);
                }
            }
            if(!magiasPossiveis.isEmpty()){
                return acoes.usarMagia;
            }
            return acoes.atacar;
        }
    }

    @Override
    public Magia EscolherMagia() {
        if(this.vidaProx >= controlado.getCurrentHp()){
            this.vidaProx -= 600;
            return magiaPropria;
        }
        else{
            Random rand = new Random();
            int i = rand.nextInt(magiasPossiveis.size());
            return magiasPossiveis.get(i);
        }
    }
}

class MagiaPropria extends Magia implements IEffects {

    TiposElementais[] conjunto1 = new TiposElementais[]{TiposElementais.Vento, TiposElementais.Gelo};
    TiposElementais[] conjunto2 = new TiposElementais[]{TiposElementais.Fogo, TiposElementais.Eletrico};
    TiposElementais[] conjunto3 = new TiposElementais[]{TiposElementais.Luz, TiposElementais.Terra};
    TiposElementais[] conjunto4 = new TiposElementais[]{TiposElementais.Escuridao, TiposElementais.NaoElemental};

    TiposElementais[][] conjuntos = new TiposElementais[][]{conjunto1, conjunto2, conjunto3, conjunto4};
    public MagiaPropria() {
        super("Mudar afinidade elemental", 50, 0, TiposElementais.NaoElemental, new BuffAnimation(), false);
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        Collections.shuffle(Arrays.asList(conjuntos));
        alvo.setFraquezas(conjuntos[0]);
        alvo.setResistencias(conjuntos[1]);
        alvo.setImunidades(conjuntos[2]);
        alvo.setAbsorcao(conjuntos[3]);
        this.mensagem.add(alvo.getNome() + " mudou a sua afinidade alemental");
    }
}
