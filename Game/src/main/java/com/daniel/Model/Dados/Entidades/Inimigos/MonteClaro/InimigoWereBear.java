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

public class InimigoWereBear extends Inimigo {
    public InimigoWereBear() {
        super("Martz", "/com.daniel.Images/Inimigos/Mountain Werebear Martz.png", 27, 40, 30, 38, 34, 28,8500, 150, TiposElementais.NaoElemental, Comportamentos.padrao, 3400, 1700);
        this.resistencias = new TiposElementais[]{TiposElementais.NaoElemental};
        this.magias.add(new Fortalecer());
        this.magias.add(new Fast());
        this.lootTable.AdicionarEntrada(new FragForce(), 0, 1, 0.1);
        this.lootTable.AdicionarEntrada(new FragForceM(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new Ferro(), 1, 3, 0.7);
        this.lootTable.AdicionarEntrada(new TonicoDeForca(), 0, 3, 0.1);
    }
}
