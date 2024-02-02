package com.daniel.Model.Itens;

import com.daniel.Model.Magias.TiposElementais;

public abstract class Armadura extends Item {
    protected int aumentoDefesaFisica;
    protected int aumentoDefesaMagica;

    public Armadura(String imgPath, String nome, int quant, int preco, String desc, int aumentoDefesaFisica, int aumentoDefesaMagica) {
        super(imgPath, nome, quant, preco, desc);
        this.aumentoDefesaFisica = aumentoDefesaFisica;
        this.aumentoDefesaMagica = aumentoDefesaMagica;
    }

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
