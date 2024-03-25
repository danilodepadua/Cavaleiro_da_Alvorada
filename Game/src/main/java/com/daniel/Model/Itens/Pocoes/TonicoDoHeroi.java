package com.daniel.Model.Itens.Pocoes;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableInBattle;
import com.daniel.Model.Itens.Item;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;

public class TonicoDoHeroi extends Item implements IConsumableInBattle {
    public TonicoDoHeroi(){
        super("/com.daniel.Images/Itens/Poções/resurrection potion.png", new TextoNode("Tônico do heroi","Heroes force"), 1, 150000, new TextoNode("Poção que concede 5 pontos em todos os atributos durante a batalha","Potion that increases all attributes by 5 during battle"));
    }

    public TonicoDoHeroi(int quant) {
        super("/com.daniel.Images/Itens/Poções/resurrection potion.png", new TextoNode("Tônico do heroi","Heroes force"), quant, 150000, new TextoNode("Poção que concede 5 pontos em todos os atributos durante a batalha","Potion that increases all attributes by 5 during battle"));
    }

    @Override
    public TextoNode Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.UpForca(5);
        p.UpInt(5);
        p.UpRes(5);
        p.UpVel(5);
        p.UpSorte(5);
        Player.getPlayer().getInventario().removerItem(this);
        return new TextoNode("O jogador ganhou mais 5 em todos os atributos","All the player's attributes was increased by 5");
    }
}
