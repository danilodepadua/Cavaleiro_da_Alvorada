package com.mygdx.dados;

import com.exceptions.ItemInexistenteExcepition;

import java.util.ArrayList;

public class inventario {
    ArrayList<item> itens = new ArrayList<item>();

    public void adiciorItem(item i){
        itens.add(i);
    }
    public void removerItem(item i) throws ItemInexistenteExcepition {
        try{
            itens.remove(i);
        }
        catch(Exception e){
            ItemInexistenteExcepition E = new ItemInexistenteExcepition(i);
            System.out.println(E.getMessage());
        }
    }
}
