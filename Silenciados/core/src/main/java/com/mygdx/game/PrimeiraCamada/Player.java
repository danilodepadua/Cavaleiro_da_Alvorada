package com.mygdx.game.PrimeiraCamada;

public class Player extends Personagem{
    private int speed;
    private boolean vivo;
    private Inventario inventario;
    public static Player player;

    public Player(String nome, int hp, int dano, int defesa) {
        if(Player.player == null){
            Player.player = this;
            Player.player.setStats(nome, hp, dano, defesa);
            this.inventario = new Inventario();
        }
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
