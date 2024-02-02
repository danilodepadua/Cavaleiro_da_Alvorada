package com.daniel.Modelo.Itens.Mapas;

import com.daniel.Dados.CidadeRepositório.Cidades.Dasópoles;
import com.daniel.Dados.EntidadesRepositório.Player;
import com.daniel.Modelo.Exceptions.PlayerInexistenteException;
import com.daniel.Modelo.Interfaces.IConsumableOutBattle;
import com.daniel.Modelo.Itens.Item;

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
