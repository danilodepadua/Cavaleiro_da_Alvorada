package com.daniel.Model.Itens.Pocoes;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableInBattle;
import com.daniel.Model.Itens.Item;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;

public class TonicoDoHeroi extends Item implements IConsumableInBattle {
    public TonicoDoHeroi(){
        super("Poção que concede 5 pontos de força durante a batalha", new TextoNode("Tônico do heroi","Heroes Force"), 1, 100, new TextoNode("Poção que concede 5 pontos de em todos os atributos durante a batalha","Potion that increases all attributes by 5 during battle"));
    }

    public TonicoDoHeroi(int quant) {
        super("Poção que concede 5 pontos de força durante a batalha", new TextoNode("Tônico do heroi","Heroes Force"), quant, 100, new TextoNode("Poção que concede 5 pontos de em todos os atributos durante a batalha","Potion that increases all attributes by 5 during battle"));
    }

    @Override
    public String Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        Player.getPlayer().getInventario().removerItem(this);
        return "Jogador mais 5 em todos os atributos";
    }
}
