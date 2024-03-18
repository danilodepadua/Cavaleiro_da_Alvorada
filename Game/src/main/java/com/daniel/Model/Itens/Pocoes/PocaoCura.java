package com.daniel.Model.Itens.Pocoes;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableInBattle;
import com.daniel.Model.Interfaces.IConsumableOutBattle;
import com.daniel.Model.Itens.Item;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;

public class PocaoCura extends Item implements IConsumableOutBattle, IConsumableInBattle {

    public PocaoCura() {
        super("/com.daniel.Images/Itens/Poções/basic health potion.png", new TextoNode("Poção","Potion"), 1, 50, new TextoNode("Poção que cura 30 de vida", "Potion that cures 30 of life"));
    }

    public PocaoCura(int quant) {
        super("/com.daniel.Images/Itens/Poções/basic health potion.png", new TextoNode("Poção","Potion"), quant, 50, new TextoNode("Poção que cura 30 de vida", "Potion that cures 30 of life"));

    }

    @Override
    public String Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.RecuperarVida(30);
        Player.getPlayer().getInventario().removerItem(this);
        return "O jogador recuperou 30 de vida";
    }
    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().RecuperarVida(30);
        Player.getPlayer().getInventario().removerItem(this);
    }
}
