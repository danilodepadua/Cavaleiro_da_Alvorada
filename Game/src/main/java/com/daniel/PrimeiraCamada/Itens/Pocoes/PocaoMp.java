package com.daniel.PrimeiraCamada.Itens.Pocoes;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Interfaces.IConsumableInBattle;
import com.daniel.PrimeiraCamada.Interfaces.IConsumableOutBattle;
import com.daniel.PrimeiraCamada.Itens.Item;
import com.daniel.PrimeiraCamada.PersonagemLuta;

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
