package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Itens.Comidas.Banana;
import com.daniel.PrimeiraCamada.Itens.Comidas.CoxaFrango;
import com.daniel.PrimeiraCamada.Itens.Item;
import com.daniel.PrimeiraCamada.Itens.Minerios.Ferro;
import com.daniel.PrimeiraCamada.Magias.Escuridao;
import com.daniel.PrimeiraCamada.Magias.Fogo;
import com.daniel.PrimeiraCamada.Magias.Gelo;
import com.daniel.PrimeiraCamada.Magias.Luz;
import com.daniel.PrimeiraCamada.TiposElementais;

public class InimigoBabySlime extends Inimigo {
    public InimigoBabySlime() {
        super("Slime", "/com.daniel.Images/Inimigos/Slime Blue.png", 1, 5, 5, 10, 5, 5, 10, 10, 5, 30, 10, TiposElementais.NaoElemental, Comportamentos.padrao, 200, 5);
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.magias.add(new Fogo());
        this.magias.add(new Gelo());
        this.magias.add(new Luz());
        this.magias.add(new Escuridao());
        this.itens.add(new Ferro());
        this.itens.add(new CoxaFrango());
        this.itens.add(new Banana());
    }
}
