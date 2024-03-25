package com.daniel.Model.Dados.Entidades.Inimigos.MonteClaro;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Itens.Minerios.FragM.FragForceM;
import com.daniel.Model.Itens.Minerios.FragP.FragForce;
import com.daniel.Model.Itens.Minerios.FragmentoFogo;
import com.daniel.Model.Itens.Pocoes.TonicoDeForca;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoChimera extends Inimigo {
    public InimigoChimera() {
        super("Chimera", "/com.daniel.Images/Inimigos/Mountain Chimera.png", 30, 38, 25, 30, 32, 30,7000, 135, TiposElementais.NaoElemental, Comportamentos.padrao, 2800, 1400);
        this.resistencias = new TiposElementais[]{TiposElementais.NaoElemental};
        this.magias.add(new Veneno());
        this.magias.add(new Desenvenenar());
        this.magias.add(new Cegar());
        this.lootTable.AdicionarEntrada(new FragForce(), 0, 1, 0.1);
        this.lootTable.AdicionarEntrada(new FragForceM(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new Ferro(), 1, 3, 0.7);
        this.lootTable.AdicionarEntrada(new TonicoDeForca(), 0, 3, 0.1);
    }
}
