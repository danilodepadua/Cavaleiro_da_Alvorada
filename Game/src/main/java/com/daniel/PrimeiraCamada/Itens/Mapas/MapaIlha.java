package com.daniel.PrimeiraCamada.Itens.Mapas;

import com.daniel.PrimeiraCamada.Cidades.CidadePortuaria;
import com.daniel.PrimeiraCamada.Cidades.Ilha;
import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Interfaces.IConsumableOutBattle;
import com.daniel.PrimeiraCamada.Itens.Item;

public class MapaIlha extends Item implements IConsumableOutBattle {
    public MapaIlha() {
        super("/com.daniel.Images/Itens/map_01.png", "Ilha", 1, 150, "Mapa para Ilha");
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().adicionarCidade(new Ilha());
        Player.getPlayer().getInventario().RemoverItem(this);

    }
}
