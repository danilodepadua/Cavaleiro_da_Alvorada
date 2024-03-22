package com.daniel.Model.Itens.Pocoes;

import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableInBattle;
import com.daniel.Model.Itens.Item;

public class TonicoDeInteligencia extends Item implements IConsumableInBattle {
    public TonicoDeInteligencia(){
        super("/com.daniel.Images/Itens/Poções/magic potion.png", new TextoNode("Tônico da sabedoria","Wisdom tonic"), 1, 100, new TextoNode("Poção que concede 5 pontos de inteligência durante a batalha","Potion that increases intelligence by 5 during battle"));
    }

    public TonicoDeInteligencia(int quant) {
        super("/com.daniel.Images/Itens/Poções/magic potion.png", new TextoNode("Tônico da sabedoria","Wisdom tonic"), quant, 100, new TextoNode("Poção que concede 5 pontos de inteligência durante a batalha","Potion that increases intelligence by 5 during battle"));
    }

    @Override
    public TextoNode Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.UpInt(5);
        Player.getPlayer().getInventario().removerItem(this);
        return new TextoNode("O jogador ganhou mais 5 de inteligência","The player's intelligence was increased by 5");
    }
}
