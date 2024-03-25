package com.daniel.Controller;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Exceptions.PlayerInexistenteException;

public class ControlePlayerXP {
    //Classe que vai gerir a manipulaçao de XP do Player.

    public boolean ganharXp(int xp) throws PlayerInexistenteException { //metodo pra ganhar o xp
        Player.getPlayer().setCurrentXp(Player.getPlayer().getCurrentXp()+xp);
        return this.VerificarLevelUp();
    }

    public boolean VerificarLevelUp() throws PlayerInexistenteException {  //verificar se o player conseguiu subir de nivel
        if(Player.getPlayer().getXpProx() <= Player.getPlayer().getCurrentXp()){
            Player.getPlayer().setLvl(Player.getPlayer().getLvl() + 1);
            Player.getPlayer().mudarHP(Player.getPlayer().getHP()+90);
            Player.getPlayer().mudarMP(Player.getPlayer().getMP()+4);
            Player.getPlayer().setXpProx(Player.getPlayer().getXpProx()+Player.getPlayer().getLvl()*1000);
            Player.getPlayer().setPontos(Player.getPlayer().getPontos()+3);
            aprenderMagia();
            System.out.println("XpProx: " + Player.getPlayer().getXpProx());
            VerificarLevelUp();
            return true;
        }
        else{
            System.out.println("XpAtual: " + Player.getPlayer().getCurrentXp() + "| XpProx.: " + Player.getPlayer().getXpProx());
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
                Player.getPlayer().getMagias().add(new Amolecer());
                break;
            case 6:
                Player.getPlayer().getMagias().add(new WaterSpyke());
                Player.getPlayer().getMagias().add(new Enfraquecer());
            case 7:
                Player.getPlayer().getMagias().add(new Terra());
                Player.getPlayer().getMagias().add(new Raio());
                break;
            case 8:
                Player.getPlayer().getMagias().add(new Vento());
                Player.getPlayer().getMagias().add(new Splash());
                break;
            case 9:
                Player.getPlayer().getMagias().add(new Adormecer());
                Player.getPlayer().getMagias().add(new Explosao());
                break;
            case 10:
                Player.getPlayer().getMagias().add(new Cure());
                Player.getPlayer().getMagias().add(new Silenciar());
                break;
            case 11:
                Player.getPlayer().getMagias().add(new Fortalecer());
                Player.getPlayer().getMagias().add(new Endurecer());
                break;
            case 12:
                Player.getPlayer().getMagias().add(new Endurecer());
                break;
            case 13:
                Player.getPlayer().getMagias().add(new Cura());
                Player.getPlayer().getMagias().add(new Dessilenciar());
                break;
            case 14:
                Player.getPlayer().getMagias().add(new Scan());
                Player.getPlayer().getMagias().add(new IntUp());
                break;
            case 15:
                Player.getPlayer().getMagias().add(new Veneno());
                Player.getPlayer().getMagias().add(new Desenvenenar());
                break;
            case 16:
                Player.getPlayer().getMagias().add(new Curaga());
                Player.getPlayer().getMagias().add(new Slow());
            case 17:
                Player.getPlayer().getMagias().add(new ParedeTerra());
                Player.getPlayer().getMagias().add(new IntDown());
                break;
            case 18:
                Player.getPlayer().getMagias().add(new AirBlast());
                break;
            case 19:
                Player.getPlayer().getMagias().add(new Regen());
                Player.getPlayer().getMagias().add(new Fast());
                break;
            case 20:
                Player.getPlayer().getMagias().add(new Sopro());
                break;
            case 21:
                Player.getPlayer().getMagias().add(new Stop());
                break;
            default:
                break;
        }
    }
}
