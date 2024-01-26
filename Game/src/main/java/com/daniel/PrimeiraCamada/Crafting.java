package com.daniel.PrimeiraCamada;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Itens.Armas.*;
import com.daniel.PrimeiraCamada.Itens.Item;
import com.daniel.PrimeiraCamada.Itens.Minerios.*;
import com.daniel.PrimeiraCamada.Itens.Pocoes.PocaoCura;
import com.daniel.PrimeiraCamada.Itens.Pocoes.PocaoCuraGrande;
import com.daniel.PrimeiraCamada.Itens.Pocoes.PocaoMp;
import com.daniel.PrimeiraCamada.Itens.Pocoes.PocaoMpGrande;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;

public class Crafting {
    private double chanceBase;
    public Item criarBarraFerro(Item item, Item item2, Button btnSlot3, Button btnCriar, double chance) throws PlayerInexistenteException {
        if (item != null && item2 != null) { //Verifica se nao é nulo
            if (item instanceof Ferro && item2 instanceof Ferro) { //depois se ambos são ferro
                btnCriar.setDisable(false);
                BarraFerro barraFerro = new BarraFerro();
                ImageView view = new ImageView(barraFerro.getImage());
                view.setFitWidth(35);
                view.setFitHeight(35);
                btnSlot3.setGraphic(view);  //Cria o botao do ferro
                this.chanceBase = chance;
                return barraFerro;

            }
        }
        return null;
    }

    public  Item criarPocaoVidaGrande(Item item, Item item2, Button btnSlot3, Button btnCriar, double chance) throws PlayerInexistenteException {
        if (item != null && item2 != null) {
            // Verifica se pelo menos um dos itens selecionados é um minério de ferro
            if (item instanceof PocaoCura && item2 instanceof PocaoCura) {
                btnCriar.setDisable(false);
                PocaoCuraGrande pocaoCuraGrande = new PocaoCuraGrande();
                ImageView view = new ImageView(pocaoCuraGrande.getImage());
                view.setFitWidth(35);
                view.setFitHeight(35);
                btnSlot3.setGraphic(view);
                this.chanceBase = chance;
                return pocaoCuraGrande;

            }
        }
        return null;
    }
    public  Item criarPocaoManaGrande(Item item, Item item2, Button btnSlot3, Button btnCriar, double chance) throws PlayerInexistenteException {
        if (item != null && item2 != null) {
            // Verifica se pelo menos um dos itens selecionados é um minério de ferro
            if (item instanceof PocaoMp && item2 instanceof PocaoMp) {
                btnCriar.setDisable(false);
                PocaoMpGrande pocaoMpGrande = new PocaoMpGrande();
                ImageView view = new ImageView(pocaoMpGrande.getImage());
                view.setFitWidth(35);
                view.setFitHeight(35);
                btnSlot3.setGraphic(view);
                this.chanceBase = chance;
                return pocaoMpGrande;

            }
        }
        return null;
    }
    public  Item criarBarraEscuridao(Item item, Item item2, Button btnSlot3, Button btnCriar, double chance) throws PlayerInexistenteException {
        if (item != null && item2 != null) {
            // Verifica se pelo menos um dos itens selecionados é um minério de ferro
            if (item instanceof FragmentoEscuridao && item2 instanceof FragmentoEscuridao) {
                btnCriar.setDisable(false);
                BarraEscuridao barraEscuridao = new BarraEscuridao();
                ImageView view = new ImageView(barraEscuridao.getImage());
                view.setFitWidth(35);
                view.setFitHeight(35);
                btnSlot3.setGraphic(view);
                this.chanceBase = chance;
                return barraEscuridao;

            }
        }
        return null;
    }
    public  Item criarBarraOuro(Item item, Item item2, Button btnSlot3, Button btnCriar, double chance) throws PlayerInexistenteException {
        if (item != null && item2 != null) {
            // Verifica se pelo menos um dos itens selecionados é um minério de ferro
            if (item instanceof Ouro && item2 instanceof Ouro) {
                btnCriar.setDisable(false);
                BarraOuro barraOuro = new BarraOuro();
                ImageView view = new ImageView(barraOuro.getImage());
                view.setFitWidth(35);
                view.setFitHeight(35);
                btnSlot3.setGraphic(view);
                this.chanceBase = chance;
                return barraOuro;

            }
        }
        return null;
    }
    public  Item criarBarraFogo(Item item, Item item2, Button btnSlot3, Button btnCriar, double chance) throws PlayerInexistenteException {
        if (item != null && item2 != null) {
            // Verifica se pelo menos um dos itens selecionados é um minério de ferro
            if (item instanceof FragmentoFogo && item2 instanceof FragmentoFogo) {
                btnCriar.setDisable(false);
                BarraFogo barraFogo = new BarraFogo();
                ImageView view = new ImageView(barraFogo.getImage());
                view.setFitWidth(35);
                view.setFitHeight(35);
                btnSlot3.setGraphic(view);
                this.chanceBase = chance;
                return barraFogo;

            }
        }
        return null;
    }
    public  Item criarBarraGelo(Item item, Item item2, Button btnSlot3, Button btnCriar, double chance) throws PlayerInexistenteException {
        if (item != null && item2 != null) {
            // Verifica se pelo menos um dos itens selecionados é um minério de ferro
            if (item instanceof FragmentoGlacial && item2 instanceof FragmentoGlacial) {
                btnCriar.setDisable(false);
                BarraGlacial barraGlacial = new BarraGlacial();
                ImageView view = new ImageView(barraGlacial.getImage());
                view.setFitWidth(35);
                view.setFitHeight(35);
                btnSlot3.setGraphic(view);
                this.chanceBase = chance;
                return barraGlacial;

            }
        }
        return null;
    }    public  Item criarFerroAperfeicoado(Item item, Item item2, Button btnSlot3, Button btnCriar, double chance) throws PlayerInexistenteException {
        if (item != null && item2 != null) {
            // Verifica se pelo menos um dos itens selecionados é um minério de ferro
            if (item instanceof BarraFerro && item2 instanceof BarraFerro) {
                btnCriar.setDisable(false);
                FerroAperfeicoado ferroAperfeicoado = new FerroAperfeicoado();
                ImageView view = new ImageView(ferroAperfeicoado.getImage());
                view.setFitWidth(35);
                view.setFitHeight(35);
                btnSlot3.setGraphic(view);
                this.chanceBase = chance;
                return ferroAperfeicoado;

            }
        }
        return null;
    }
    public  Item criarEspadaAperfeicoada(Item item, Item item2, Button btnSlot3, Button btnCriar, double chance) throws PlayerInexistenteException {
        if (item != null && item2 != null) {
            // Verifica se pelo menos um dos itens selecionados é um minério de ferro
            if (item instanceof EspadaInicial && item2 instanceof FerroAperfeicoado || item instanceof FerroAperfeicoado && item2 instanceof EspadaInicial) {
                btnCriar.setDisable(false);
                EspadaAperfeiçoada espadaAperfeiçoada = new EspadaAperfeiçoada();
                ImageView view = new ImageView(espadaAperfeiçoada.getImage());
                view.setFitWidth(35);
                view.setFitHeight(35);
                btnSlot3.setGraphic(view);
                this.chanceBase = chance;
                return espadaAperfeiçoada;

            }
        }
        return null;
    }

