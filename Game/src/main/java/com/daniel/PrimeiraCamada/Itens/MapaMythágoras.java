package com.daniel.PrimeiraCamada.Itens;

import com.daniel.PrimeiraCamada.Cidades.Mythágoras;
import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Interfaces.IConsumableOutBattle;

public class MapaMythágoras extends Item implements IConsumableOutBattle {
    public MapaMythágoras() {
        super("/com.daniel.Images/Itens/map_01.png", "Mythágoras", 1, 50, "Mapa para Mythágoras");
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().adicionarCidade(new Mythágoras());
        Player.getPlayer().getInventario().RemoverItem(this);

    }
}
