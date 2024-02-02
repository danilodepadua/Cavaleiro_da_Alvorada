package com.daniel.Modelo.Itens.Comidas;

import com.daniel.Dados.EntidadesRepositório.Player;
import com.daniel.Modelo.Exceptions.PlayerInexistenteException;
import com.daniel.Modelo.Interfaces.IConsumableInBattle;
import com.daniel.Modelo.Interfaces.IConsumableOutBattle;
import com.daniel.Modelo.Itens.Item;
import com.daniel.Modelo.BatalhaDeTurnos.PersonagemLuta;

public class Banana extends Item implements IConsumableOutBattle, IConsumableInBattle {
    public Banana() {
        super("/com.daniel.Images/Itens/Comidas/tile000.png", "Banana", 1, 10, "Recupera 20 de vida");
    }

    public Banana(int quant) {
        super("/com.daniel.Images/Itens/Comidas/tile000.png", "Banana", quant, 10, "Recupera 20 de vida");
    }
    @Override
    public String Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.RecuperarVida(20);
        Player.getPlayer().getInventario().RemoverItem(this);
        return "O jogador recuperou 20 de vida";
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().RecuperarVida(20);
        Player.getPlayer().getInventario().RemoverItem(this);
    }
}
