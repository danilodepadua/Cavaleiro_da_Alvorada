package com.daniel.Modelo.Itens.Comidas;

import com.daniel.Dados.EntidadesRepositório.Player;
import com.daniel.Modelo.Exceptions.PlayerInexistenteException;
import com.daniel.Modelo.Interfaces.IConsumableInBattle;
import com.daniel.Modelo.Interfaces.IConsumableOutBattle;
import com.daniel.Modelo.Itens.Item;
import com.daniel.Modelo.BatalhaDeTurnos.PersonagemLuta;

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
        Player.getPlayer().getInventario().RemoverItem(this);
        return "O jogador recuperou 25 de vida";
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().RecuperarVida(25);
        Player.getPlayer().getInventario().RemoverItem(this);
    }
}
