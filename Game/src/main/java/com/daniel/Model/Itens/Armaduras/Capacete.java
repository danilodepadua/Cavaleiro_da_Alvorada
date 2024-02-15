package com.daniel.Model.Itens.Armaduras;

import com.daniel.Model.Itens.Armadura;

public abstract class Capacete extends Armadura  {
    public Capacete(String imgPath, String nome, int quant, int preco, String desc, int aumentoDefesaFisica, int aumentoDefesaMagica) {
        super(imgPath, nome, quant, preco, desc, aumentoDefesaFisica, aumentoDefesaMagica);
    }

}
