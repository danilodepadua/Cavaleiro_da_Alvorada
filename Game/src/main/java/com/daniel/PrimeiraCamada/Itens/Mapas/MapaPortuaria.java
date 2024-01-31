package com.daniel.PrimeiraCamada.Itens.Mapas;

import com.daniel.PrimeiraCamada.Cidades.CidadePortuaria;
import com.daniel.PrimeiraCamada.Cidades.MonteClaro;
import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Interfaces.IConsumableOutBattle;
import com.daniel.PrimeiraCamada.Itens.Item;

public class MapaPortuaria extends Item implements IConsumableOutBattle {
    public MapaPortuaria() {
        super("/com.daniel.Images/Itens/map_01.png", "Cidade portuária", 1, 150, "Mapa para Cidade Portuária");
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().adicionarCidade(new CidadePortuaria());
        Player.getPlayer().getInventario().RemoverItem(this);

    }
}
