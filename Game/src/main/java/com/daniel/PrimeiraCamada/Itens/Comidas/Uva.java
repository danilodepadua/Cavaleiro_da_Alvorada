package com.daniel.PrimeiraCamada.Itens.Comidas;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Interfaces.IConsumableInBattle;
import com.daniel.PrimeiraCamada.Interfaces.IConsumableOutBattle;
import com.daniel.PrimeiraCamada.Itens.Item;
import com.daniel.PrimeiraCamada.PersonagemLuta;

public class Uva extends Item implements IConsumableOutBattle, IConsumableInBattle {
    public Uva(){
        this.imagem = "/com.daniel.Images/Itens/Comidas/tile002.png";
        this.nome = "Uva";
        this.descricao = "Recupera 15 de mana";
        this.preço = 7; // Preço inicial
    }
    @Override
    public String Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.RecuperarMana(15);
        Player.getPlayer().getInventario().RemoverItem(this);
        return "O jogador recuperou 15 de mana";
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().RecuperarMana(15);
        Player.getPlayer().getInventario().RemoverItem(this);
    }
}
