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
        super("/com.daniel.Images/Itens/Poções/mana potion.png", new TextoNode("Ether Grande", "Hi-Ether"), 1,1500,new TextoNode("Poção que recupera 250 de MP","Potion that restores 250 of mp"));
    }

    public PocaoMpGrande(int quant) {
        super("/com.daniel.Images/Itens/Poções/mana potion.png", new TextoNode("Ether Grande", "Hi-Ether"), quant,1500,new TextoNode("Poção que recupera 250 de MP","Potion that restores 250 of mp"));
    }

    @Override
    public TextoNode Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.RecuperarMana(250);
        Player.getPlayer().getInventario().removerItem(this);
        return new TextoNode("O jogador recuperou 250 de mp","The player recover 250 of mp");
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().RecuperarMana(250);
        Player.getPlayer().getInventario().removerItem(this);
    }

}
