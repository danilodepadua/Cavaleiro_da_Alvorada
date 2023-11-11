public abstract class Item {

    private String nome;
    private int Quantidade = 0;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void addQuantidade(int Quant) {
        this.Quantidade += Quant;
    }
    public void removerQuantidade(int Quant) {
    	this.Quantidade -= Quant;
    }
    public int getNome() {
        return Quantidade;
    }
}
