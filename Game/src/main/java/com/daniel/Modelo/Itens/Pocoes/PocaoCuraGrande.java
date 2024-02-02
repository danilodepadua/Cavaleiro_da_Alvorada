package com.daniel.Modelo.Itens.Pocoes;

import com.daniel.Dados.EntidadesRepositório.Player;
import com.daniel.Modelo.Exceptions.PlayerInexistenteException;
import com.daniel.Modelo.Interfaces.IConsumableInBattle;
import com.daniel.Modelo.Interfaces.IConsumableOutBattle;
import com.daniel.Modelo.Itens.Item;
import com.daniel.Modelo.BatalhaDeTurnos.PersonagemLuta;

public class PocaoCuraGrande extends Item implements IConsumableOutBattle, IConsumableInBattle {

    public PocaoCuraGrande() {
        super("/com.daniel.Images/Itens/Poções/health potion.png", "Poção de cura grande", 1, 90, "Poção que cura 70 de vida");
    }

    public PocaoCuraGrande(int quant) {
        super("/com.daniel.Images/Itens/Poções/health potion.png", "Poção de cura grande", quant, 90, "Poção que cura 70 de vida");

    }

    @Override
    public String Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.RecuperarVida(70);
        Player.getPlayer().getInventario().RemoverItem(this);
        return "O jogador recuperou 70 de vida";
    }
    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().RecuperarVida(70);
        Player.getPlayer().getInventario().RemoverItem(this);
    }
}
