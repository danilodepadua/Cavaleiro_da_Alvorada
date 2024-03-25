package com.daniel.Model.Itens.Pocoes;

import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableInBattle;
import com.daniel.Model.Itens.Item;

public class Remedio extends Item implements IConsumableInBattle {
    public Remedio(){
        super("/com.daniel.Images/Itens/Poções/regeneration potion.png", new TextoNode("Remédio","Remedy"), 1, 15000, new TextoNode("Poção que tira efeitos negativos","Potion that removes negative effects"));
    }

    public Remedio(int quant) {
        super("/com.daniel.Images/Itens/Poções/regeneration potion.png", new TextoNode("Remédio","Remedy"), quant, 15000, new TextoNode("Poção que tira efeitos negativos","Potion that removes negative effects"));
    }

    @Override
    public TextoNode Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.descegar();
        p.dessilenciar();
        p.Desenvenenar();
        Player.getPlayer().getInventario().removerItem(this);
        return new TextoNode("O jogador recuperou a saúde","The player's health returned to normal");
    }
}
