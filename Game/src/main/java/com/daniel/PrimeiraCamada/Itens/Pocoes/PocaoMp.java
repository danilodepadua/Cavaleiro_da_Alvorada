package com.daniel.PrimeiraCamada.Itens.Pocoes;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Interfaces.IConsumable;
import com.daniel.PrimeiraCamada.Itens.Item;

public class PocaoMp extends Item implements IConsumable {

    public PocaoMp(){
        this.nome = "Ether";
        this.imagem = "/com.daniel.Images/Itens/pt2.png";
        this.preço = 20; // Preço inicial
        this.descricao = "Poção que concede recuperação de vida";

    }
    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().RecuperarMana(100);
    }

}
