package com.daniel.PrimeiraCamada.Itens;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Interfaces.IConsumable;

public class PocaoMp extends Item implements IConsumable {

    public PocaoMp(){
        this.nome = "Ether";
        this.imagem = "/com.daniel.Images/Itens/pt2.png";
    }
    @Override
    public void Consumir() {
        Player.player.RecuperarMp(100);
    }
}
