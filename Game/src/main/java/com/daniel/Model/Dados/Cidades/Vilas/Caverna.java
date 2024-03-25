package com.daniel.Model.Dados.Cidades.Vilas;

import com.daniel.Model.Dados.Cidades.Cidade;
import com.daniel.Model.Dados.Entidades.Inimigos.Bosses.BossCaverna;
import com.daniel.Model.Dados.Entidades.Inimigos.Caverna.InimigoOrc1;
import com.daniel.Model.Dados.Entidades.Inimigos.Caverna.InimigoOrc2;
import com.daniel.Model.Dados.Entidades.Inimigos.Caverna.InimigoOrc3;
import com.daniel.Model.Dados.Entidades.Inimigos.Caverna.InimigoOrc4;
import com.daniel.Model.Dados.Entidades.Inimigos.CidadeMorta.InimigoCobraGigante;
import com.daniel.Model.Dados.Entidades.Inimigos.CidadePortuaria.InimigoSlimeDeRaioNv3;
import com.daniel.Model.Dados.Entidades.Inimigos.Desapoles.InimigoSlimeDeVentoNv3;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Dados.Entidades.Inimigos.MonteClaro.InimigoCorvoGigante;
import com.daniel.Model.Dados.Entidades.Inimigos.MonteClaro.InimigoSlimeDeLuzNv3;
import com.daniel.Model.Dados.Entidades.Inimigos.MonteClaro.InimigoSlimeDeTerraNv3;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Itens.Armaduras.Capacetes.CapaceteMalha;
import com.daniel.Model.Itens.Armaduras.Peitorais.PeitoralFerro;
import com.daniel.Model.Itens.Armas.*;
import com.daniel.Model.Quests.*;

import java.util.ArrayList;

public class Caverna extends Cidade {
    public Caverna() throws PlayerInexistenteException {
        super("PEDRAVEIRA", "/com.daniel.Images/Fundos/BatalhaDePedraveira.jpg", "/com.daniel.Images/Fundos/FundoBatalhaBosque.jpg",1500, new BossCaverna());
        this.musicPath = "/com.daniel.audios/msc_pedraveira.wav";

        this.inimigos = new Inimigo[]{new InimigoOrc1(), new InimigoOrc2(), new InimigoOrc3(), new InimigoOrc1(), new InimigoOrc4()};


        this.dialogoAtivo = true;
        this.dialogoCutscene = new TextoNode(
                "Uma caverna escura escondida no meio do bosque," +
                        "lar de uma tribo de orcs.","A dark cave hidden in the middle of the woods," +
                "Home to a tribe of orcs.").getTexto();
        ajustarBotoes();


    }

    @Override
    public void ajustarBotoes() throws PlayerInexistenteException {
        this.botoes = new ArrayList<>();
        this.botoes.add(criarBotaoViajar());
        this.botoes.add(criarBotaoCacar());
        this.botoes.add(criarBotaoSalvar());

    }
}
