package com.daniel.Modelo.Itens.Armaduras;

import com.daniel.Dados.EntidadesRepositório.Player;
import com.daniel.Modelo.Exceptions.PlayerInexistenteException;
import com.daniel.Modelo.Interfaces.IEquipable;
import com.daniel.Modelo.Itens.Armadura;

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
