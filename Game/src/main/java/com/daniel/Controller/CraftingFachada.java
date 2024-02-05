package com.daniel.Controller;

import com.daniel.Model.Crafting;
import com.daniel.Model.Dados.Itens.Item;

public class CraftingFachada {
    private static CraftingFachada instance;
    private Crafting crafting;

    private CraftingFachada() {
        crafting= new Crafting();
    }

    public static CraftingFachada getInstance() {
        if (instance == null) {
            instance = new CraftingFachada();
        }
        return instance;
    }
    public Item criarBarraFerro(Item item, Item item2, double chance) {
        return crafting.criarBarraFerro(item, item2, chance);
    }

    public  Item criarPocaoVidaGrande(Item item, Item item2, double chance) {
        return crafting.criarPocaoVidaGrande(item, item2, chance);
    }
    public  Item criarPocaoManaGrande(Item item, Item item2, double chance) {
        return crafting.criarPocaoManaGrande(item, item2, chance);
    }
    public  Item criarBarraEscuridao(Item item, Item item2, double chance) {
        return crafting.criarBarraEscuridao(item, item2, chance);
    }
    public  Item criarBarraOuro(Item item, Item item2, double chance) {
        return crafting.criarBarraOuro(item, item2, chance);
    }
    public  Item criarBarraFogo(Item item, Item item2, double chance) {
        return crafting.criarBarraFogo(item, item2, chance);
    }
    public  Item criarBarraGelo(Item item, Item item2, double chance) {
        return crafting.criarBarraGelo(item, item2, chance);
    }
    public  Item criarFerroAperfeicoado(Item item, Item item2, double chance) {
        return crafting.criarFerroAperfeicoado(item, item2, chance);
    }
    public  Item criarEspadaAperfeicoada(Item item, Item item2, double chance) {
        return crafting.criarEspadaAperfeicoada(item, item2, chance);
    }

    public  Item criarEspadaGeloAperfeicoada(Item item, Item item2, double chance) {
        return crafting.criarEspadaGeloAperfeicoada(item, item2, chance);
    }
    public  Item criarEspadaEscuridaoAperfeicoada(Item item, Item item2, double chance) {
        return crafting.criarEspadaEscuridaoAperfeicoada(item, item2, chance);
    }
    public  Item criarEspadaFogoAperfeicoada(Item item, Item item2, double chance) {
        return crafting.criarEspadaFogoAperfeicoada(item, item2, chance);
    }
    public  Item criarEspadaEletricaAperfeicoada(Item item, Item item2,double chance) {
        return crafting.criarEspadaEletricaAperfeicoada(item, item2, chance);
    }

    public double getChanceBase() {
        return crafting.getChanceBase();
    }

}
