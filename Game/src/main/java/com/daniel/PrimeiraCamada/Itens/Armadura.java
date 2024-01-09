package com.daniel.PrimeiraCamada.Itens;

import com.daniel.PrimeiraCamada.TiposElementais;

public abstract class Armadura extends Item {
    protected int aumentoDefesaFisica;
    protected int aumentoDefesaMagica;
    public int getAumentoDefesaF() {
        return aumentoDefesaFisica;
    }
    public int getAumentoDefesaM(){return aumentoDefesaMagica;}
    protected TiposElementais[] fraquezas;
    protected TiposElementais[] resistencias;
    protected TiposElementais[] imunidades;
    protected TiposElementais[] absorcao;
}
