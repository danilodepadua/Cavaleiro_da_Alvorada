package com.daniel.Model.Dados.Entidades.Inimigos.MonteClaro;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Itens.Minerios.FragM.FragForceM;
import com.daniel.Model.Itens.Minerios.FragP.FragForce;
import com.daniel.Model.Itens.Minerios.FragmentoFogo;
import com.daniel.Model.Itens.Pocoes.TonicoDeForca;
import com.daniel.Model.Magias.Poderes.Explosao;
import com.daniel.Model.Magias.Poderes.Fast;
import com.daniel.Model.Magias.Poderes.Fogo;
import com.daniel.Model.Magias.Poderes.Fortalecer;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoTRex extends Inimigo {
    public InimigoTRex() {
        super("T-Rex", "/com.daniel.Images/Inimigos/Colossal T-Rex Red.png", 28, 45, 25, 35, 28, 32,8000, 145, TiposElementais.NaoElemental, Comportamentos.padrao, 3200, 1600);
        this.resistencias = new TiposElementais[]{TiposElementais.NaoElemental, TiposElementais.Terra};
        this.magias.add(new Fortalecer());
        this.lootTable.AdicionarEntrada(new FragForce(), 0, 1, 0.1);
        this.lootTable.AdicionarEntrada(new FragForceM(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new Ferro(), 1, 3, 0.7);
        this.lootTable.AdicionarEntrada(new TonicoDeForca(), 0, 3, 0.1);
    }
}
