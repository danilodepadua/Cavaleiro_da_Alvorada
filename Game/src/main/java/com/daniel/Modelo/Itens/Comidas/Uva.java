package com.daniel.Modelo.Itens.Comidas;

import com.daniel.Dados.EntidadesRepositório.Player;
import com.daniel.Modelo.Exceptions.PlayerInexistenteException;
import com.daniel.Modelo.Interfaces.IConsumableInBattle;
import com.daniel.Modelo.Interfaces.IConsumableOutBattle;
import com.daniel.Modelo.Itens.Item;
import com.daniel.Modelo.BatalhaDeTurnos.PersonagemLuta;

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
        Player.getPlayer().getInventario().RemoverItem(this);
        return "O jogador recuperou 15 de mana";
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().RecuperarMana(15);
        Player.getPlayer().getInventario().RemoverItem(this);
    }
}
