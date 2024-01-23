package com.daniel.PrimeiraCamada;

import com.daniel.PrimeiraCamada.Itens.Armas.EspadaInicial;
import com.daniel.PrimeiraCamada.Itens.Item;
import com.daniel.PrimeiraCamada.Itens.Minerios.BarraFerro;
import com.daniel.PrimeiraCamada.Itens.Minerios.Ferro;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;

public class Crafting {
    public  Item criarBarraFerro(Item item, Item item2, Button btnSlot3, Button btnCriar) {
        if (item != null && item2 != null) {
            // Verifica se pelo menos um dos itens selecionados é um minério de ferro (ou sua lógica específica)
            if (item instanceof Ferro && item2 instanceof Ferro) {
                btnCriar.setDisable(false);
                BarraFerro barraFerro = new BarraFerro();
                ImageView view = new ImageView(barraFerro.getImage());
                view.setFitWidth(35);
                view.setFitHeight(35);
                btnSlot3.setGraphic(view);
                return barraFerro;
            }
        } else {
            // Se não houver um par de itens selecionados, limpe o slot3
            btnSlot3.setGraphic(null);
            btnCriar.setDisable(true);
        }
        return null;
    }
    public  Item criarEspadaInicial(Item item, Item item2, Button btnSlot3, Button btnCriar) {
        if (item != null && item2 != null) {
            // Verifica se pelo menos um dos itens selecionados é um minério de ferro (ou sua lógica específica)
            if (item instanceof BarraFerro && item2 instanceof BarraFerro) {
                btnCriar.setDisable(false);
                EspadaInicial espadaInicial = new EspadaInicial();
                ImageView view = new ImageView(espadaInicial.getImage());
                view.setFitWidth(35);
                view.setFitHeight(35);
                btnSlot3.setGraphic(view);
                return espadaInicial;
            }
        } else {
            // Se não houver um par de itens selecionados, limpe o slot3
            btnSlot3.setGraphic(null);
            btnCriar.setDisable(true);
        }
        return null;
    }
}
