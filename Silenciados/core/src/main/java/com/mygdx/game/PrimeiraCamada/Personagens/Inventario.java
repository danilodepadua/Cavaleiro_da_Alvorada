package com.mygdx.game.PrimeiraCamada.Personagens;

import com.mygdx.game.PrimeiraCamada.Exceptions.ItemInexistenteException;

import java.util.ArrayList;

public class Inventario {
    ArrayList<Item> itens = new ArrayList<Item>();

    public void adiciorItem(Item i){
        itens.add(i);
    }
    public void removerItem(Item i) throws ItemInexistenteException {
        try{
            itens.remove(i);
        }
        catch(Exception e){
            throw new ItemInexistenteException(i);
        }
    }
}
