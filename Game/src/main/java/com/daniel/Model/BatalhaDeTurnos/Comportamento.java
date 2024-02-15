package com.daniel.Model.BatalhaDeTurnos;

import com.daniel.Model.Exceptions.ErroUsarMagiaExptions;
import com.daniel.Model.Magias.Magia;

public abstract class Comportamento {
    protected PersonagemLuta controlado, adversario;
    protected Magia magiaEscolhida;
    public Comportamento(PersonagemLuta controlado, PersonagemLuta adversario) {
        this.controlado = controlado;
        this.adversario = adversario;
    }
    protected enum acoes{
        fugir,
        atacar,
        usarMagia
    }
    public final acoes EscolherAcao(){
        acoes action = this.LogicaEscolhaAcao();
        if(action == acoes.usarMagia){
            try {
                magiaEscolhida = this.EscolherMagia();
            }
            catch (Exception e){
                ErroUsarMagiaExptions erro = new ErroUsarMagiaExptions(controlado.getNome(), this);
                System.out.println(erro.getMessage());
            }
        }
        return action;
    }

    public abstract acoes LogicaEscolhaAcao();
    public abstract Magia EscolherMagia();

}
