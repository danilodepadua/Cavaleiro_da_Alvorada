package com.daniel.Model.Magias.Poderes;

import com.daniel.Model.Magias.Animacoes.RajadaAnimation;
import com.daniel.Model.Magias.Magia;
import com.daniel.Model.Magias.TiposElementais;

public class Sopro extends Magia {
    public Sopro() {
        super("Ventus", 15, 1.5, TiposElementais.Vento,new RajadaAnimation(), true);
    }
}
