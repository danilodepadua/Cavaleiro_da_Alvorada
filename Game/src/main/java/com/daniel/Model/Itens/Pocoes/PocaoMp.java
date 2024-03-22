package com.daniel.Model.Itens.Pocoes;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableInBattle;
import com.daniel.Model.Interfaces.IConsumableOutBattle;
import com.daniel.Model.Itens.Item;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;

public class PocaoMp extends Item implements IConsumableOutBattle, IConsumableInBattle {

    public PocaoMp(){
        super("/com.daniel.Images/Itens/Poções/basic mana potion.png", new TextoNode("Ether", "Ether"), 1,20,new TextoNode("Poção que recupera 15 de MP","Potion that restores 15 of mp"));
    }

    public PocaoMp(int quant) {
        super("/com.daniel.Images/Itens/Poções/basic mana potion.png", new TextoNode("Ether", "Ether"), quant,20,new TextoNode("Poção que recupera 15 de MP","Potion that restores 15 of mp"));
    }

    @Override
    public TextoNode Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.RecuperarMana(15);
        Player.getPlayer().getInventario().removerItem(this);
        return new TextoNode("O jogador recuperou 15 de mp","The player recover 15 of mp");
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().RecuperarMana(15);
        Player.getPlayer().getInventario().removerItem(this);
    }

}
