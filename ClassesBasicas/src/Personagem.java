public class Personagem {

    private int vida;
    private int ataque;
    private int defesa;

    public Personagem() {

        this.vida = 10;
        this.ataque = 5;
        this.defesa = 5;
    }


    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    protected void setVida(int novaVida) {
        this.vida = novaVida;
    }
}
