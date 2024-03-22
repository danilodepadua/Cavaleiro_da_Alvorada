package com.daniel.Model.Dados.Entidades.Inimigos.Auroraville;

import com.daniel.Model.ComportamentosInimigos.Comportamentos;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Minerios.Ferro;
import com.daniel.Model.Itens.Pocoes.PocaoCura;
import com.daniel.Model.Magias.TiposElementais;

public class InimigoJavali extends Inimigo {
    public InimigoJavali() {
        super("Warthog", "/com.daniel.Images/Inimigos/Mountain Warthog.png", 6, 22, 16, 20, 17, 15,3000, 10, TiposElementais.NaoElemental, Comportamentos.padrao, 600, 300);
        this.absorcao = new TiposElementais[]{TiposElementais.Terra};
        this.lootTable.AdicionarEntrada(new Ferro(), 0, 1, 0.2);
        this.lootTable.AdicionarEntrada(new PocaoCura(), 0, 1, 0.6);
    }
}
