package com.daniel.PrimeiraCamada.Itens.Mapas;

import com.daniel.PrimeiraCamada.Cidades.Dasópoles;
import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Interfaces.IConsumableOutBattle;
import com.daniel.PrimeiraCamada.Itens.Item;

public class MapaDasópoles extends Item implements IConsumableOutBattle {
    public MapaDasópoles() {
        super("/com.daniel.Images/Itens/map_01.png", "Dasópoles", 1, 50, "Mapa para Dasópoles");
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().adicionarCidade(new Dasópoles());
        Player.getPlayer().getInventario().RemoverItem(this);

    }
}
