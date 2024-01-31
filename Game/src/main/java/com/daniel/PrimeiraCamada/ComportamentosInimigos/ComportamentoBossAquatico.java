package com.daniel.PrimeiraCamada.ComportamentosInimigos;

import com.daniel.PrimeiraCamada.Comportamento;
import com.daniel.PrimeiraCamada.Interfaces.IEffects;
import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.PersonagemLuta;
import com.daniel.PrimeiraCamada.TiposElementais;
import com.daniel.SegundaCamada.AnimationsAttack;
import com.daniel.SegundaCamada.DebufAnimation;

import java.util.ArrayList;
import java.util.Random;

public class ComportamentoBossAquatico extends Comportamento {
    ArrayList<Magia> magiasPossiveis = new ArrayList<>();
    int vidaProx;
    Magia prop1;
    public ComportamentoBossAquatico(PersonagemLuta controlado, PersonagemLuta adversario) {
        super(controlado, adversario);
        prop1= new MagiaDrenoVel(controlado);
        vidaProx = controlado.getHP() - controlado.getHP()/4;
    }

    @Override
    public acoes LogicaEscolhaAcao() {
        Random rand = new Random();
        double i = rand.nextDouble(1);
        if(i>0.5){
            return acoes.atacar;
        }
        else{
            magiasPossiveis.clear();
            for(Magia m: controlado.getMagias()){
                if(controlado.getCurrentMp() >= m.getCusto()){
                    magiasPossiveis.add(m);
                }
            }
            if(magiasPossiveis.isEmpty()){
                return acoes.atacar;
            }
            else{
                return acoes.usarMagia;
            }
        }
    }

    @Override
    public Magia EscolherMagia() {
        if(controlado.getCurrentHp()<=vidaProx){
            vidaProx -= controlado.getHP()/4;
            return prop1;
        }
        else {
            Random rand = new Random();
            int i = rand.nextInt(magiasPossiveis.size());
            return magiasPossiveis.get(i);
        }
    }
}
class MagiaDrenoVel extends Magia implements IEffects{
    PersonagemLuta invo;
    public MagiaDrenoVel(PersonagemLuta invocador) {
        super ("Celeritas rapinam", 50, 0, TiposElementais.NaoElemental, new DebufAnimation(), false);
        this.invo = invocador;
        this.autoUsavel = false;
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        alvo.UpVel(-5);
        invo.UpVel(5);
        this.mensagem.add(alvo.getNome() + " teve sua velocidade roubada em 5 pontos");
    }
}
