package PrimeiraCamada.Personagens;

public class Personagem {
    private String nome;
    private int vida;
    private int ataqueMelee;
    private int defesa;

    public Personagem(String nome, int vida, int ataqueMelee, int defesa){
        this.nome = nome;
        this.vida = vida;
        this.ataqueMelee = ataqueMelee;
        this.defesa = defesa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaqueMelee() {
        return ataqueMelee;
    }

    public void setAtaqueMelee(int ataqueMelee) {
        this.ataqueMelee = ataqueMelee;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }
}
