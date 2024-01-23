package com.daniel.PrimeiraCamada.Magias;

import com.daniel.PrimeiraCamada.Interfaces.IEffects;
import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.PersonagemLuta;
import com.daniel.PrimeiraCamada.TiposElementais;
import com.daniel.SegundaCamada.AnimationsAttack;
import com.daniel.SegundaCamada.CleanceAnimation;

public class Recuperar extends Magia implements IEffects {
    public Recuperar(){
        super("Restaurata", 30, 0, TiposElementais.NaoElemental, new CleanceAnimation(), false);
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        System.out.println("Alvo: " + alvo.getNome());
        this.mensagem.add(alvo.descegar());
        this.mensagem.add(alvo.dessilenciar());
        this.mensagem.add(alvo.Desenvenenar());
    }
}
