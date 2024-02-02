package com.daniel.Modelo.Itens.Pocoes;

import com.daniel.Dados.EntidadesRepositório.Player;
import com.daniel.Modelo.Exceptions.PlayerInexistenteException;
import com.daniel.Modelo.Interfaces.IConsumableInBattle;
import com.daniel.Modelo.Interfaces.IConsumableOutBattle;
import com.daniel.Modelo.Itens.Item;
import com.daniel.Modelo.BatalhaDeTurnos.PersonagemLuta;

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
        Player.getPlayer().getInventario().RemoverItem(this);
        return "O jogador recuperou 15 de MP";
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().RecuperarMana(15);
        Player.getPlayer().getInventario().RemoverItem(this);
    }

}
