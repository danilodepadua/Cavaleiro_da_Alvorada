package com.daniel.PrimeiraCamada;

public abstract class Comportamento {
    protected PersonagemLuta controlado, adversario;

    public Comportamento(PersonagemLuta controlado, PersonagemLuta adversario) {
        this.controlado = controlado;
        this.adversario = adversario;
    }
    protected enum acoes{
        fugir,
        atacar,
        usarMagia
    }
    public abstract acoes EscolherAcao();

    public abstract Magia EscolherMagia();
}
