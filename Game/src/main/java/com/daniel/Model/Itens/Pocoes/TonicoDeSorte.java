package com.daniel.Model.Itens.Pocoes;

import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableInBattle;
import com.daniel.Model.Itens.Item;

public class TonicoDeSorte extends Item implements IConsumableInBattle {
    public TonicoDeSorte(){
        super("/com.daniel.Images/Itens/Poções/luck potion.png", new TextoNode("Tônico da sorte","Luck tonic"), 1, 50000, new TextoNode("Poção que concede 5 pontos de sorte durante a batalha","Potion that increases luck by 5 during battle"));
    }

    public TonicoDeSorte(int quant) {
        super("/com.daniel.Images/Itens/Poções/luck potion.png", new TextoNode("Tônico da sorte","Luck tonic"), quant, 50000, new TextoNode("Poção que concede 5 pontos de sorte durante a batalha","Potion that increases luck by 5 during battle"));
    }

    @Override
    public TextoNode Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.UpSorte(5);
        Player.getPlayer().getInventario().removerItem(this);
        return new TextoNode("O jogador ganhou mais 5 de sorte","The player's luck was increased by 5");
    }
}
