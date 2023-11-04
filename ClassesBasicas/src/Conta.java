public class Conta {
    private String id;
    private String senha;
    private Player player;

    public Conta(String id, String senha){
        this.id = id;
        this.senha = senha;
    }


    public void setPersonagem(Player player) {
        this.player = player;
    }


}
