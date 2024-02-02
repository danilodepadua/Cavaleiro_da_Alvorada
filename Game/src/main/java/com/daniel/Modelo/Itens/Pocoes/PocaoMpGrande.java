package com.daniel.Modelo.Itens.Pocoes;

import com.daniel.Dados.EntidadesRepositório.Player;
import com.daniel.Modelo.Exceptions.PlayerInexistenteException;
import com.daniel.Modelo.Interfaces.IConsumableInBattle;
import com.daniel.Modelo.Interfaces.IConsumableOutBattle;
import com.daniel.Modelo.Itens.Item;
import com.daniel.Modelo.BatalhaDeTurnos.PersonagemLuta;

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