    public  Item criarEspadaGeloAperfeicoada(Item item, Item item2, Button btnSlot3, Button btnCriar, double chance) throws PlayerInexistenteException {
        if (item != null && item2 != null) {
            // Verifica se pelo menos um dos itens selecionados é um minério de ferro
            if (item instanceof EspadaGeloBasica && item2 instanceof BarraGlacial || item instanceof BarraGlacial && item2 instanceof EspadaGeloBasica) {
                btnCriar.setDisable(false);
                EspadaGeloAperfeicoada espadaGeloAperfeicoada = new EspadaGeloAperfeicoada();
                ImageView view = new ImageView(espadaGeloAperfeicoada.getImage());
                view.setFitWidth(35);
                view.setFitHeight(35);
                btnSlot3.setGraphic(view);
                this.chanceBase = chance;
                return espadaGeloAperfeicoada;

            }
        }
        return null;
    }
    public  Item criarEspadaEscuridaoAperfeicoada(Item item, Item item2, Button btnSlot3, Button btnCriar, double chance) throws PlayerInexistenteException {
        if (item != null && item2 != null) {
            // Verifica se pelo menos um dos itens selecionados é um minério de ferro
            if (item instanceof EspadaSombriaBasica && item2 instanceof BarraEscuridao || item instanceof BarraEscuridao && item2 instanceof EspadaSombriaBasica) {
                btnCriar.setDisable(false);
                EspadaSombriaAperfeicoada espadaSombriaAperfeicoada = new EspadaSombriaAperfeicoada();
                ImageView view = new ImageView(espadaSombriaAperfeicoada.getImage());
                view.setFitWidth(35);
                view.setFitHeight(35);
                btnSlot3.setGraphic(view);
                this.chanceBase = chance;
                return espadaSombriaAperfeicoada;

            }
        }
        return null;
    }
    public  Item criarEspadaFogoAperfeicoada(Item item, Item item2, Button btnSlot3, Button btnCriar, double chance) throws PlayerInexistenteException {
        if (item != null && item2 != null) {
            // Verifica se pelo menos um dos itens selecionados é um minério de ferro
            if (item instanceof EspadaFogoBasica && item2 instanceof BarraFogo || item instanceof BarraFogo && item2 instanceof EspadaFogoBasica) {
                btnCriar.setDisable(false);
                EspadaDemoniaca espadaDemoniaca = new EspadaDemoniaca();
                ImageView view = new ImageView(espadaDemoniaca.getImage());
                view.setFitWidth(35);
                view.setFitHeight(35);
                btnSlot3.setGraphic(view);
                this.chanceBase = chance;
                return espadaDemoniaca;

            }
        }
        return null;
    }
    public  Item criarEspadaEletricaAperfeicoada(Item item, Item item2, Button btnSlot3, Button btnCriar, double chance) throws PlayerInexistenteException {
        if (item != null && item2 != null) {
            // Verifica se pelo menos um dos itens selecionados é um minério de ferro
            if (item instanceof EspadaEletricaBasica && item2 instanceof BarraOuro || item instanceof BarraOuro && item2 instanceof EspadaEletricaBasica) {
                btnCriar.setDisable(false);
                EspadaEletricaAperfeicoada espadaEletricaAperfeicoada = new EspadaEletricaAperfeicoada();
                ImageView view = new ImageView(espadaEletricaAperfeicoada.getImage());
                view.setFitWidth(35);
                view.setFitHeight(35);
                btnSlot3.setGraphic(view);
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
