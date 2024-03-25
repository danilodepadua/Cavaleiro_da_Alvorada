package com.daniel.Model.Dados.Entidades.Inimigos.MonteClaro;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.FragM.FragVelM;
import com.daniel.Model.Itens.Minerios.FragP.FragVel;
import com.daniel.Model.Itens.Minerios.FragmentoFogo;
import com.daniel.Model.Itens.Pocoes.TonicoDeVelocidade;
import com.daniel.Model.Magias.Poderes.*;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoGrifo extends Inimigo {
    public InimigoGrifo() {
        super("Grifo", "/com.daniel.Images/Inimigos/Mountain Griffon.png", 23, 33, 32, 25, 35, 30,7000, 135, TiposElementais.Vento, Comportamentos.padrao, 2800, 1400);
        this.imunidades = new TiposElementais[]{TiposElementais.Vento};
        this.fraquezas = new TiposElementais[]{TiposElementais.Terra,TiposElementais.Eletrico};
        this.magias.add(new Vento());
        this.magias.add(new AirBlast());
        this.magias.add(new Fast());
        this.lootTable.AdicionarEntrada(new FragVel(), 0, 1, 0.1);
        this.lootTable.AdicionarEntrada(new FragVelM(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new TonicoDeVelocidade(), 0, 2, 0.1);
    }
}
