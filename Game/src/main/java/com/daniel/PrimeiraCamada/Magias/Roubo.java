package com.daniel.PrimeiraCamada.Magias;

import com.daniel.PrimeiraCamada.Entidades.Player;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Exceptions.RemoverCoinsException;
import com.daniel.PrimeiraCamada.Interfaces.IEffects;
import com.daniel.PrimeiraCamada.Magia;
import com.daniel.PrimeiraCamada.PersonagemLuta;
import com.daniel.PrimeiraCamada.TiposElementais;
import com.daniel.SegundaCamada.AnimationsAttack;
import com.daniel.SegundaCamada.DebufAnimation;

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
            Player.getPlayer().removerCoins(quant);
            this.mensagem.add(Player.getPlayer().getName() + " perdeu " + quant + " de dinheiro");
        }
        catch (PlayerInexistenteException e){
            System.out.println("alvo da magia não foi encontrado");
        }
        catch (RemoverCoinsException e){
            System.out.println("Falha ao remover dinheiro");
        }
    }
}
