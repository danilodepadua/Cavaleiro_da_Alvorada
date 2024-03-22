package com.daniel.Model.Dados.Entidades.Inimigos.CidadePortuaria;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.FragM.FragForceM;
import com.daniel.Model.Itens.Minerios.FragM.FragVelM;
import com.daniel.Model.Itens.Minerios.FragP.FragForce;
import com.daniel.Model.Itens.Minerios.FragP.FragVel;
import com.daniel.Model.Itens.Minerios.FragmentoFogo;
import com.daniel.Model.Itens.Pocoes.PocaoCura;
import com.daniel.Model.Itens.Pocoes.PocaoCuraGrande;
import com.daniel.Model.Itens.Pocoes.PocaoMp;
import com.daniel.Model.Itens.Pocoes.PocaoMpGrande;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoCapitao extends Inimigo {
    public InimigoCapitao() {
        super("Capitão pirata", "com.daniel.Images/Inimigos/Pirate Captain.png", 61, 59, 45, 54, 48, 48,17000, 250, TiposElementais.NaoElemental, Comportamentos.padrao, 6800, 3400);
        this.resistencias = new TiposElementais[]{TiposElementais.NaoElemental};
        this.magias.add(new Fogo());
        this.magias.add(new Explosao());
        this.magias.add(new Cegar());
        this.magias.add(new Veneno());
        this.magias.add(new Silenciar());
        this.magias.add(new Slow());
        this.magias.add(new Stop());
        this.magias.add(new Roubo());
        this.lootTable.AdicionarEntrada(new PocaoCuraGrande(), 0, 3, 0.5);
        this.lootTable.AdicionarEntrada(new PocaoMpGrande(), 0, 3, 0.5);
        this.lootTable.AdicionarEntrada(new FragVel(), 0, 1, 0.01);
        this.lootTable.AdicionarEntrada(new FragVelM(), 0, 1, 0.005);
        this.lootTable.AdicionarEntrada(new FragForce(), 0, 1, 0.01);
        this.lootTable.AdicionarEntrada(new FragForceM(), 0, 1, 0.005);
    }
}
