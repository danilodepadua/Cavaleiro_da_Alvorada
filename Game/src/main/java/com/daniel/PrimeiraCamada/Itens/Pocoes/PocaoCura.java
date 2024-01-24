package com.daniel.PrimeiraCamada.Itens.Pocoes;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Interfaces.IConsumableInBattle;
import com.daniel.PrimeiraCamada.Interfaces.IConsumableOutBattle;
import com.daniel.PrimeiraCamada.Itens.Item;
import com.daniel.PrimeiraCamada.PersonagemLuta;

public class PocaoCura extends Item implements IConsumableOutBattle, IConsumableInBattle {

    public PocaoCura() {
        super("/com.daniel.Images/Itens/pt1.png", "Poção de cura", 1, 50, "Poção que cura 100 de vida");
    }

    public PocaoCura(int quant) {
        super("/com.daniel.Images/Itens/pt1.png", "Poção de cura", quant, 50, "Poção que cura 100 de vida");

    }

    @Override
    public String Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.RecuperarVida(100);
        Player.getPlayer().getInventario().RemoverItem(this);
        return "O jogador recuperou 100 de vida";
    }
    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().RecuperarVida(100);
        Player.getPlayer().getInventario().RemoverItem(this);
    }
}
