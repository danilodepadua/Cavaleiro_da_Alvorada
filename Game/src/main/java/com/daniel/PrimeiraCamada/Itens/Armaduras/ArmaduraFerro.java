package com.daniel.PrimeiraCamada.Itens.Armaduras;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Interfaces.IEquipable;
import com.daniel.PrimeiraCamada.Itens.Peitoral;

public class ArmaduraFerro extends Peitoral implements IEquipable {
    private int preco;
    private String descricao;

    public ArmaduraFerro() {
        this.imagem = "/com.daniel.Images/Itens/ArmaduraFerro.png";
        this.nome = "Armadura de Ferro";
        this.descricao = "Armadura com grande aumento de defesa";
        this.preco = 70; // Preço inicial
        this.aumentoDefesaFisica = 70;
        this.equipado = false;
    }
    public String getDescricao() {
        return descricao;
    }

    @Override
    public void equipar() throws PlayerInexistenteException {
        if (!isEquipado()) {
            if (Player.getPlayer().getPeitoral() == null) {
                Player.getPlayer().equiparPeitoral(this);
                this.equipado = true;
            } else {
                System.out.println("Já existe um peitoral equipado.");
            }
        } else {
            System.out.println("Este peitoral já está equipado.");
        }
    }


    @Override
    public void desequipar() throws PlayerInexistenteException {
        if (isEquipado()) {
            Player.getPlayer().desequiparPeitoral();
            this.equipado = false;
        } else {
            System.out.println("Essa armadura não está equipada.");
        }
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
