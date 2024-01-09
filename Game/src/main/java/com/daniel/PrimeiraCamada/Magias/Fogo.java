package com.daniel.PrimeiraCamada.Magias;

import com.daniel.PrimeiraCamada.GerenciadorDeBatalha;
import com.daniel.PrimeiraCamada.Interfaces.IEffects;
import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.PersonagemLuta;
import com.daniel.PrimeiraCamada.TiposElementais;
import com.daniel.SegundaCamada.FireAnimation;

public class Fogo extends Magia implements IEffects {
    public Fogo() {
        super("Fogo",10, 1, TiposElementais.Fogo, new FireAnimation(), true);
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        System.out.println("Defesa magica do Inimigo antes do ataque: "+ alvo.getDefM());
        alvo.reduzirDefesaMagica(10); // Reduz a defesa mágica do inimigo em 10
    this.mensagem.add(alvo.getNome() + " teve sua defesa mágica reduzida em 10");
        System.out.println("Defesa magica do Inimigo apos o ataque: "+ alvo.getDefM());
    }
}
