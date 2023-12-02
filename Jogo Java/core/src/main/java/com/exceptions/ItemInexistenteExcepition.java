package com.exceptions;

import com.mygdx.dados.item;

public class ItemInexistenteExcepition extends Exception {
    public ItemInexistenteExcepition(item i){
        super("Não possui item: " + i.getNome());
    }
}
