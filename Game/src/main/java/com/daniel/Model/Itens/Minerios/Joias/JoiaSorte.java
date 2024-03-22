package com.daniel.Model.Itens.Minerios.Joias;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableOutBattle;
import com.daniel.Model.Itens.Item;

public class JoiaSorte extends Item implements IConsumableOutBattle {
    public JoiaSorte() {
        super("/com.daniel.Images/Itens/Joias/Fragmentos/style2/gem7-teal.png", new TextoNode("Joia da sorte","Luck gem"), 1, 0, new TextoNode("Joia que aumenta o atributo de sorte em 1", "Gem that increases luck attribute by 1"));
        this.precoVenda = 5;
    }
    public JoiaSorte(int quant) {
        super("/com.daniel.Images/Itens/Joias/Fragmentos/style2/gem7-teal.png", new TextoNode("Joia da sorte","Luck gem"), quant, 0, new TextoNode("Joia que aumenta o atributo de sorte em 1", "Gem that increases luck attribute by 1"));
        this.precoVenda = 5;
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().aumentaSorteProgress(Player.getPlayer().getSorte()+1);
    }
}
