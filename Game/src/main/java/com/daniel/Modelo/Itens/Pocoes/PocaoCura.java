package com.daniel.Modelo.Itens.Pocoes;

import com.daniel.Dados.EntidadesRepositório.Player;
import com.daniel.Modelo.Exceptions.PlayerInexistenteException;
import com.daniel.Modelo.Interfaces.IConsumableInBattle;
import com.daniel.Modelo.Interfaces.IConsumableOutBattle;
import com.daniel.Modelo.Itens.Item;
import com.daniel.Modelo.BatalhaDeTurnos.PersonagemLuta;

public class PocaoCura extends Item implements IConsumableOutBattle, IConsumableInBattle {

    public PocaoCura() {
        super("/com.daniel.Images/Itens/Poções/basic health potion.png", "Poção de cura", 1, 50, "Poção que cura 30 de vida");
    }

    public PocaoCura(int quant) {
        super("/com.daniel.Images/Itens/Poções/basic health potion.png", "Poção de cura", quant, 50, "Poção que cura 30 de vida");

    }

    @Override
    public String Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.RecuperarVida(30);
        Player.getPlayer().getInventario().RemoverItem(this);
        return "O jogador recuperou 30 de vida";
    }
    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().RecuperarVida(30);
        Player.getPlayer().getInventario().RemoverItem(this);
    }
}
