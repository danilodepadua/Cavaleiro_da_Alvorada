package com.daniel.Modelo.Itens.Comidas;

import com.daniel.Dados.EntidadesRepositório.Player;
import com.daniel.Modelo.Exceptions.PlayerInexistenteException;
import com.daniel.Modelo.Interfaces.IConsumableInBattle;
import com.daniel.Modelo.Interfaces.IConsumableOutBattle;
import com.daniel.Modelo.Itens.Item;
import com.daniel.Modelo.BatalhaDeTurnos.PersonagemLuta;

public class Maça extends Item implements IConsumableOutBattle, IConsumableInBattle {
    public Maça() {
        super("/com.daniel.Images/Itens/Comidas/tile001.png", "Maça", 1, 7, "Recupera 15 de vida");
    }

    public Maça(int quant) {
        super("/com.daniel.Images/Itens/Comidas/tile001.png", "Maça", quant, 7, "Recupera 15 de vida");
    }
    @Override
    public String Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.RecuperarVida(15);
        Player.getPlayer().getInventario().RemoverItem(this);
        return "O jogador recuperou 15 de vida";
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().RecuperarVida(15);
        Player.getPlayer().getInventario().RemoverItem(this);
    }
}