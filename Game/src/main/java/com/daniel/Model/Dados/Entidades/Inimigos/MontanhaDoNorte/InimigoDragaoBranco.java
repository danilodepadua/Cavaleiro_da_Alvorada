package com.daniel.Model.Dados.Entidades.Inimigos.MontanhaDoNorte;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.FragM.FragIntM;
import com.daniel.Model.Itens.Minerios.FragP.FragInt;
import com.daniel.Model.Itens.Minerios.FragmentoFogo;
import com.daniel.Model.Itens.Minerios.FragmentoGlacial;
import com.daniel.Model.Itens.Pocoes.TonicoDeVelocidade;
import com.daniel.Model.Itens.Pocoes.TonicoDoHeroi;
import com.daniel.Model.Magias.Poderes.Explosao;
import com.daniel.Model.Magias.Poderes.Fogo;
import com.daniel.Model.Magias.Poderes.Fortalecer;
import com.daniel.Model.Magias.Poderes.Gelo;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoDragaoBranco extends Inimigo {
    public InimigoDragaoBranco() {
        super("Dragão branco", "/com.daniel.Images/Inimigos/Dragon Lord A.png", 77, 70, 55, 58, 67, 55,22000, 500, TiposElementais.NaoElemental, Comportamentos.padrao, 8800, 4400);
        this.magias.add(new Gelo());
        this.absorcao = new TiposElementais[]{TiposElementais.Gelo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Fogo};
        this.resistencias = new TiposElementais[]{TiposElementais.Agua};
        this.lootTable.AdicionarEntrada(new FragmentoGlacial(), 1, 3, 0.5);
        this.lootTable.AdicionarEntrada(new FragInt(), 0, 2, 0.1);
        this.lootTable.AdicionarEntrada(new FragIntM(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new TonicoDoHeroi(), 0, 1, 0.05);
    }
}
