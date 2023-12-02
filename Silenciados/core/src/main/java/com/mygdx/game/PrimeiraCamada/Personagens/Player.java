package com.mygdx.game.PrimeiraCamada.Personagens;

public class Player extends Personagem{
    private int speed;
    private boolean vivo;
    private Inventario inventario;

    public Player(String nome, int hp, int dano, int defesa) {
        super(nome, hp, dano, defesa);
        this.inventario = new Inventario();
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }
}
