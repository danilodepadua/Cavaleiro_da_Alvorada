package com.daniel.Model.Dados.Itens;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IEquipable;
import com.daniel.Model.Dados.Magias.TiposElementais;

public abstract class Arma extends Item implements IEquipable {
    protected int aumentoDeAtaqueFisico;
    protected int aumentoDeAtaqueMagico;
    protected TiposElementais tipoDano;
    public Arma(String imgPath, String nome, int quant, int preco, String desc, int aumentoDeAtaqueFisico, int aumentoDeAtaqueMagico, TiposElementais tipoDano) {
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

    @Override
    public void equipar() throws PlayerInexistenteException {
        Player.getPlayer().desequiparArma();
        Player.getPlayer().equiparArma(this);
    }

    @Override
    public void desequipar() throws PlayerInexistenteException {
        Player.getPlayer().desequiparArma();
    }
    public TiposElementais getTipoDano(){
        return this.tipoDano;
    }
}
