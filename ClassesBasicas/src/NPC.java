package PrimeiraCamada.Personagens;

public class NPC extends Personagem{
    private Comportamento comportamento;


    public NPC(String nome, int hp, int dano, int defesa) {
        super(nome, hp, dano, defesa);
    }

    public Comportamento getComportamento() {
        return comportamento;
    }

    public void setComportamento(Comportamento comportamento) {
        this.comportamento = comportamento;
    }
}
