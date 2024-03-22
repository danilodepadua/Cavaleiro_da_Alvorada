package com.daniel.Model.Magias.Poderes;

import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Interfaces.IEffects;
import com.daniel.Model.Magias.Animacoes.DebufAnimation;
import com.daniel.Model.Magias.Animacoes.VenenoAnimation;
import com.daniel.Model.Magias.Magia;
import com.daniel.Model.Magias.TiposElementais;

public class Scan extends Magia implements IEffects {
    public Scan() {
        super("Scan", 15, 1.5, TiposElementais.NaoElemental,new DebufAnimation(), false);
        this.autoUsavel = false;
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        this.mensagem.add(new TextoNode("Escaneando " + alvo.getNome(),"Scanning " + alvo.getNome()));
        this.mensagem.add(new TextoNode("HP: " + alvo.getCurrentHp()+"/"+alvo.getHP(),"HP: " + alvo.getCurrentHp()+"/"+alvo.getHP()));
        this.mensagem.add(new TextoNode("MP: " + alvo.getCurrentMp()+"/"+alvo.getMP(),"MP: " + alvo.getCurrentMp()+"/"+alvo.getMP()));
        for(TiposElementais t : alvo.getFraquezas()){
            this.mensagem.add(new TextoNode("Fraqueza: " + t.name(), "Weakness: " + t.name()));
        }
        for(TiposElementais t : alvo.getResistencias()){
            this.mensagem.add(new TextoNode("Resistência: " + t.name(), "Resistance: " + t.name()));
        }
        for(TiposElementais t : alvo.getImunidades()){
            this.mensagem.add(new TextoNode("Imunidade: " + t.name(), "Immunity: " + t.name()));
        }
        for(TiposElementais t : alvo.getAbsorcao()){
            this.mensagem.add(new TextoNode("Afinidade: " + t.name(), "Affinity: " + t.name()));
        }
    }
}
