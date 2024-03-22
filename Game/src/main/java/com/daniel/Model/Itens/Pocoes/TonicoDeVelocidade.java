package com.daniel.Model.Itens.Pocoes;

import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableInBattle;
import com.daniel.Model.Itens.Item;

public class TonicoDeVelocidade extends Item implements IConsumableInBattle {
    public TonicoDeVelocidade(){
        super("/com.daniel.Images/Itens/Poções/agility potion.png", new TextoNode("Tônico de volocidade","Speed tonic"), 1, 100, new TextoNode("Poção que concede 5 pontos de velocidade durante a batalha","Potion that increases speed by 5 during battle"));
    }

    public TonicoDeVelocidade(int quant) {
        super("/com.daniel.Images/Itens/Poções/agility potion.png", new TextoNode("Tônico de volocidade","Speed tonic"), quant, 100, new TextoNode("Poção que concede 5 pontos de velocidade durante a batalha","Potion that increases speed by 5 during battle"));
    }

    @Override
    public TextoNode Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.UpVel(5);
        Player.getPlayer().getInventario().removerItem(this);
        return new TextoNode("O jogador ganhou mais 5 de velocidade","The player's speed was increased by 5");
    }
}
