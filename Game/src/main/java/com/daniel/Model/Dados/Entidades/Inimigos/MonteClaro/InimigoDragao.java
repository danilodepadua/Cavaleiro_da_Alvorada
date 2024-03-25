package com.daniel.Model.Dados.Entidades.Inimigos.MonteClaro;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Itens.Minerios.FragM.FragResM;
import com.daniel.Model.Itens.Minerios.FragP.FragRes;
import com.daniel.Model.Itens.Minerios.FragmentoFogo;
import com.daniel.Model.Itens.Pocoes.TonicoDeResistencia;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoDragao extends Inimigo {
    public InimigoDragao() {
        super("Dragon", "/com.daniel.Images/Inimigos/Dragon King Brown.png", 31, 39, 30, 45, 36, 30,9500, 160, TiposElementais.Terra, Comportamentos.padrao, 3800, 1900);
        this.absorcao = new TiposElementais[]{TiposElementais.Terra};
        this.fraquezas = new TiposElementais[]{TiposElementais.Agua};
        this.resistencias = new TiposElementais[]{TiposElementais.NaoElemental};
        this.magias.add(new Terra());
        this.magias.add(new ParedeTerra());
        this.magias.add(new Endurecer());
        this.magias.add(new Cura());
        this.lootTable.AdicionarEntrada(new FragRes(), 0, 1, 0.1);
        this.lootTable.AdicionarEntrada(new FragResM(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new Ferro(), 1, 3, 0.7);
        this.lootTable.AdicionarEntrada(new TonicoDeResistencia(), 0, 3, 0.1);
    }
}
