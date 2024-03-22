package com.daniel.Model.Itens.Pocoes;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableInBattle;
import com.daniel.Model.Interfaces.IConsumableOutBattle;
import com.daniel.Model.Itens.Item;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;

public class PocaoCuraGrande extends Item implements IConsumableOutBattle, IConsumableInBattle {

    public PocaoCuraGrande() {
        super("/com.daniel.Images/Itens/Poções/health potion.png", new TextoNode("Poção grande", "Hi-Potion"), 1, 90, new TextoNode("Poção que cura 70 de vida", "Potion that cures 70 of life"));
    }

    public PocaoCuraGrande(int quant) {
        super("/com.daniel.Images/Itens/Poções/health potion.png", new TextoNode("Poção grande", "Hi-Potion"), quant, 90, new TextoNode("Poção que cura 70 de vida", "Potion that cures 70 of life"));

    }

    @Override
    public TextoNode Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.RecuperarVida(70);
        Player.getPlayer().getInventario().removerItem(this);
        return new TextoNode("O jogador recuperou 70 de vida","The player recover 70 of hp");
    }
    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().RecuperarVida(70);
        Player.getPlayer().getInventario().removerItem(this);
    }
}
