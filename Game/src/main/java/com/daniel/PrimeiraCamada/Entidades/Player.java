package com.daniel.PrimeiraCamada.Entidades;

import com.daniel.PrimeiraCamada.Exceptions.PlayerExistenteException;
import com.daniel.PrimeiraCamada.Personagem;
import com.daniel.SegundaCamada.Inventario;

import java.io.Serializable;

public class Player extends Personagem implements Serializable {
    private Inventario inventario;

    public static Player player;
    public Player(int Vida, int MP, int Force, int Int, String Name, int DEF, int MagicDEF, int Velocity) throws PlayerExistenteException {
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
            this.inventario = new Inventario();
            player = this;
        }
    }

    public static Player getPlayer() {
        return player;
    }

}
