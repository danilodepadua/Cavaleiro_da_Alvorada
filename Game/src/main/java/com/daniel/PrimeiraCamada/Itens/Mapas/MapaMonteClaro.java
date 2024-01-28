package com.daniel.PrimeiraCamada.Itens.Mapas;

import com.daniel.PrimeiraCamada.Cidades.Dasópoles;
import com.daniel.PrimeiraCamada.Cidades.MonteClaro;
import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Interfaces.IConsumableOutBattle;
import com.daniel.PrimeiraCamada.Itens.Item;

public class MapaMonteClaro extends Item implements IConsumableOutBattle {
    public MapaMonteClaro() {
        super("/com.daniel.Images/Itens/map_01.png", "Monte Claro", 1, 70, "Mapa para Monte Claro");
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().adicionarCidade(new MonteClaro());
        Player.getPlayer().getInventario().RemoverItem(this);

    }
}
