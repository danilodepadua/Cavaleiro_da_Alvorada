package com.daniel.Model.Dados.Cidades;

public class Botao{
    private String nome;
    private Runnable func;

    public Botao(String nome, Runnable func) {
        this.nome = nome;
        this.func = func;
    }
    public void AtualizarNome(){

    }

    public String getNome() {
        return nome;
    }

    public Runnable getFunc() {
        return func;
    }


}
