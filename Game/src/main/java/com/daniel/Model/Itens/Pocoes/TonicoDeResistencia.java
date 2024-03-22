package com.daniel.Model.Itens.Pocoes;

import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableInBattle;
import com.daniel.Model.Itens.Item;

public class TonicoDeResistencia extends Item implements IConsumableInBattle {
    public TonicoDeResistencia(){
        super("/com.daniel.Images/Itens/Poções/defense potion.png", new TextoNode("Tônico da resiliência","Resilience tonic"), 1, 100, new TextoNode("Poção que concede 5 pontos de resistência durante a batalha","Potion that increases resistance by 5 during battle"));
    }

    public TonicoDeResistencia(int quant) {
        super("/com.daniel.Images/Itens/Poções/defense potion.png", new TextoNode("Tônico da resiliência","Resilience tonic"), quant, 100, new TextoNode("Poção que concede 5 pontos de resistência durante a batalha","Potion that increases resistance by 5 during battle"));
    }

    @Override
    public TextoNode Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.UpRes(5);
        Player.getPlayer().getInventario().removerItem(this);
        return new TextoNode("O jogador ganhou mais 5 de resistência","The player's resistance was increased by 5");
    }
}
