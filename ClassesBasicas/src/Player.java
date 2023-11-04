public class Player extends Personagem {

    private String nome;
    private boolean vivo;

    public Player(String nome) {
        super();
        this.nome = nome;
        this.vivo = true;
    }

    public void atacar(Inimigo inimigo) {
        inimigo.setVida(inimigo.getVida() - this.getAtaque());
    }

}
