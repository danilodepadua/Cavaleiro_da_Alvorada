package com.daniel.Model.Dados.Itens.Pocoes;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableInBattle;
import com.daniel.Model.Interfaces.IConsumableOutBattle;
import com.daniel.Model.Dados.Itens.Item;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;

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
        Player.getPlayer().getInventario().removerItem(this);
        return "O jogador recuperou 70 de vida";
    }
    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().RecuperarVida(70);
        Player.getPlayer().getInventario().removerItem(this);
    }
}
