package com.daniel.PrimeiraCamada.Itens.Pocoes;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Interfaces.IConsumable;
import com.daniel.PrimeiraCamada.Itens.Item;

public class PocaoMp extends Item implements IConsumable {
    private int preco;
    private String descricao;

    public PocaoMp(){
        this.nome = "Ether";
        this.imagem = "/com.daniel.Images/Itens/pt2.png";
        this.preco = 20; // Preço inicial
        this.descricao = "Poção que concede recuperação de vida";


    }

    public int getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public void Consumir() {
        Player.player.RecuperarMp(100);
    }
}
