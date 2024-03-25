package com.daniel.Model.Dados.Entidades.Inimigos.MonteClaro;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Itens.Minerios.FragM.FragForceM;
import com.daniel.Model.Itens.Minerios.FragM.FragResM;
import com.daniel.Model.Itens.Minerios.FragP.FragForce;
import com.daniel.Model.Itens.Minerios.FragP.FragRes;
import com.daniel.Model.Itens.Minerios.FragmentoFogo;
import com.daniel.Model.Itens.Pocoes.TonicoDeForca;
import com.daniel.Model.Itens.Pocoes.TonicoDeResistencia;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoUrso extends Inimigo {
    public InimigoUrso() {
        super("Mountain Scarbear", "/com.daniel.Images/Inimigos/MountainScarbear.png", 24, 34, 20, 28, 30, 28,5500, 110, TiposElementais.NaoElemental, Comportamentos.padrao, 2200, 1100);
        this.resistencias = new TiposElementais[]{TiposElementais.NaoElemental};
        this.magias.add(new Fortalecer());
        this.magias.add(new Cure());
        this.lootTable.AdicionarEntrada(new FragForce(), 0, 1, 0.1);
        this.lootTable.AdicionarEntrada(new FragForceM(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new Ferro(), 1, 3, 0.7);
        this.lootTable.AdicionarEntrada(new TonicoDeForca(), 0, 3, 0.1);
    }
}
