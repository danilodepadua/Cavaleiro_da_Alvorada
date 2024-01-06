package com.daniel.PrimeiraCamada.Itens.Pocoes;

import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Interfaces.IConsumableInBattle;
import com.daniel.PrimeiraCamada.Interfaces.IConsumableOutBattle;
import com.daniel.PrimeiraCamada.Itens.Item;
import com.daniel.PrimeiraCamada.PersonagemLuta;

public class TonicoDeForca extends Item implements IConsumableInBattle {
    public TonicoDeForca(){
        this.nome = "Tônico de força";
        this.imagem = "/com.daniel.Images/Itens/pt3.png";
        this.preço = 100; // Preço inicial
        this.descricao = "Poção que concede 5 pontos de força durante a batalha";
    }
    @Override
    public String Consumir(PersonagemLuta p) throws PlayerInexistenteException {
        p.UpForca(5);
        return "Jogador ganhou mais 5 de força";
    }
}
