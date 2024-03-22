package com.daniel.Model.Magias.Poderes;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Exceptions.RemoverCoinsException;
import com.daniel.Model.Interfaces.IEffects;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;
import com.daniel.Model.Magias.Animacoes.DebufAnimation;
import com.daniel.Model.Magias.Magia;
import com.daniel.Model.Magias.TiposElementais;

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
            this.mensagem.add(new TextoNode(Player.getPlayer().getNome() + " perdeu " + Player.getPlayer().removerCoins(quant) + " makkos",Player.getPlayer().getNome() + " lost " + Player.getPlayer().removerCoins(quant) + " makkos"));
        }
        catch (PlayerInexistenteException e){
            System.out.println("alvo da magia não foi encontrado");
        }
        catch (RemoverCoinsException e){
            System.out.println("Falha ao remover dinheiro");
        }
    }
}
