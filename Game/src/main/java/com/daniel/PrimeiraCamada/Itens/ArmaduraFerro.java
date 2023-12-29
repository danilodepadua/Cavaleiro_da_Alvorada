package com.daniel.PrimeiraCamada.Itens;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Interfaces.IEquipable;

import static com.daniel.PrimeiraCamada.Entidades.Player.player;

public class ArmaduraFerro extends Item implements IEquipable {
    private int preco;
    private String descricao;
    private int aumentoDefesa;  // Adição do atributo
    private boolean equipado;
    public ArmaduraFerro(){
        this.imagem="/com.daniel.Images/Itens/ArmaduraPeitoral.png";
        this.nome ="Armadura de ferro";
        this.descricao = "Armadura rustica com um grande aumento de defesa física";
        this.preco = 50; // Preço inicial
        this.aumentoDefesa = 50;
        this.equipado = false;
    }

    public int getAumentoDefesa() {
        return aumentoDefesa;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public void equipar() {
        Player.player.aumentarDefesa(this.getAumentoDefesa());
        this.equipado = true;
    }

    @Override
    public void desequipar() {
        Player.player.diminuirDefesa(this.getAumentoDefesa());
        this.equipado = false;
    }

    @Override
    public boolean isEquipado() {
        return equipado;
    }

    @Override
    public int getPreco() {
        return preco;
    }
}
