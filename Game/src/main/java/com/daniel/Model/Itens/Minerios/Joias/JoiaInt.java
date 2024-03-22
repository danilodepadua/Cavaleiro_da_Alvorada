package com.daniel.Model.Itens.Minerios.Joias;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableOutBattle;
import com.daniel.Model.Itens.Item;

public class JoiaInt extends Item implements IConsumableOutBattle {
    public JoiaInt() {
        super("/com.daniel.Images/Itens/Joias/Fragmentos/style2/gem1-diamond.png", new TextoNode("Joia da sabedoria","Wisdom gem"), 1, 0, new TextoNode("Joia que aumenta o atributo de inteligência em 1", "Gem that increases intelligence attribute by 1"));
        this.precoVenda = 5;
    }
    public JoiaInt(int quant) {
        super("/com.daniel.Images/Itens/Joias/Fragmentos/style2/gem1-diamond.png", new TextoNode("Joia da sabedoria","Wisdom gem"), quant, 0, new TextoNode("Joia que aumenta o atributo de inteligência em 1", "Gem that increases intelligence attribute by 1"));
        this.precoVenda = 5;
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().aumentaInteligenciaProgess(Player.getPlayer().getInteligencia()+1);
    }
}
