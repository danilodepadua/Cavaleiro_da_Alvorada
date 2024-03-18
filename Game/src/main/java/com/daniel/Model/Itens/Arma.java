package com.daniel.Model.Itens;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Magias.TiposElementais;

public abstract class Arma extends Item {
    protected int aumentoDeAtaqueFisico;
    protected int aumentoDeAtaqueMagico;
    protected TiposElementais tipoDano;
    public Arma(String imgPath, TextoNode nome, int quant, int preco, TextoNode desc, int aumentoDeAtaqueFisico, int aumentoDeAtaqueMagico, TiposElementais tipoDano) {
        super(imgPath, nome, quant, preco, desc);
        this.aumentoDeAtaqueFisico = aumentoDeAtaqueFisico;
        this.aumentoDeAtaqueMagico = aumentoDeAtaqueMagico;
        this.tipoDano = tipoDano;
    }

    public int getAumentoDeAtaqueFisico() {
        return aumentoDeAtaqueFisico;
    }

    public int getAumentoDeAtaqueMagico() {
        return aumentoDeAtaqueMagico;
    }

    public TiposElementais getTipoDano(){
        return this.tipoDano;
    }
}
