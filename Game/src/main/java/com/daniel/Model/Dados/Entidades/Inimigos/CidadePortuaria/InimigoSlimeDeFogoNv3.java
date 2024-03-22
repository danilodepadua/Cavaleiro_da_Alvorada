package com.daniel.Model.Dados.Entidades.Inimigos.CidadePortuaria;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.FragM.FragForceM;
import com.daniel.Model.Itens.Minerios.FragM.FragVelM;
import com.daniel.Model.Itens.Minerios.FragP.FragForce;
import com.daniel.Model.Itens.Minerios.FragP.FragVel;
import com.daniel.Model.Itens.Minerios.FragmentoFogo;
import com.daniel.Model.Itens.Pocoes.PocaoCuraGrande;
import com.daniel.Model.Itens.Pocoes.PocaoMpGrande;
import com.daniel.Model.Magias.Poderes.Explosao;
import com.daniel.Model.Magias.Poderes.Fogo;
import com.daniel.Model.Magias.Poderes.Fortalecer;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoSlimeDeFogoNv3 extends Inimigo {
    public InimigoSlimeDeFogoNv3() {
        super("Slime de fogo grande", "/com.daniel.Images/Inimigos/Slime Fireiii.png", 55, 45, 45, 45, 45, 45,14000, 120, TiposElementais.Fogo, Comportamentos.padrao, 5600, 2800);
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.absorcao = new TiposElementais[]{TiposElementais.Fogo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Agua, TiposElementais.Gelo};
        this.magias.add(new Fogo());
        this.lootTable.AdicionarEntrada(new FragmentoFogo(), 0, 3, 0.2);
        this.lootTable.AdicionarEntrada(new PocaoMpGrande(), 0, 3, 0.5);
        this.lootTable.AdicionarEntrada(new PocaoCuraGrande(), 0, 3, 0.5);
        this.lootTable.AdicionarEntrada(new FragForce(), 0, 1, 0.01);
        this.lootTable.AdicionarEntrada(new FragForceM(), 0, 1, 0.005);
    }
}
