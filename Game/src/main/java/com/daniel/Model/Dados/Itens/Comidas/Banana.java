package com.daniel.Model.Dados.Itens.Comidas;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableInBattle;
import com.daniel.Model.Interfaces.IConsumableOutBattle;
import com.daniel.Model.Dados.Itens.Item;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;

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
        Player.getPlayer().getInventario().removerItem(this);
        return "O jogador recuperou 20 de vida";
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().RecuperarVida(20);
        Player.getPlayer().getInventario().removerItem(this);
    }
}
