package com.daniel.Model.Dados.Itens.Armaduras;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IEquipable;
import com.daniel.Model.Dados.Itens.Armadura;

public abstract class Peitoral extends Armadura implements IEquipable {

    public Peitoral(String imgPath, String nome, int quant, int preco, String desc, int aumentoDanoFisico, int aumentoDanoMagico) {
        super(imgPath, nome, quant, preco, desc, aumentoDanoFisico, aumentoDanoMagico);
    }

    @Override
    public void equipar() throws PlayerInexistenteException {
        Player.getPlayer().desequiparPeitoral();
        Player.getPlayer().equiparPeitoral(this);
    }

    @Override
    public void desequipar() throws PlayerInexistenteException {
        Player.getPlayer().desequiparPeitoral();
    }

}
