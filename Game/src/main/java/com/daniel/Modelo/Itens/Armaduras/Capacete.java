package com.daniel.Modelo.Itens.Armaduras;

import com.daniel.Dados.EntidadesRepositório.Player;
import com.daniel.Modelo.Exceptions.PlayerInexistenteException;
import com.daniel.Modelo.Interfaces.IEquipable;
import com.daniel.Modelo.Itens.Armadura;

public class Capacete extends Armadura implements IEquipable {
    /*public Capacete(){
        this.aumentoDefesaFisica = 0;
        this.aumentoDefesaMagica = 0;
        this.imagem = "/com.daniel.Images/Itens/FundoCapacete.png";
        this.nome = "Nenhum";
    }*/

    public Capacete(String imgPath, String nome, int quant, int preco, String desc, int aumentoDefesaFisica, int aumentoDefesaMagica) {
        super(imgPath, nome, quant, preco, desc, aumentoDefesaFisica, aumentoDefesaMagica);
    }

    @Override
    public void equipar() throws PlayerInexistenteException {
        Player.getPlayer().desequiparCapacete();
        Player.getPlayer().equiparCapacete(this);
    }
    @Override
    public void desequipar() throws PlayerInexistenteException {
        Player.getPlayer().desequiparCapacete();
    }

}
