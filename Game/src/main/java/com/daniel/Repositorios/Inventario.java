package com.daniel.Repositorios;

import com.daniel.Basicos.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private Item item;
    private List<Item> itens = new ArrayList<>();


    public void adicionarItem(Item item){
        itens.add(item);

    }
    public Item getItem() {
        return item;
    }

    public List<Item> getItens() {
        return itens;
    }
}
