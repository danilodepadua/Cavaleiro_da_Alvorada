package com.daniel.Controller;

import com.daniel.Model.Poker;
import com.daniel.Model.Dados.CassinoRepositorio.Mão;
import com.daniel.Model.Exceptions.*;
import com.daniel.Model.Dados.Itens.Item;

public class JogoFachada {
    private static final JogoFachada instance = new JogoFachada();
    private Loja loja;
    private Crafting crafting;
    private Poker poker;

    private JogoFachada() {
        loja = new Loja();
        crafting = new Crafting();
        poker = new Poker();
    }

    public static JogoFachada getInstance() {
        return instance;
    }

    public void comprarItem(Item item) throws PlayerInexistenteException, RemoverCoinsException, CompraErroException, SemMoedasParaLojaException {
        loja.comprarItem(item);
    }

    public void venderItem(Item item) throws PlayerInexistenteException {
        loja.venderItem(item);
    }

    public Item criarBarraFerro(Item item, Item item2, double chance) {
        return crafting.criarBarraFerro(item, item2, chance);
    }

    public Item criarPocaoVidaGrande(Item item, Item item2, double chance) {
        return crafting.criarPocaoVidaGrande(item, item2, chance);
    }

    public Item criarPocaoManaGrande(Item item, Item item2, double chance) {
        return crafting.criarPocaoManaGrande(item, item2, chance);
    }

    public Item criarBarraEscuridao(Item item, Item item2, double chance) {
        return crafting.criarBarraEscuridao(item, item2, chance);
    }

    public Item criarBarraOuro(Item item, Item item2, double chance) {
        return crafting.criarBarraOuro(item, item2, chance);
    }

    public Item criarBarraFogo(Item item, Item item2, double chance) {
        return crafting.criarBarraFogo(item, item2, chance);
    }

    public Item criarBarraGelo(Item item, Item item2, double chance) {
        return crafting.criarBarraGelo(item, item2, chance);
    }

    public Item criarFerroAperfeicoado(Item item, Item item2, double chance) {
        return crafting.criarFerroAperfeicoado(item, item2, chance);
    }

    public Item criarEspadaAperfeicoada(Item item, Item item2, double chance) {
        return crafting.criarEspadaAperfeicoada(item, item2, chance);
    }

    public Item criarEspadaGeloAperfeicoada(Item item, Item item2, double chance) {
        return crafting.criarEspadaGeloAperfeicoada(item, item2, chance);
    }

    public Item criarEspadaEscuridaoAperfeicoada(Item item, Item item2, double chance) {
        return crafting.criarEspadaEscuridaoAperfeicoada(item, item2, chance);
    }

    public Item criarEspadaFogoAperfeicoada(Item item, Item item2, double chance) {
        return crafting.criarEspadaFogoAperfeicoada(item, item2, chance);
    }

    public Item criarEspadaEletricaAperfeicoada(Item item, Item item2, double chance) {
        return crafting.criarEspadaEletricaAperfeicoada(item, item2, chance);
    }

    public double getChanceBase() {
        return crafting.getChanceBase();
    }
    public  String avaliarMao(Mão mao, Mão centro){
        return poker.avaliarMao(mao, centro);
    }

    public  int avaliarForcaMao(Mão mao, Mão centro) {
        return poker.avaliarForcaMao(mao, centro);
    }

}
