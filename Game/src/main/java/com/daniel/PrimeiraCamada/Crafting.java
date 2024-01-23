package com.daniel.PrimeiraCamada;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Itens.Armas.EspadaInicial;
import com.daniel.PrimeiraCamada.Itens.Item;
import com.daniel.PrimeiraCamada.Itens.Minerios.BarraFerro;
import com.daniel.PrimeiraCamada.Itens.Minerios.Ferro;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;

public class Crafting {
    private double chanceBase;
    public Item criarBarraFerro(Item item, Item item2, Button btnSlot3, Button btnCriar, double chance) throws PlayerInexistenteException {
        if (item != null && item2 != null) {
            // Verifica se pelo menos um dos itens selecionados é um minério de ferro (ou sua lógica específica)
            if (item instanceof Ferro && item2 instanceof Ferro) {
                btnCriar.setDisable(false);
                BarraFerro barraFerro = new BarraFerro();
                ImageView view = new ImageView(barraFerro.getImage());
                view.setFitWidth(35);
                view.setFitHeight(35);
                btnSlot3.setGraphic(view);

                // Ajuste na lógica para calcular a chance com base na inteligência
                int inteligencia = Player.getPlayer().getInteligence();
                chanceBase = chance;
                // Ajuste na lógica para calcular a chance de sucesso
                double chanceSucesso = chanceBase + (inteligencia * 0.01);
                setChanceBase(chanceSucesso);
                // Gera um número aleatório entre 0 e 1 para comparar com a chance de sucesso
                double random = Math.random();

                // Se o número aleatório for menor que a chance de sucesso, o item é criado
                if (random < chanceSucesso) {
                    return barraFerro;
                }
            }
        } else {
            // Se não houver um par de itens selecionados, limpe o slot3
            btnSlot3.setGraphic(null);
            btnCriar.setDisable(true);
        }
        return null;
    }

    public  Item criarEspadaInicial(Item item, Item item2, Button btnSlot3, Button btnCriar, double chance) throws PlayerInexistenteException {
        if (item != null && item2 != null) {
            // Verifica se pelo menos um dos itens selecionados é um minério de ferro (ou sua lógica específica)
            if (item instanceof BarraFerro && item2 instanceof BarraFerro) {
                btnCriar.setDisable(false);
                EspadaInicial espadaInicial = new EspadaInicial();
                ImageView view = new ImageView(espadaInicial.getImage());
                view.setFitWidth(35);
                view.setFitHeight(35);
                btnSlot3.setGraphic(view);
                int inteligencia = Player.getPlayer().getInteligence();
                chanceBase = chance;
                // Ajuste na lógica para calcular a chance de sucesso
                double chanceSucesso = chanceBase + (inteligencia * 0.01);
                setChanceBase(chanceSucesso);
                // Gera um número aleatório entre 0 e 1 para comparar com a chance de sucesso
                double random = Math.random();

                // Se o número aleatório for menor que a chance de sucesso, o item é criado
                if (random < chanceSucesso) {
                    return espadaInicial;
                }
            }
        } else {
            // Se não houver um par de itens selecionados, limpe o slot3
            btnSlot3.setGraphic(null);
            btnCriar.setDisable(true);
        }
        return null;
    }

    public void setChanceBase(double chanceBase) {
        this.chanceBase = chanceBase;
    }

    public double getChanceBase() {
        return chanceBase;
    }
}
