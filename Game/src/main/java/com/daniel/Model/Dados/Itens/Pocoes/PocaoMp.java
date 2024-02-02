package com.daniel.Model.Dados.Itens.Pocoes;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableInBattle;
import com.daniel.Model.Interfaces.IConsumableOutBattle;
import com.daniel.Model.Dados.Itens.Item;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;

public class PocaoMp extends Item implements IConsumableOutBattle, IConsumableInBattle {

    public PocaoMp(){
        super("/com.daniel.Images/Itens/Poções/basic mana potion.png", "Ether", 1,20,"Poção que recupera 15 de MP");
    }

    public PocaoMp(int quant) {
        super("/com.daniel.Images/Itens/Poções/basic mana potion.png", "Ether", quant,20,"Poção que recupera 15 de MP");
    }

    @Override
    public String Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.RecuperarMana(15);
        Player.getPlayer().getInventario().removerItem(this);
        return "O jogador recuperou 15 de MP";
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().RecuperarMana(15);
        Player.getPlayer().getInventario().removerItem(this);
    }

}
