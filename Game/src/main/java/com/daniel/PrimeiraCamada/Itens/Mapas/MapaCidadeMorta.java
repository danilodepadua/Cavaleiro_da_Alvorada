package com.daniel.PrimeiraCamada.Itens.Mapas;

import com.daniel.PrimeiraCamada.Cidades.CidadeMorta;
import com.daniel.PrimeiraCamada.Cidades.Dasópoles;
import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Interfaces.IConsumableOutBattle;
import com.daniel.PrimeiraCamada.Itens.Item;

public class MapaCidadeMorta extends Item implements IConsumableOutBattle {
    public MapaCidadeMorta() {
        super("/com.daniel.Images/Itens/map_01.png", "Cidade morta", 1, 50, "Mapa para Cidade Morta");
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().adicionarCidade(new CidadeMorta());
        Player.getPlayer().getInventario().RemoverItem(this);

    }
}

