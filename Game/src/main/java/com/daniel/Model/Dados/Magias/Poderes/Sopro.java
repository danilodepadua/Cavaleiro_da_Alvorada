package com.daniel.Model.Dados.Magias.Poderes;

import com.daniel.Model.Dados.Magias.Animation.RajadaAnimation;
import com.daniel.Model.Dados.Magias.Magia;
import com.daniel.Model.Dados.Magias.TiposElementais;

public class Sopro extends Magia {
    public Sopro() {
        super("Ventus", 15, 1.5, TiposElementais.Vento,new RajadaAnimation(), true);
    }
}
