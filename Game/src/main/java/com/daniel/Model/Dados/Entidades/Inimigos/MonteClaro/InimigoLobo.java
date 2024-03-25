package com.daniel.Model.Dados.Entidades.Inimigos.MonteClaro;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Itens.Minerios.FragM.FragForceM;
import com.daniel.Model.Itens.Minerios.FragM.FragIntM;
import com.daniel.Model.Itens.Minerios.FragM.FragSorteM;
import com.daniel.Model.Itens.Minerios.FragP.FragForce;
import com.daniel.Model.Itens.Minerios.FragP.FragInt;
import com.daniel.Model.Itens.Minerios.FragP.FragSorte;
import com.daniel.Model.Itens.Minerios.FragmentoFogo;
import com.daniel.Model.Itens.Minerios.Ouro;
import com.daniel.Model.Itens.Pocoes.TonicoDeForca;
import com.daniel.Model.Itens.Pocoes.TonicoDeInteligencia;
import com.daniel.Model.Itens.Pocoes.TonicoDeSorte;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoLobo extends Inimigo {
    public InimigoLobo() {
        super("Wolf", "/com.daniel.Images/Inimigos/Mountain Black Wolf.png", 19, 30, 26, 24, 34, 26,5500, 120, TiposElementais.NaoElemental, Comportamentos.padrao, 2200, 1100);
        this.magias.add(new Fortalecer());
        this.lootTable.AdicionarEntrada(new FragForce(), 0, 1, 0.1);
        this.lootTable.AdicionarEntrada(new FragForceM(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new Ferro(), 1, 3, 0.2);
        this.lootTable.AdicionarEntrada(new TonicoDeForca(), 0, 2, 0.025);
    }
}
