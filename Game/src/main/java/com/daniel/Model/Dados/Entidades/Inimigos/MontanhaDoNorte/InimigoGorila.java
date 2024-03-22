package com.daniel.Model.Dados.Entidades.Inimigos.MontanhaDoNorte;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Itens.Minerios.FragM.FragIntM;
import com.daniel.Model.Itens.Minerios.FragP.FragInt;
import com.daniel.Model.Itens.Minerios.FragmentoGlacial;
import com.daniel.Model.Itens.Pocoes.TonicoDeForca;
import com.daniel.Model.Itens.Pocoes.TonicoDeResistencia;
import com.daniel.Model.Itens.Pocoes.TonicoDeVelocidade;
import com.daniel.Model.Magias.Poderes.Gelo;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoGorila extends Inimigo {
    public InimigoGorila() {
        super("Frost Gorilla", "/com.daniel.Images/Inimigos/Megapack II Frost Gorilla.png", 76, 70, 40, 70, 60, 60,21500, 500, TiposElementais.NaoElemental, Comportamentos.padrao, 8600, 4300);
        this.magias.add(new Gelo());
        this.absorcao = new TiposElementais[]{TiposElementais.Gelo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Fogo};
        this.resistencias = new TiposElementais[]{TiposElementais.Agua,TiposElementais.NaoElemental};
        this.lootTable.AdicionarEntrada(new FragmentoGlacial(), 1, 3, 0.5);
        this.lootTable.AdicionarEntrada(new FragInt(), 0, 2, 0.01);
        this.lootTable.AdicionarEntrada(new FragIntM(), 0, 1, 0.005);
        this.lootTable.AdicionarEntrada(new TonicoDeResistencia(), 0, 1, 0.3);
        this.lootTable.AdicionarEntrada(new TonicoDeForca(), 0, 1, 0.3);
    }
}
