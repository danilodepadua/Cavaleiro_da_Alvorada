package com.daniel.Model.Itens.Comidas;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableInBattle;
import com.daniel.Model.Interfaces.IConsumableOutBattle;
import com.daniel.Model.Itens.Item;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;

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
        Player.getPlayer().getInventario().removerItem(this);
        return "O jogador recuperou 40 de vida";
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().RecuperarVida(40);
        Player.getPlayer().getInventario().removerItem(this);
    }
}
