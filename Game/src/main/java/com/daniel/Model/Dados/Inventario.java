package com.daniel.Model.Dados;

import com.daniel.Model.Itens.Item;

import java.io.Serializable;
import java.util.Objects;

public class Inventario implements Serializable {

    private Item[] itens ;

    public Inventario() {
        this.itens = new Item[100];
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

    public void removerItem(Item i) {
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
