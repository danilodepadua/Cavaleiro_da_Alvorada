package com.daniel.Model.Itens.Pocoes;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableInBattle;
import com.daniel.Model.Interfaces.IConsumableOutBattle;
import com.daniel.Model.Itens.Item;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;

public class PocaoMpGrande extends Item implements IConsumableOutBattle, IConsumableInBattle {

    public PocaoMpGrande(){
        super("/com.daniel.Images/Itens/Poções/mana potion.png", new TextoNode("Ether Grande", "Hi-Ether"), 1,50,new TextoNode("Poção que recupera 40 de MP","Potion that restores 40 of mp"));
    }

    public PocaoMpGrande(int quant) {
        super("/com.daniel.Images/Itens/Poções/mana potion.png", new TextoNode("Ether Grande", "Hi-Ether"), quant,50,new TextoNode("Poção que recupera 40 de MP","Potion that restores 40 of mp"));
    }

    @Override
    public String Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.RecuperarMana(40);
        Player.getPlayer().getInventario().removerItem(this);
        return "O jogador recuperou 40 de MP";
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().RecuperarMana(40);
        Player.getPlayer().getInventario().removerItem(this);
    }

}
