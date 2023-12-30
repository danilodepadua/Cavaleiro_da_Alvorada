package com.daniel.PrimeiraCamada.Itens;

import com.daniel.PrimeiraCamada.Itens.Item;

public abstract class Armadura extends Item {

    protected int aumentoDefesaFisica;
    protected int aumentoDefesaMagica;
    protected int aumentoHp;

    public int getAumentoDefesa() {
        return 0;
    }

    @Override
    public int getPreco() {
        return 0;
    }
}
