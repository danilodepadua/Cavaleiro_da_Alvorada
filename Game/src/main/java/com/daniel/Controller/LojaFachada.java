package com.daniel.Controller;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Exceptions.*;
import com.daniel.Model.Interfaces.IEquipable;
import com.daniel.Model.Dados.Itens.Item;
import com.daniel.Model.Loja.Loja;

public class LojaFachada {
    private static final LojaFachada instance = new LojaFachada();
    private Loja loja;
    private LojaFachada() {
        loja = new Loja();
    }

    public static LojaFachada getInstance() {
        return instance;
    }

    public void comprarItem( Item item) throws PlayerInexistenteException, RemoverCoinsException, CompraErroException, SemMoedasParaLojaException {
        loja.comprarItem(item);
    }

    public void venderItem(Item item) throws PlayerInexistenteException {
        loja.venderItem(item);
    }


}
