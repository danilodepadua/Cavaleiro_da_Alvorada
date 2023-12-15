package com.daniel.Repositorios;

import com.daniel.Basicos.Character;
import com.daniel.Exceptions.PlayerExistenteException;

public class Player extends Character {
    public static Player player;
    public Player(int Vida, int MP, int Force, int Int, String Name, int DEF, int MagicDEF,int Velocity) throws PlayerExistenteException {
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
            player = this;
        }
    }
}
