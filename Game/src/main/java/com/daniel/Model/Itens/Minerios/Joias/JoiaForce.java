package com.daniel.Model.Itens.Minerios.Joias;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableOutBattle;
import com.daniel.Model.Itens.Item;

public class JoiaForce extends Item implements IConsumableOutBattle {
    public JoiaForce() {
        super("/com.daniel.Images/Itens/Joias/Fragmentos/style2/gem8-deepred.png", new TextoNode("Joia do poder","Power gem"), 1, 0, new TextoNode("Joia que aumenta o atributo de força em 1", "Gem that increases strength attribute by 1"));
        this.precoVenda = 5;
    }
    public JoiaForce(int quant) {
        super("/com.daniel.Images/Itens/Joias/Fragmentos/style2/gem8-deepred.png", new TextoNode("Joia do poder","Power gem"), quant, 0, new TextoNode("Joia que aumenta o atributo de força em 1", "Gem that increases strength attribute by 1"));
        this.precoVenda = 5;
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().aumentaForcaProgress(Player.getPlayer().getForca()+1);
    }
}
