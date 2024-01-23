package com.daniel.PrimeiraCamada.Itens.Comidas;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Interfaces.IConsumableInBattle;
import com.daniel.PrimeiraCamada.Interfaces.IConsumableOutBattle;
import com.daniel.PrimeiraCamada.Itens.Item;
import com.daniel.PrimeiraCamada.PersonagemLuta;

public class CoxaFrango extends Item implements IConsumableOutBattle, IConsumableInBattle {
    public CoxaFrango(){
        this.imagem = "/com.daniel.Images/Itens/Comidas/tile017.png";
        this.nome = "Coxa de frango";
        this.descricao = "Recupera 40 de vida";
        this.preço = 7; // Preço inicial
    }
    @Override
    public String Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.RecuperarVida(40);
        Player.getPlayer().getInventario().RemoverItem(this);
        return "O jogador recuperou 40 de vida";
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().RecuperarVida(40);
        Player.getPlayer().getInventario().RemoverItem(this);
    }
}
