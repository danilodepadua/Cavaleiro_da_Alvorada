package com.daniel.Dados;

import com.daniel.Modelo.Itens.Item;

import java.io.Serializable;
import java.util.Objects;

public class Inventario implements Serializable {

    private static final Inventario instance = new Inventario();
    private Item[] itens = new Item[100];

    private Inventario() {
    }

    public static Inventario getInstance() {
        return instance;
    }

    public void adicionarItem(Item item) {
        Integer nullIndex = null;
        if (item != null) {
            for (int i = 0; i < itens.length; i++) {
                if (itens[i] == null && nullIndex == null) {
                    nullIndex = i;
                } else if (itens[i] != null && Objects.equals(itens[i].getNome(), item.getNome())) {
                    itens[i].MaisQuant();
                    nullIndex = null;
                    break;
                }
            }
            if (nullIndex != null) {
                itens[nullIndex] = item;
            }
        }
    }

    public void RemoverItem(Item i) {
        for (int j = 0; j < itens.length; j++) {
            if (itens[j] != null && Objects.equals(itens[j].getNome(), i.getNome())) {
                itens[j].MenosQuant();
                if (itens[j].getQuant() <= 0) {
                    itens[j] = null;
                }
            }
        }
    }

    public Item[] getItens() {
        return itens;
    }
}
