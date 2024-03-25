package com.daniel.Model.Dados.Entidades.Inimigos.MontanhaDoNorte;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.FragM.FragIntM;
import com.daniel.Model.Itens.Minerios.FragP.FragInt;
import com.daniel.Model.Itens.Minerios.FragmentoGlacial;
import com.daniel.Model.Itens.Pocoes.PocaoMpGrande;
import com.daniel.Model.Itens.Pocoes.TonicoDeVelocidade;
import com.daniel.Model.Magias.Poderes.Gelo;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoSlimeDeGeloNv3 extends Inimigo {
    public InimigoSlimeDeGeloNv3() {
        super("Slime de gelo grande", "/com.daniel.Images/Inimigos/Slime Iceiii.png", 71, 57, 57, 57, 57, 57,20000, 500, TiposElementais.Gelo, Comportamentos.padrao, 8000, 4000);
        this.magias.add(new Gelo());
        this.absorcao = new TiposElementais[]{TiposElementais.Gelo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Fogo};
        this.resistencias = new TiposElementais[]{TiposElementais.Agua};
        this.lootTable.AdicionarEntrada(new FragmentoGlacial(), 1, 3, 0.5);
        this.lootTable.AdicionarEntrada(new FragInt(), 0, 2, 0.1);
        this.lootTable.AdicionarEntrada(new FragIntM(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new PocaoMpGrande(), 0, 1, 0.3);
    }
}
