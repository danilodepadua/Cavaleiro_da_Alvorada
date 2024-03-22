package com.daniel.Model.Dados.Entidades.Inimigos.CidadePortuaria;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.BarraOuro;
import com.daniel.Model.Itens.Minerios.FragM.FragVelM;
import com.daniel.Model.Itens.Minerios.FragP.FragVel;
import com.daniel.Model.Itens.Minerios.Ouro;
import com.daniel.Model.Itens.Pocoes.PocaoCuraGrande;
import com.daniel.Model.Itens.Pocoes.PocaoMpGrande;
import com.daniel.Model.Magias.Poderes.Raio;
import com.daniel.Model.Magias.Poderes.ThunderBall;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoSlimeDeRaioNv3 extends Inimigo {
    public InimigoSlimeDeRaioNv3() {
        super("Slime de raio grande", "/com.daniel.Images/Inimigos/Slime Thunderiii.png", 56, 46, 46, 46, 46, 46,14500, 130, TiposElementais.Eletrico, Comportamentos.padrao, 5800, 2900);
        this.absorcao = new TiposElementais[]{TiposElementais.Eletrico};
        this.fraquezas = new TiposElementais[]{TiposElementais.Terra};
        this.imunidades = new TiposElementais[]{TiposElementais.NaoElemental};
        this.magias.add(new Raio());
        this.lootTable.AdicionarEntrada(new Ouro(), 1, 3, 0.2);
        this.lootTable.AdicionarEntrada(new BarraOuro(), 1, 3, 0.2);
        this.lootTable.AdicionarEntrada(new PocaoMpGrande(), 0, 3, 0.5);
        this.lootTable.AdicionarEntrada(new PocaoCuraGrande(), 0, 3, 0.5);
        this.lootTable.AdicionarEntrada(new FragVel(), 0, 1, 0.01);
        this.lootTable.AdicionarEntrada(new FragVelM(), 0, 1, 0.005);
    }
}
