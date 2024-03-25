package com.daniel.Model.Dados.Entidades.Inimigos.MontanhaDoNorte;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.FragM.FragIntM;
import com.daniel.Model.Itens.Minerios.FragP.FragInt;
import com.daniel.Model.Itens.Minerios.FragmentoGlacial;
import com.daniel.Model.Itens.Pocoes.TonicoDeForca;
import com.daniel.Model.Itens.Pocoes.TonicoDeVelocidade;
import com.daniel.Model.Magias.Poderes.Gelo;
import com.daniel.Model.Magias.Poderes.Slow;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoSnowMan extends Inimigo {
    public InimigoSnowMan() {
        super("Abominavel boneco das neves", "/com.daniel.Images/Inimigos/Xmas Snowman.png", 72, 65, 50, 56, 57, 57,20000, 500, TiposElementais.Gelo, Comportamentos.padrao, 8000, 4000);
        this.magias.add(new Gelo());
        this.absorcao = new TiposElementais[]{TiposElementais.Gelo};
        this.fraquezas = new TiposElementais[]{TiposElementais.Fogo};
        this.resistencias = new TiposElementais[]{TiposElementais.Agua};
        this.lootTable.AdicionarEntrada(new FragmentoGlacial(), 1, 3, 0.5);
        this.lootTable.AdicionarEntrada(new FragInt(), 0, 2, 0.1);
        this.lootTable.AdicionarEntrada(new FragIntM(), 0, 1, 0.05);
        this.lootTable.AdicionarEntrada(new TonicoDeForca(), 0, 1, 0.3);
    }
}
