package com.daniel.Model.Dados.Entidades.Inimigos.CidadeMorta;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Itens.Minerios.FragM.FragForceM;
import com.daniel.Model.Itens.Minerios.FragM.FragIntM;
import com.daniel.Model.Itens.Minerios.FragP.FragForce;
import com.daniel.Model.Itens.Minerios.FragP.FragInt;
import com.daniel.Model.Itens.Minerios.FragmentoEscuridao;
import com.daniel.Model.Itens.Pocoes.TonicoDeForca;
import com.daniel.Model.Itens.Pocoes.TonicoDeInteligencia;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoSapo3 extends Inimigo {
    public InimigoSapo3() {
        super("Green Toxic Frog", "/com.daniel.Images/Inimigos/Toxic Frog C2.png", 36, 34, 30, 34, 38, 34,8500, 170, TiposElementais.NaoElemental, Comportamentos.padrao, 3400, 1700);
        this.absorcao = new TiposElementais[]{TiposElementais.Escuridao};
        this.magias.add(new Veneno());
        this.lootTable.AdicionarEntrada(new FragmentoEscuridao(), 1, 2, 0.5);
        this.lootTable.AdicionarEntrada(new FragIntM(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new FragInt(), 0, 1, 0.1);
        this.lootTable.AdicionarEntrada(new TonicoDeInteligencia(), 0, 1, 0.2);
    }
}
