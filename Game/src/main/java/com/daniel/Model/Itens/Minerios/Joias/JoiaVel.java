package com.daniel.Model.Itens.Minerios.Joias;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableOutBattle;
import com.daniel.Model.Itens.Item;

public class JoiaVel  extends Item implements IConsumableOutBattle {
    public JoiaVel() {
        super("/com.daniel.Images/Itens/Joias/Fragmentos/style2/gem2-darkyellow.png", new TextoNode("Joia do tempo","Time gem"), 1, 0, new TextoNode("Joia que aumenta o atributo de velocidade em 1", "Gem that increases speed attribute by 1"));
        this.precoVenda = 5;
    }
    public JoiaVel(int quant) {
        super("/com.daniel.Images/Itens/Joias/Fragmentos/style2/gem2-darkyellow.png", new TextoNode("Joia do tempo","Time gem"), quant, 0, new TextoNode("Joia que aumenta o atributo de velocidade em 1", "Gem that increases speed attribute by 1"));
        this.precoVenda = 5;
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().aumentaVelocidadeProgress(Player.getPlayer().getVelocidade()+1);
    }
}
