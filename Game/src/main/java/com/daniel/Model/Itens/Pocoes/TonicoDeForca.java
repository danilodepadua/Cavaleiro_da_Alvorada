package com.daniel.Model.Itens.Pocoes;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableInBattle;
import com.daniel.Model.Itens.Item;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;

public class TonicoDeForca extends Item implements IConsumableInBattle {
    public TonicoDeForca(){
        super("/com.daniel.Images/Itens/Poções/strength potion.png",new TextoNode("Tônico de força", "Force Tonic"), 1, 100, new TextoNode("Poção que concede 5 pontos de força durante a batalha","Potionthat increases the force by 5 during battle"));
    }

    public TonicoDeForca(int quant) {
        super("/com.daniel.Images/Itens/Poções/strength potion.png",new TextoNode("Tônico de força", "Force Tonic"), quant, 100, new TextoNode("Poção que concede 5 pontos de força durante a batalha","Potionthat increases the force by 5 during battle"));
    }

    @Override
    public String Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.UpForca(5);
        Player.getPlayer().getInventario().removerItem(this);
        return "Jogador ganhou mais 5 de força";
    }
}
