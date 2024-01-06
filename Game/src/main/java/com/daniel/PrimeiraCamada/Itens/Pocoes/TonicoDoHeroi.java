package com.daniel.PrimeiraCamada.Itens.Pocoes;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Interfaces.IConsumableInBattle;
import com.daniel.PrimeiraCamada.Itens.Item;
import com.daniel.PrimeiraCamada.PersonagemLuta;

public class TonicoDoHeroi extends Item implements IConsumableInBattle {
    public TonicoDoHeroi(){
        this.nome = "Tônico do heroi";
        this.imagem = "/com.daniel.Images/Itens/pt4.png";
        this.preço = 100; // Preço inicial
        this.descricao = "Poção que concede 5 pontos de em todos os atributos durante a batalha";
    }
    @Override
    public String Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        Player.getPlayer().getInventario().RemoverItem(this);
        return "Jogador mais 5 em todos os atributos";
    }
}
