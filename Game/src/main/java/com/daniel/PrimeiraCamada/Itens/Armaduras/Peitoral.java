package com.daniel.PrimeiraCamada.Itens.Armaduras;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Interfaces.IEquipable;
import com.daniel.PrimeiraCamada.Itens.Armadura;

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
