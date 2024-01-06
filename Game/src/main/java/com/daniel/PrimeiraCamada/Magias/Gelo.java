package com.daniel.PrimeiraCamada.Magias;

import com.daniel.PrimeiraCamada.GerenciadorDeBatalha;
import com.daniel.PrimeiraCamada.Interfaces.IEffects;
import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.PersonagemLuta;
import com.daniel.PrimeiraCamada.TiposDano;
import com.daniel.SegundaCamada.FireAnimation;
import com.daniel.SegundaCamada.IceAnimation;
import javafx.scene.image.ImageView;

public class Gelo extends Magia implements IEffects {
    public Gelo(ImageView imageView, GerenciadorDeBatalha gerenciadorDeBatalha) {
        this.gerenciadorDeBatalha = gerenciadorDeBatalha;
        this.tiposDano = TiposDano.Gelo;
        this.timeline = new IceAnimation().INICIAR(imageView);
        this.dano = 15;
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        gerenciadorDeBatalha.Ataque(timeline, dano, tiposDano);
        alvo.aplicarStun();
        System.out.println("Inimigo stunado");
    }
}