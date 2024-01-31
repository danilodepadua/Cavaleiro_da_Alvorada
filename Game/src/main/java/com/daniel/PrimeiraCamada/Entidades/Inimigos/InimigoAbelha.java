package com.daniel.PrimeiraCamada.Entidades.Inimigos;

import com.daniel.PrimeiraCamada.Comportamentos;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Itens.Comidas.Banana;
import com.daniel.PrimeiraCamada.Itens.Comidas.CoxaFrango;
import com.daniel.PrimeiraCamada.Itens.Minerios.BarraFerro;
import com.daniel.PrimeiraCamada.Itens.Minerios.Ferro;
import com.daniel.PrimeiraCamada.Magias.*;
import com.daniel.PrimeiraCamada.TiposElementais;

import java.util.ArrayList;

public class InimigoAbelha extends Inimigo {
    public InimigoAbelha( ) {
        super("Abelha", "/com.daniel.Images/Inimigos/Insects Bee.png", 29, 20, 15, 35, 28, 40, 50, TiposElementais.NaoElemental, Comportamentos.padrao, 200, 50);
        this.fraquezas = new TiposElementais[]{TiposElementais.NaoElemental, TiposElementais.Terra};
        this.magias.add(new Veneno());
        this.magias.add(new Escuridao());
        this.lootTable.AdicionarEntrada(new Banana(), 1, 1, 0.2);
        this.lootTable.AdicionarEntrada(new Ferro(), 1, 1, 0.2);
    }
}
