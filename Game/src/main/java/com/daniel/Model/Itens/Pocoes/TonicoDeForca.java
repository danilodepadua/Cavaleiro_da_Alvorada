package com.daniel.Model.Itens.Pocoes;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableInBattle;
import com.daniel.Model.Itens.Item;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;

public class TonicoDeForca extends Item implements IConsumableInBattle {
    public TonicoDeForca(){
        super("/com.daniel.Images/Itens/Poções/strength potion.png",new TextoNode("Tônico de força", "Strength Tonic"), 1, 50000, new TextoNode("Poção que concede 5 pontos de força durante a batalha","Potion that increases the strength by 5 during battle"));
    }

    public TonicoDeForca(int quant) {
        super("/com.daniel.Images/Itens/Poções/strength potion.png",new TextoNode("Tônico de força", "Strength Tonic"), quant, 50000, new TextoNode("Poção que concede 5 pontos de força durante a batalha","Potion that increases the strength by 5 during battle"));
    }

    @Override
    public TextoNode Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.UpForca(5);
        Player.getPlayer().getInventario().removerItem(this);
        return new TextoNode("Jogador ganhou mais 5 de força","The player's strength was increased by 5");
    }
}
