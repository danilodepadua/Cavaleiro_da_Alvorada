package com.daniel.Basicos;

import com.daniel.Exceptions.PlayerExistenteException;
import com.daniel.Repositorios.Inventario;
import javafx.scene.image.Image;

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

    public String getName() {
        return this.Name;
    }

    public int getHP() {
        return this.HP;
    }

    public int getMP() {
        return this.MP;
    }

    public int getForce() {
        return this.Force;
    }

    public int getIntelligence() {
        return this.Inteligence;
    }

    public int getDef() {
        return this.Def;
    }

    public int getMagicDef() {
        return this.MagicDef;
    }

    public int getVelocity() {
        return this.Velocity;
    }
}
