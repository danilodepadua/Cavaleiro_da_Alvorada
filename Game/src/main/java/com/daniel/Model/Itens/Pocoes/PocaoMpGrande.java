package com.daniel.Model.Itens.Pocoes;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableInBattle;
import com.daniel.Model.Interfaces.IConsumableOutBattle;
import com.daniel.Model.Itens.Item;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;

public class PocaoMpGrande extends Item implements IConsumableOutBattle, IConsumableInBattle {

    public PocaoMpGrande(){
        super("/com.daniel.Images/Itens/Poções/mana potion.png", "Ether Grande", 1,50,"Poção que recupera 40 de MP");
    }

    public PocaoMpGrande(int quant) {
        super("/com.daniel.Images/Itens/Poções/mana potion.png", "Ether Grande", quant,50,"Poção que recupera 40 de MP");
    }

    @Override
    public String Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.RecuperarMana(40);
        Player.getPlayer().getInventario().RemoverItem(this);
        return "O jogador recuperou 40 de MP";
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().RecuperarMana(40);
        Player.getPlayer().getInventario().RemoverItem(this);
    }

}
