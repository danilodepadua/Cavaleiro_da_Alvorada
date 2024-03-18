package com.daniel.Model.Itens.Pocoes;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableInBattle;
import com.daniel.Model.Itens.Item;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Model.Magias.TiposElementais;

public class Cerveja extends Item implements IConsumableInBattle {
    public Cerveja(){
        super("/com.daniel.Images/Itens/Poções/canecadecerveja.png",new TextoNode("Cerveja", "Bear"), 1, 20, new TextoNode("Bebida que concede 5 pontos de força, 7 de resistência, perde 3 de vida e 6 de velocidade durante a batalha", "Drink that grants 5 strength, 7 stamina, loses 3 health, and 6 speed during battle"));
    }

    public Cerveja(int quant) {
        super("/com.daniel.Images/Itens/Poções/canecadecerveja.png",new TextoNode("Cerveja", "Bear"), quant, 20, new TextoNode("Bebida que concede 5 pontos de força, 7 de resistência, perde 3 de vida e 6 de velocidade durante a batalha", "Drink that grants 5 strength, 7 stamina, loses 3 health, and 6 speed during battle"));
    }

    @Override
    public String Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.UpForca(5);
        p.UpVel(-6);
        p.UpRes(7);
        p.tomarDano(3, TiposElementais.NaoElemental, true);
        Player.getPlayer().getInventario().removerItem(this);
        return "Jogador ganhou mais 5 de força, 7 de resistência, perdeu 3 de vida e 6 de velocidade";
    }
}
