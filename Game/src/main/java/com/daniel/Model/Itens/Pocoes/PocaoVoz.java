package com.daniel.Model.Itens.Pocoes;

import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableInBattle;
import com.daniel.Model.Itens.Item;

public class PocaoVoz extends Item implements IConsumableInBattle {
    public PocaoVoz(){
        super("/com.daniel.Images/Itens/Poções/antidote.png", new TextoNode("Poção da fala","Speech potion"), 1, 5000, new TextoNode("Poção para recuperar a habilidade da fala","Potion to regain the ability of speak"));
    }

    public PocaoVoz(int quant) {
        super("/com.daniel.Images/Itens/Poções/antidote.png", new TextoNode("Poção da fala","Speech potion"), quant, 5000, new TextoNode("Poção para recuperar a habilidade da fala","Potion to regain the ability of speak"));
    }

    @Override
    public TextoNode Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.dessilenciar();
        Player.getPlayer().getInventario().removerItem(this);
        return new TextoNode("O jogador voltou a falar","The player can speak again");
    }
}
