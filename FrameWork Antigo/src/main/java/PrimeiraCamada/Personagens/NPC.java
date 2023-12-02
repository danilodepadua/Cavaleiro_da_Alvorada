package PrimeiraCamada.Personagens;

public class NPC extends Personagem{
    private Comportamento comportamento;


    public NPC(String nome, int hp, int dano, int defesa) {
        setStats(nome, hp, dano, defesa);
    }

    public Comportamento getComportamento() {
        return comportamento;
    }

    public void setComportamento(Comportamento comportamento) {
        this.comportamento = comportamento;
    }
}
