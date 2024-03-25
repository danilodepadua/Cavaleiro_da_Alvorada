package com.daniel.Model.Itens.Pocoes;

import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableInBattle;
import com.daniel.Model.Itens.Item;

public class Antidoto extends Item implements IConsumableInBattle {
    public Antidoto(){
        super("/com.daniel.Images/Itens/Poções/poison potion.png", new TextoNode("Antídoto","Antidote"), 1, 5000, new TextoNode("Poção que tira efeito de veneno","Potion that removes poison effect"));
    }

    public Antidoto(int quant) {
        super("/com.daniel.Images/Itens/Poções/poison potion.png", new TextoNode("Antídoto","Antidote"), quant, 5000, new TextoNode("Poção que tira efeito de veneno","Potion that removes poison effect"));
    }

    @Override
    public TextoNode Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.Desenvenenar();
        Player.getPlayer().getInventario().removerItem(this);
        return new TextoNode("O jogador foi desenvenenado","The player was unpoisoned");
    }
}
