package com.daniel.Model.Dados.Itens.Pocoes;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableInBattle;
import com.daniel.Model.Dados.Itens.Item;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;

public class TonicoDeForca extends Item implements IConsumableInBattle {
    public TonicoDeForca(){
        super("/com.daniel.Images/Itens/Poções/strength potion.png","Tônico de força", 1, 100, "Poção que concede 5 pontos de força durante a batalha");
    }

    public TonicoDeForca(int quant) {
        super("/com.daniel.Images/Itens/Poções/strength potion.png","Tônico de força", quant, 100, "Poção que concede 5 pontos de força durante a batalha");
    }

    @Override
    public String Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.UpForca(5);
        Player.getPlayer().getInventario().removerItem(this);
        return "Jogador ganhou mais 5 de força";
    }
}
