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
        super("/com.daniel.Images/Itens/Poções/basic health potion.png", new TextoNode("Poção","Potion"), 1, 500, new TextoNode("Poção que cura 500 de vida", "Potion that cures 500 of hp"));
    }

    public PocaoCura(int quant) {
        super("/com.daniel.Images/Itens/Poções/basic health potion.png", new TextoNode("Poção","Potion"), quant, 500, new TextoNode("Poção que cura 500 de vida", "Potion that cures 500 of hp"));

    }

    @Override
    public TextoNode Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.RecuperarVida(500);
        Player.getPlayer().getInventario().removerItem(this);
        return new TextoNode("O jogador recuperou 500 de vida","The player recover 500 of hp");
    }
    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().RecuperarVida(500);
        Player.getPlayer().getInventario().removerItem(this);
    }
}
