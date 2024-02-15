package com.daniel.Model.Itens.Pocoes;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableInBattle;
import com.daniel.Model.Itens.Item;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;

public class TonicoDoHeroi extends Item implements IConsumableInBattle {
    public TonicoDoHeroi(){
        super("Poção que concede 5 pontos de força durante a batalha", "Tônico do heroi", 1, 100, "Poção que concede 5 pontos de em todos os atributos durante a batalha");
    }

    public TonicoDoHeroi(int quant) {
        super("Poção que concede 5 pontos de força durante a batalha", "Tônico do heroi", quant, 100, "Poção que concede 5 pontos de em todos os atributos durante a batalha");
    }

    @Override
    public String Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        Player.getPlayer().getInventario().removerItem(this);
        return "Jogador mais 5 em todos os atributos";
    }
}
