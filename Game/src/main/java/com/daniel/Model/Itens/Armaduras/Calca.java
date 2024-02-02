package com.daniel.Model.Itens.Armaduras;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IEquipable;
import com.daniel.Model.Itens.Armadura;

public class Calca extends Armadura implements IEquipable {
    /*public Calca(){
        this.aumentoDefesaFisica = 0;
        this.aumentoDefesaMagica= 0;
        this.imagem = "/com.daniel.Images/Itens/FundoCalça.png";
        this.nome = "Nenhum";
    }*/

    public Calca(String imgPath, String nome, int quant, int preco, String desc, int aumentoDefesaFisica, int aumentoDefesaMagica) {
        super(imgPath, nome, quant, preco, desc, aumentoDefesaFisica, aumentoDefesaMagica);
    }

    @Override
    public void equipar() throws PlayerInexistenteException {
        Player.getPlayer().desequiparCalca();
        Player.getPlayer().equiparCalca(this);

    }

    @Override
    public void desequipar() throws PlayerInexistenteException {
        Player.getPlayer().desequiparCalca();
    }
}
