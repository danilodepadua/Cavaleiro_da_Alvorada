package com.daniel.PrimeiraCamada.Itens.Pocoes;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Interfaces.IConsumableInBattle;
import com.daniel.PrimeiraCamada.Interfaces.IConsumableOutBattle;
import com.daniel.PrimeiraCamada.Itens.Item;
import com.daniel.PrimeiraCamada.PersonagemLuta;

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
