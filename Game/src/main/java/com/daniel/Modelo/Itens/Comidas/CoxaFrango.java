package com.daniel.Modelo.Itens.Comidas;

import com.daniel.Dados.EntidadesRepositório.Player;
import com.daniel.Modelo.Exceptions.PlayerInexistenteException;
import com.daniel.Modelo.Interfaces.IConsumableInBattle;
import com.daniel.Modelo.Interfaces.IConsumableOutBattle;
import com.daniel.Modelo.Itens.Item;
import com.daniel.Modelo.BatalhaDeTurnos.PersonagemLuta;

public class CoxaFrango extends Item implements IConsumableOutBattle, IConsumableInBattle {
    public CoxaFrango() {
        super("/com.daniel.Images/Itens/Comidas/tile017.png", "Coxa de frango", 1, 7, "Recupera 40 de vida");
    }

    public CoxaFrango(int quant) {
        super("/com.daniel.Images/Itens/Comidas/tile017.png", "Coxa de frango", quant, 7, "Recupera 40 de vida");
    }
    @Override
    public String Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.RecuperarVida(40);
        Player.getPlayer().getInventario().RemoverItem(this);
        return "O jogador recuperou 40 de vida";
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().RecuperarVida(40);
        Player.getPlayer().getInventario().RemoverItem(this);
    }
}
