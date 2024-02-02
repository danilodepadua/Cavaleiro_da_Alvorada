package com.daniel.Modelo.Itens.Comidas;

import com.daniel.Dados.EntidadesRepositório.Player;
import com.daniel.Modelo.Exceptions.PlayerInexistenteException;
import com.daniel.Modelo.Interfaces.IConsumableInBattle;
import com.daniel.Modelo.Interfaces.IConsumableOutBattle;
import com.daniel.Modelo.Itens.Item;
import com.daniel.Modelo.BatalhaDeTurnos.PersonagemLuta;

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
        Player.getPlayer().getInventario().RemoverItem(this);
        return "O jogador recuperou 50 de vida";
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().RecuperarVida(50);
        Player.getPlayer().getInventario().RemoverItem(this);
    }
}

