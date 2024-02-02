package com.daniel.Model.Dados.Itens.Comidas;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableInBattle;
import com.daniel.Model.Interfaces.IConsumableOutBattle;
import com.daniel.Model.Dados.Itens.Item;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;

public class Pao extends Item implements IConsumableOutBattle, IConsumableInBattle {
    public Pao() {
        super("/com.daniel.Images/Itens/Comidas/pao.png", "Pão", 1, 12, "Recupera 25 de vida");
    }

    public Pao(int quant) {
        super("/com.daniel.Images/Itens/Comidas/pao.png", "Pão", quant, 12, "Recupera 25 de vida");
    }
    @Override
    public String Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.RecuperarVida(25);
        Player.getPlayer().getInventario().removerItem(this);
        return "O jogador recuperou 25 de vida";
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().RecuperarVida(25);
        Player.getPlayer().getInventario().removerItem(this);
    }
}
