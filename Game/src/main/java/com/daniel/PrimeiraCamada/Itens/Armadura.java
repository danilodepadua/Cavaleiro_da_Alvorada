package com.daniel.PrimeiraCamada.Itens;

import com.daniel.PrimeiraCamada.Itens.Item;
import com.daniel.PrimeiraCamada.TiposDano;

public abstract class Armadura extends Item {

    protected int aumentoDefesaFisica;
    protected int aumentoDefesaMagica;

    public int getAumentoDefesaF() {
        return aumentoDefesaFisica;
    }
    public int getAumentoDefesaM(){return aumentoDefesaMagica;}

    @Override
    public int getPreco() {
        return 0;
    }

    protected TiposDano[] fraquezas;
    protected TiposDano[] resistencias;
    protected TiposDano[] imunidades;
    protected TiposDano[] absorcao;
}
