package com.daniel.PrimeiraCamada.Itens.Pocoes;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Interfaces.IConsumableInBattle;
import com.daniel.PrimeiraCamada.Itens.Item;
import com.daniel.PrimeiraCamada.PersonagemLuta;

public class TonicoDoHeroi extends Item implements IConsumableInBattle {
    public TonicoDoHeroi(){
        super("Poção que concede 5 pontos de força durante a batalha", "Tônico do heroi", 1, 100, "Poção que concede 5 pontos de em todos os atributos durante a batalha");
    }

    public TonicoDoHeroi(int quant) {
        super("Poção que concede 5 pontos de força durante a batalha", "Tônico do heroi", quant, 100, "Poção que concede 5 pontos de em todos os atributos durante a batalha");
    }

    @Override
    public String Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        Player.getPlayer().getInventario().RemoverItem(this);
        return "Jogador mais 5 em todos os atributos";
    }
}
