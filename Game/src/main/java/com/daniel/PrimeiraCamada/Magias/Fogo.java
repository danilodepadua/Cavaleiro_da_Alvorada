package com.daniel.PrimeiraCamada.Magias;

import com.daniel.PrimeiraCamada.GerenciadorDeBatalha;
import com.daniel.PrimeiraCamada.Interfaces.IEffects;
import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.PersonagemLuta;
import com.daniel.PrimeiraCamada.TiposDano;
import com.daniel.SegundaCamada.FireAnimation;
import javafx.scene.image.ImageView;

public class Fogo extends Magia implements IEffects {
    public Fogo() {
        this.tiposDano = TiposDano.Fogo;
        this.Animation = new FireAnimation();
        this.custo = 10;
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        System.out.println("Defesa magica do Inimigo antes do ataque: "+ alvo.getDefM());
        alvo.reduzirDefesaMagica(10); // Reduz a defesa mágica do inimigo em 10
        System.out.println("Defesa magica do Inimigo apos o ataque: "+ alvo.getDefM());
    }
}
