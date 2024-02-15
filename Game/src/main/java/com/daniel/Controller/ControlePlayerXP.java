package com.daniel.Controller;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Exceptions.PlayerInexistenteException;

public class ControlePlayerXP {
    //Classe que vai gerir a manipulaçao de XP do Player.

    public boolean ganharXp(int xp) throws PlayerInexistenteException { //metodo pra ganhar o xp
        Player.getPlayer().setCurrentXp(Player.getPlayer().getXp()+xp);
        return this.VerificarLevelUp();
    }

    public boolean VerificarLevelUp() throws PlayerInexistenteException {  //verificar se o player conseguiu subir de nivel
        if(Player.getPlayer().getXpProx() < Player.getPlayer().getCurrentXp()){
            Player.getPlayer().setLvl(Player.getPlayer().getLvl() + 1);
            Player.getPlayer().mudarHP(Player.getPlayer().getHP()+90);
            Player.getPlayer().mudarMP(Player.getPlayer().getMP()+4);
            Player.getPlayer().setXpProx(Player.getPlayer().getXpProx()+Player.getPlayer().getLvl()*1000);
            aprenderMagia();
            VerificarLevelUp();
            return true;
        }
        return false;
    }
    public void aprenderMagia() throws PlayerInexistenteException { //caso ele suba o nivel, aprende magias
        switch (Player.getPlayer().getLvl()){
            case 2:
                Player.getPlayer().getMagias().add(new Gelo());
                break;
            case 3:
                Player.getPlayer().getMagias().add(new Luz());
                break;
            case 4:
                Player.getPlayer().getMagias().add(new Escuridao());
                break;
            case 5:
                Player.getPlayer().getMagias().add(new Redemoinho());
                break;
            case 6:
                Player.getPlayer().getMagias().add(new WaterSpyke());
            case 7:
                Player.getPlayer().getMagias().add(new Terra());
                break;
            case 8:
                Player.getPlayer().getMagias().add(new Vento());
                break;
            case 9:
                Player.getPlayer().getMagias().add(new Adormecer());
                break;
            case 10:
                Player.getPlayer().getMagias().add(new Cura());
                break;
            case 11:
                Player.getPlayer().getMagias().add(new Fortalecer());
                break;
            default:
                break;
        }
    }
}
