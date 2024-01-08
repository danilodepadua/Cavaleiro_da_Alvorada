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
    public Gelo() {
        super(10, 1, TiposDano.Gelo, new IceAnimation());
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo) {
        alvo.aplicarStun();
        System.out.println("Inimigo stunado");
    }
}