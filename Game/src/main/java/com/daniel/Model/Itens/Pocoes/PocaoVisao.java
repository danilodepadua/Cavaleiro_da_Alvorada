package com.daniel.Model.Itens.Pocoes;

import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableInBattle;
import com.daniel.Model.Itens.Item;

public class PocaoVisao extends Item implements IConsumableInBattle {
    public PocaoVisao(){
        super("/com.daniel.Images/Itens/Poções/will potion.png",new TextoNode("Poção da visão", "Vision potion"), 1, 100, new TextoNode("Poção que cura cegueira","Potion that cure blindness"));
    }

    public PocaoVisao(int quant) {
        super("/com.daniel.Images/Itens/Poções/will potion.png",new TextoNode("Poção da visão", "Vision potion"), quant, 100, new TextoNode("Poção que cura cegueira","Potion that cure blindness"));
    }

    @Override
    public TextoNode Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.descegar();
        Player.getPlayer().getInventario().removerItem(this);
        return new TextoNode("Jogador recuperou a visão","The player recuperated the vision");
    }
}
