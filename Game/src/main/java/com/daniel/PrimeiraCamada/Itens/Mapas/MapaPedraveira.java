package com.daniel.PrimeiraCamada.Itens.Mapas;

import com.daniel.PrimeiraCamada.Cidades.BatalhaDePedraveira;
import com.daniel.PrimeiraCamada.Cidades.MonteClaro;
import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Interfaces.IConsumableOutBattle;
import com.daniel.PrimeiraCamada.Itens.Item;

public class MapaPedraveira extends Item implements IConsumableOutBattle {
    public MapaPedraveira() {
        super("/com.daniel.Images/Itens/map_01.png", "Pedraveira", 1, 200, "Mapa para Cidade de Pedraveira");
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().adicionarCidade(new BatalhaDePedraveira());
        Player.getPlayer().getInventario().RemoverItem(this);

    }
}
