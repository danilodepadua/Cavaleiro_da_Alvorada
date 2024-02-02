package com.daniel.Model.Dados.Magias.Poderes;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Exceptions.RemoverCoinsException;
import com.daniel.Model.Interfaces.IEffects;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Model.Dados.Magias.Animation.DebufAnimation;
import com.daniel.Model.Dados.Magias.Magia;
import com.daniel.Model.Dados.Magias.TiposElementais;

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
