package com.daniel.Controller;

import com.daniel.Model.Dados.CassinoRepositorio.Mão;
import com.daniel.Model.Exceptions.*;
import com.daniel.Model.Dados.Itens.Item;

public class JogoFachada {
    private static final JogoFachada instance = new JogoFachada();
    private ControleLoja controleLoja;
    private ControleCraft controleCraft;
    private ControlePoker controlePoker;
    private ControleServidor controleServidor;

    private JogoFachada() {
        controleLoja = new ControleLoja();
        controleCraft = new ControleCraft();
        controlePoker = new ControlePoker();
        controleServidor = new ControleServidor();
    }

    public static JogoFachada getInstance() {
        return instance;
    }

    public void comprarItem(Item item) throws PlayerInexistenteException, RemoverCoinsException, CompraErroException, SemMoedasParaLojaException {
        controleLoja.comprarItem(item);
    }

    public void venderItem(Item item) throws PlayerInexistenteException {
        controleLoja.venderItem(item);
    }

    public Item criarBarraFerro(Item item, Item item2, double chance) {
        return controleCraft.criarBarraFerro(item, item2, chance);
    }

    public Item criarPocaoVidaGrande(Item item, Item item2, double chance) {
        return controleCraft.criarPocaoVidaGrande(item, item2, chance);
    }

    public Item criarPocaoManaGrande(Item item, Item item2, double chance) {
        return controleCraft.criarPocaoManaGrande(item, item2, chance);
    }

    public Item criarBarraEscuridao(Item item, Item item2, double chance) {
        return controleCraft.criarBarraEscuridao(item, item2, chance);
    }

    public Item criarBarraOuro(Item item, Item item2, double chance) {
        return controleCraft.criarBarraOuro(item, item2, chance);
    }

    public Item criarBarraFogo(Item item, Item item2, double chance) {
        return controleCraft.criarBarraFogo(item, item2, chance);
    }

    public Item criarBarraGelo(Item item, Item item2, double chance) {
        return controleCraft.criarBarraGelo(item, item2, chance);
    }

    public Item criarFerroAperfeicoado(Item item, Item item2, double chance) {
        return controleCraft.criarFerroAperfeicoado(item, item2, chance);
    }

    public Item criarEspadaAperfeicoada(Item item, Item item2, double chance) {
        return controleCraft.criarEspadaAperfeicoada(item, item2, chance);
    }

    public Item criarEspadaGeloAperfeicoada(Item item, Item item2, double chance) {
        return controleCraft.criarEspadaGeloAperfeicoada(item, item2, chance);
    }

    public Item criarEspadaEscuridaoAperfeicoada(Item item, Item item2, double chance) {
        return controleCraft.criarEspadaEscuridaoAperfeicoada(item, item2, chance);
    }

    public Item criarEspadaFogoAperfeicoada(Item item, Item item2, double chance) {
        return controleCraft.criarEspadaFogoAperfeicoada(item, item2, chance);
    }

    public Item criarEspadaEletricaAperfeicoada(Item item, Item item2, double chance) {
        return controleCraft.criarEspadaEletricaAperfeicoada(item, item2, chance);
    }

    public double getChanceBase() {
        return controleCraft.getChanceBase();
    }
    public  String avaliarMao(Mão mao, Mão centro){
        return controlePoker.avaliarMao(mao, centro);
    }

    public  int avaliarForcaMao(Mão mao, Mão centro) {
        return controlePoker.avaliarForcaMao(mao, centro);
    }

    public void ligarServidor(){
        controleServidor.ligarServidor();
    }
    public void desligarServidor(){
        controleServidor.desligarServidor();
    }
}
