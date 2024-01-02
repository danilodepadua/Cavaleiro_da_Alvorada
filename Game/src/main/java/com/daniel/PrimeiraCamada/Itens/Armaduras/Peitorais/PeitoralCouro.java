package com.daniel.PrimeiraCamada.Itens.Armaduras.Peitorais;

import com.daniel.PrimeiraCamada.Interfaces.IEquipable;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Peitoral;

public class PeitoralCouro extends Peitoral implements IEquipable {

    public PeitoralCouro() {
        this.imagem = "/com.daniel.Images/Itens/ArmaduraPeitoral.png";
        this.nome = "Armadura de Couro";
        this.descricao = "Concede um aumento de defesa física";
        this.preço = 10;
        this.aumentoDefesaFisica = 30;
    }

}
