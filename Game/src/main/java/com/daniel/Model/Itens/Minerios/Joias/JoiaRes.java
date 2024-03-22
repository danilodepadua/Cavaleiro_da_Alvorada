package com.daniel.Model.Itens.Minerios.Joias;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableOutBattle;
import com.daniel.Model.Itens.Item;

public class JoiaRes extends Item implements IConsumableOutBattle {
    public JoiaRes() {
        super("/com.daniel.Images/Itens/Joias/Fragmentos/style2/gem3-orange.png", new TextoNode("Joia da resiliência","Resilience gem"), 1, 0, new TextoNode("Joia que aumenta o atributo de resistência em 1", "Gem that increases resistence attribute by 1"));
        this.precoVenda = 5;
    }
    public JoiaRes(int quant) {
        super("/com.daniel.Images/Itens/Joias/Fragmentos/style2/gem3-orange.png", new TextoNode("Joia da resiliência","Resilience gem"), quant, 0, new TextoNode("Joia que aumenta o atributo de resistência em 1", "Gem that increases resistence attribute by 1"));
        this.precoVenda = 5;
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().aumentaResistenciaProgress(Player.getPlayer().getResistencia()+1);
    }
}
