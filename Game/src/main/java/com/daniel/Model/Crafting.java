package com.daniel.Model;

import com.daniel.Model.Dados.Itens.Armas.*;
import com.daniel.Model.Dados.Itens.Item;
import com.daniel.Model.Dados.Itens.Minerios.*;
import com.daniel.Model.Dados.Itens.Pocoes.PocaoCura;
import com.daniel.Model.Dados.Itens.Pocoes.PocaoCuraGrande;
import com.daniel.Model.Dados.Itens.Pocoes.PocaoMp;
import com.daniel.Model.Dados.Itens.Pocoes.PocaoMpGrande;
import com.daniel.Model.Exceptions.PlayerInexistenteException;

public class Crafting {
    private double chanceBase;
    public Item criarBarraFerro(Item item, Item item2, double chance) {
        if (item != null && item2 != null) { //Verifica se nao é nulo
            if (item instanceof Ferro && item2 instanceof Ferro) { //depois verifica se participam da condiçao específica do craft
                BarraFerro barraFerro = new BarraFerro();
                this.chanceBase = chance;
                return barraFerro;
            }
        }
        return null;
    }

    public  Item criarPocaoVidaGrande(Item item, Item item2, double chance) {
        if (item != null && item2 != null) {
            if (item instanceof PocaoCura && item2 instanceof PocaoCura) {
                PocaoCuraGrande pocaoCuraGrande = new PocaoCuraGrande();
                this.chanceBase = chance;
                return pocaoCuraGrande;
            }
        }
        return null;
    }
    public  Item criarPocaoManaGrande(Item item, Item item2, double chance) {
        if (item != null && item2 != null) {
            if (item instanceof PocaoMp && item2 instanceof PocaoMp) {
                PocaoMpGrande pocaoMpGrande = new PocaoMpGrande();
                this.chanceBase = chance;
                return pocaoMpGrande;
            }
        }
        return null;
    }
    public  Item criarBarraEscuridao(Item item, Item item2, double chance) {
        if (item != null && item2 != null) {
            if (item instanceof FragmentoEscuridao && item2 instanceof FragmentoEscuridao) {
                BarraEscuridao barraEscuridao = new BarraEscuridao();
                this.chanceBase = chance;
                return barraEscuridao;
            }
        }
        return null;
    }
    public  Item criarBarraOuro(Item item, Item item2, double chance) {
        if (item != null && item2 != null) {
            if (item instanceof Ouro && item2 instanceof Ouro) {
                BarraOuro barraOuro = new BarraOuro();
                this.chanceBase = chance;
                return barraOuro;
            }
        }
        return null;
    }
    public  Item criarBarraFogo(Item item, Item item2, double chance) {
        if (item != null && item2 != null) {
            if (item instanceof FragmentoFogo && item2 instanceof FragmentoFogo) {
                BarraFogo barraFogo = new BarraFogo();
                this.chanceBase = chance;
                return barraFogo;
            }
        }
        return null;
    }
    public  Item criarBarraGelo(Item item, Item item2, double chance) {
        if (item != null && item2 != null) {
            if (item instanceof FragmentoGlacial && item2 instanceof FragmentoGlacial) {
                BarraGlacial barraGlacial = new BarraGlacial();
                this.chanceBase = chance;
                return barraGlacial;
            }
        }
        return null;
    }
    public  Item criarFerroAperfeicoado(Item item, Item item2, double chance) {
        if (item != null && item2 != null) {
            if (item instanceof BarraFerro && item2 instanceof BarraFerro) {
                FerroAperfeicoado ferroAperfeicoado = new FerroAperfeicoado();
                this.chanceBase = chance;
                return ferroAperfeicoado;
            }
        }
        return null;
    }
    public  Item criarEspadaAperfeicoada(Item item, Item item2, double chance) {
        if (item != null && item2 != null) {
            if (item instanceof EspadaInicial && item2 instanceof FerroAperfeicoado || item instanceof FerroAperfeicoado && item2 instanceof EspadaInicial) {
                EspadaAperfeiçoada espadaAperfeiçoada = new EspadaAperfeiçoada();
                this.chanceBase = chance;
                return espadaAperfeiçoada;
            }
        }
        return null;
    }

    public  Item criarEspadaGeloAperfeicoada(Item item, Item item2, double chance) {
        if (item != null && item2 != null) {
            if (item instanceof EspadaGeloBasica && item2 instanceof BarraGlacial || item instanceof BarraGlacial && item2 instanceof EspadaGeloBasica) {
                EspadaGeloAperfeicoada espadaGeloAperfeicoada = new EspadaGeloAperfeicoada();
                this.chanceBase = chance;
                return espadaGeloAperfeicoada;
            }
        }
        return null;
    }
    public  Item criarEspadaEscuridaoAperfeicoada(Item item, Item item2, double chance) {
        if (item != null && item2 != null) {
            if (item instanceof EspadaSombriaBasica && item2 instanceof BarraEscuridao || item instanceof BarraEscuridao && item2 instanceof EspadaSombriaBasica) {
                EspadaSombriaAperfeicoada espadaSombriaAperfeicoada = new EspadaSombriaAperfeicoada();
                this.chanceBase = chance;
                return espadaSombriaAperfeicoada;
            }
        }
        return null;
    }
    public  Item criarEspadaFogoAperfeicoada(Item item, Item item2, double chance) {
        if (item != null && item2 != null) {
            if (item instanceof EspadaFogoBasica && item2 instanceof BarraFogo || item instanceof BarraFogo && item2 instanceof EspadaFogoBasica) {
                EspadaDemoniaca espadaDemoniaca = new EspadaDemoniaca();
                this.chanceBase = chance;
                return espadaDemoniaca;
            }
        }
        return null;
    }
    public  Item criarEspadaEletricaAperfeicoada(Item item, Item item2,double chance) {
        if (item != null && item2 != null) {
            if (item instanceof EspadaEletricaBasica && item2 instanceof BarraOuro || item instanceof BarraOuro && item2 instanceof EspadaEletricaBasica) {
                EspadaEletricaAperfeicoada espadaEletricaAperfeicoada = new EspadaEletricaAperfeicoada();
                this.chanceBase = chance;
                return espadaEletricaAperfeicoada;
            }
        }
        return null;
    }

    public double getChanceBase() {
        return chanceBase;
    }
}
