package com.daniel.PrimeiraCamada.Entidades;

import com.daniel.PrimeiraCamada.Exceptions.PlayerExistenteException;
import com.daniel.PrimeiraCamada.Itens.PocaoCura;
import com.daniel.PrimeiraCamada.Itens.PocaoMp;
import com.daniel.PrimeiraCamada.Personagem;
import com.daniel.SegundaCamada.Inventario;

import java.io.Serializable;

public class Player extends Personagem implements Serializable {
    public Inventario inventario;

    public static Player player;
    public Player(int Vida, int MP, int Force, int Int, String Name, int DEF, int MagicDEF, int Velocity, int Res) throws PlayerExistenteException {
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
            for(int i=0; i<5;i++) {
                this.inventario.adicionarItem(new PocaoCura());
                this.inventario.adicionarItem(new PocaoMp());
            }
            player = this;
        }
    }

    public static Player getPlayer() {
        return player;
    }

}
