package com.daniel.PrimeiraCamada.Itens;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Interfaces.IConsumable;
import com.daniel.game.Main;
import javafx.scene.image.Image;

public class PocaoCura extends Item implements IConsumable {
    public PocaoCura(){
        this.imagem = "/com.daniel.Images/Itens/pt1.png";
        this.nome = "Poção de cura";
    }
    @Override
    public void Consumir() {
        Player.player.RecuperarVida(100);
    }
}
