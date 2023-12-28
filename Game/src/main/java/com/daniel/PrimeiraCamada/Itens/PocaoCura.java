package com.daniel.PrimeiraCamada.Itens;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Interfaces.IConsumable;

public class PocaoCura extends Item implements IConsumable {
    private int preco;
    private String descricao;

    public PocaoCura() {
        this.imagem = "/com.daniel.Images/Itens/pt1.png";
        this.nome = "Poção de cura";
        this.descricao = "Poção que concede recuperação de vida";
        this.preco = 50; // Preço inicial
    }

    public int getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }


    @Override
    public void Consumir() {
        Player.player.RecuperarVida(100);
    }
}
