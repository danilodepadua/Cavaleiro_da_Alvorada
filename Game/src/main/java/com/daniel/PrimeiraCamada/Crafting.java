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

    public  Item criarEspadaInicial(Item item, Item item2, Button btnSlot3, Button btnCriar, double chance) throws PlayerInexistenteException {
        if (item != null && item2 != null) {
            // Verifica se pelo menos um dos itens selecionados é um minério de ferro
            if (item instanceof BarraFerro && item2 instanceof BarraFerro) {
                btnCriar.setDisable(false);
                EspadaInicial espadaInicial = new EspadaInicial();
                ImageView view = new ImageView(espadaInicial.getImage());
                view.setFitWidth(35);
                view.setFitHeight(35);
                btnSlot3.setGraphic(view);
                this.chanceBase = chance;
                return espadaInicial;

            }
        }
        return null;
    }

    public double getChanceBase() {
        return chanceBase;
    }

}
