package com.daniel.PrimeiraCamada.Entidades;

import com.daniel.PrimeiraCamada.Exceptions.PlayerExistenteException;
import com.daniel.PrimeiraCamada.Interfaces.IEquipable;
import com.daniel.PrimeiraCamada.Itens.Item;
import com.daniel.PrimeiraCamada.Itens.PocaoCura;
import com.daniel.PrimeiraCamada.Itens.PocaoMp;
import com.daniel.PrimeiraCamada.Personagem;
import com.daniel.SegundaCamada.Inventario;

import java.io.Serializable;
import java.util.List;

public class Player extends Personagem implements Serializable {
    public Inventario inventario;
    private int coins;


    public static Player player;
    public Player(int Vida, int MP, int Force, int Int, String Name, int DEF, int MagicDEF, int Velocity, int Res, int coins) throws PlayerExistenteException {
        if(player != null){
            throw new PlayerExistenteException();
        }
        else{
            this.HP = Vida;
            this.MP = MP;
            this.Force = Force;
            this.Name = Name;
            this.Def = DEF;
            this.MagicDef = MagicDEF;
            this.Velocity = Velocity;
            this.Inteligence = Int;
            this.Resistencia = Res;
            this.currentHP = this.HP-(this.HP/2);
            this.currentMP = this.MP-(this.MP/2);
            this.inventario = new Inventario();
            this.coins = coins;

            player = this;
        }
    }

    public Inventario getInventario() {
        return inventario;
    }


    public static Player getPlayer() {
        return player;
    }

    public int getCoins() {
        return coins;
    }
    public void removerCoins(int quantidade) {
        if (quantidade > 0 && this.coins >= quantidade) {
            this.coins -= quantidade;
        } else {
            System.out.println("Quantidade inválida ou moedas insuficientes.");
        }
    }


    public void setCoins(int coins) {
        this.coins = coins;
    }
}
