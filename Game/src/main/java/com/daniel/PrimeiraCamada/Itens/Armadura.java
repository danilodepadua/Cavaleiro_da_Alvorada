package com.daniel.PrimeiraCamada.Itens;

import com.daniel.PrimeiraCamada.TiposElementais;

public abstract class Armadura extends Item {
    protected int aumentoDefesaFisica;
    protected int aumentoDefesaMagica;
    public int getAumentoDefesaF() {
        return aumentoDefesaFisica;
    }
    public int getAumentoDefesaM(){return aumentoDefesaMagica;}
    protected TiposElementais[] fraquezas = new TiposElementais[0];
    protected TiposElementais[] resistencias = new TiposElementais[0];
    protected TiposElementais[] imunidades = new TiposElementais[0];
    protected TiposElementais[] absorcao = new TiposElementais[0];

    public TiposElementais[] getFraquezas() {
        return fraquezas;
    }

    public TiposElementais[] getResistencias() {
        return resistencias;
    }

    public TiposElementais[] getImunidades() {
        return imunidades;
    }

    public TiposElementais[] getAbsorcao() {
        return absorcao;
    }
}
