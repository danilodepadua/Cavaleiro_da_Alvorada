package com.daniel.Model.Itens.Comidas;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableInBattle;
import com.daniel.Model.Interfaces.IConsumableOutBattle;
import com.daniel.Model.Itens.Item;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;

public class Uva extends Item implements IConsumableOutBattle, IConsumableInBattle {
    public Uva() {
        super("/com.daniel.Images/Itens/Comidas/tile002.png", "Uva", 1, 7, "Recupera 15 de mana");
    }

    public Uva(int quant) {
        super("/com.daniel.Images/Itens/Comidas/tile002.png", "Uva", quant, 7, "Recupera 15 de mana");
    }
    @Override
    public String Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.RecuperarMana(15);
        Player.getPlayer().getInventario().removerItem(this);
        return "O jogador recuperou 15 de mana";
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().RecuperarMana(15);
        Player.getPlayer().getInventario().removerItem(this);
    }
}
