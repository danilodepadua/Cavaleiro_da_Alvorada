package com.daniel.Model.Dados.Itens.Comidas;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableInBattle;
import com.daniel.Model.Interfaces.IConsumableOutBattle;
import com.daniel.Model.Dados.Itens.Item;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;

public class Soupa extends Item implements IConsumableOutBattle, IConsumableInBattle {
    public Soupa() {
        super("/com.daniel.Images/Itens/Comidas/Soupa.png", "Soupa", 1, 30, "Recupera 50 de vida");
    }

    public Soupa(int quant) {
        super("/com.daniel.Images/Itens/Comidas/Soupa.png", "Soupa", quant, 30, "Recupera 50 de vida");
    }
    @Override
    public String Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.RecuperarVida(50);
        Player.getPlayer().getInventario().removerItem(this);
        return "O jogador recuperou 50 de vida";
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().RecuperarVida(50);
        Player.getPlayer().getInventario().removerItem(this);
    }
}

