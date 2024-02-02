package com.daniel.Model.Itens.Mapas;

import com.daniel.Model.Dados.CidadeRepositorio.Cidades.Dasópoles;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableOutBattle;
import com.daniel.Model.Itens.Item;

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
