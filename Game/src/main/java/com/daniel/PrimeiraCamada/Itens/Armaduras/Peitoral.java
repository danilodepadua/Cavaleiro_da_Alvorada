package com.daniel.PrimeiraCamada.Itens.Armaduras;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Interfaces.IEquipable;
import com.daniel.PrimeiraCamada.Itens.Armadura;

public  class Peitoral extends Armadura implements IEquipable {
    public Peitoral(){
        this.aumentoDefesaFisica = 0;
        this.aumentoDefesaMagica=0;
        this.imagem = "/com.daniel.Images/Itens/FundoPeitoral.png";
        this.nome = "";
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
