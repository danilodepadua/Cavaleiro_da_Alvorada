package com.daniel.Model.ComportamentosInimigos;

import com.daniel.Model.BatalhaDeTurnos.Comportamento;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Interfaces.IEffects;
import com.daniel.Model.Magias.Magia;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Model.Magias.TiposElementais;
import com.daniel.Model.Magias.Animacoes.DebufAnimation;

import java.util.ArrayList;
import java.util.Random;

public class ComportamentoBossFinal2 extends Comportamento {
    Magia prop1 = new MagiaAmaldicoada(), prop2 = new MagiaAnjoDaMorte(), prop3 = new MagiaDegenerativa();
    ArrayList<Magia> magiasPossiveis = new ArrayList<>();
    int vidaProx;
    public ComportamentoBossFinal2(PersonagemLuta controlado, PersonagemLuta adversario) {
        super(controlado, adversario);
        vidaProx = controlado.getHP()/10;
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
        Random rand = new Random();
        if(this.vidaProx >= controlado.getCurrentHp()){
            this.vidaProx -= controlado.getHP()/10;
            int j = rand.nextInt(3);
            if(j==0){
                return prop1;
            }
            else if(j==1){
                return prop2;
            }
            else {
                return prop3;
            }
        }
        else{
            int i = rand.nextInt(magiasPossiveis.size());
            return magiasPossiveis.get(i);
        }
    }
}
class MagiaDegenerativa extends Magia implements IEffects {

    public MagiaDegenerativa() {
        super("Degeneratum", 100, 0, TiposElementais.NaoElemental, new DebufAnimation(), false);
        this.autoUsavel = false;
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        alvo.UpRes(-10);
        alvo.UpInt(-10);
        alvo.UpForca(-10);
        alvo.UpVel(-10);
        this.mensagem.add(new TextoNode(alvo.getNome() + " perdeu 10 pontos em todos os atributos",alvo.getNome() + " lost 10 points in all attributes"));
    }
}
class MagiaAmaldicoada extends Magia implements IEffects{

    public MagiaAmaldicoada() {
        super("Maledictio", 200, 0, TiposElementais.Escuridao, new DebufAnimation(), false);
        this.autoUsavel = false;
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        alvo.Envenenar();
        alvo.Cegar();
        alvo.Dormir();
        alvo.Silenciar();
        this.mensagem.add(new TextoNode(alvo.getNome() +" foi amaldiçoado com efeitos negativos",alvo.getNome() +" was cursed"));
    }
}
class MagiaAnjoDaMorte extends Magia implements IEffects{

    public MagiaAnjoDaMorte() {
        super("Angelus mortis", 300, 0, TiposElementais.NaoElemental, new DebufAnimation(), false);
        this.autoUsavel = false;
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        alvo.TomarDanoVerdadeiro(alvo.getCurrentHp()-1);
        this.mensagem.add(new TextoNode(alvo.getNome() + " teve sua vida reduzida para 1",alvo.getNome() + " has it's hp reduced to 1"));
    }
}
