package com.daniel.Modelo.Magia.Poderes;

import com.daniel.Dados.EntidadesRepositório.Player;
import com.daniel.Modelo.Exceptions.PlayerInexistenteException;
import com.daniel.Modelo.Exceptions.RemoverCoinsException;
import com.daniel.Modelo.Interfaces.IEffects;
import com.daniel.Modelo.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Dados.MagiasRepositório.DebufAnimation;
import com.daniel.Modelo.Magia.Magia;
import com.daniel.Modelo.Magia.TiposElementais;

import java.util.Random;

public class Roubo extends Magia implements IEffects {
    public Roubo() {
        super("Roubo", 5, 0, TiposElementais.NaoElemental, new DebufAnimation(), false);
        this.autoUsavel = false;
    }

    @Override
    public void aplicarEfeito(PersonagemLuta alvo){
        Random rand = new Random();
        int quant = rand.nextInt(20, 200);
        try {
            this.mensagem.add(Player.getPlayer().getName() + " perdeu " + Player.getPlayer().removerCoins(quant) + " de dinheiro");
        }
        catch (PlayerInexistenteException e){
            System.out.println("alvo da magia não foi encontrado");
        }
        catch (RemoverCoinsException e){
            System.out.println("Falha ao remover dinheiro");
        }
    }
}
