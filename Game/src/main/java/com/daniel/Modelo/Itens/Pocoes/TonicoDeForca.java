package com.daniel.Modelo.Itens.Pocoes;

import com.daniel.Dados.EntidadesRepositório.Player;
import com.daniel.Modelo.Exceptions.PlayerInexistenteException;
import com.daniel.Modelo.Interfaces.IConsumableInBattle;
import com.daniel.Modelo.Itens.Item;
import com.daniel.Modelo.BatalhaDeTurnos.PersonagemLuta;

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
        Player.getPlayer().getInventario().RemoverItem(this);
        return "Jogador ganhou mais 5 de força";
    }
}
