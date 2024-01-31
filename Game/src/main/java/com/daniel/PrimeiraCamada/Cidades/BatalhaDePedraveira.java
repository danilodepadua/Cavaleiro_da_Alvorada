package com.daniel.PrimeiraCamada.Cidades;

import com.daniel.PrimeiraCamada.Cidade;
import com.daniel.PrimeiraCamada.Entidades.Inimigos.InimigoAbelha;
import com.daniel.PrimeiraCamada.Entidades.Inimigos.InimigoCobraGigante;
import com.daniel.PrimeiraCamada.Entidades.Inimigos.InimigoCorvoGigante;
import com.daniel.PrimeiraCamada.Entidades.Inimigos.InimigoLadrao;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Capacetes.CapaceteMalha;
import com.daniel.PrimeiraCamada.Itens.Armaduras.Peitorais.PeitoralFerro;
import com.daniel.PrimeiraCamada.Itens.Armas.KatanaFogo;
import com.daniel.PrimeiraCamada.Itens.Armas.KatanaGelo;
import com.daniel.PrimeiraCamada.Itens.Armas.Tridente;
import com.daniel.PrimeiraCamada.Itens.Pocoes.Cerveja;

import java.util.ArrayList;

public class BatalhaDePedraveira extends Cidade {
    public BatalhaDePedraveira() throws PlayerInexistenteException{
        super("Campo da Batalha de Pedraveira", "/com.daniel.Images/Fundos/BatalhaDePedraveira.jpg", "/com.daniel.Images/Fundos/FundoBatalhaBosque.jpg");
        this.musicPath = "/com.daniel.audios/msc_pedraveira.wav";

        this.inimigos = new Inimigo[]{new InimigoCorvoGigante(), new InimigoCobraGigante(), new InimigoAbelha()};

        this.itens.add(new Tridente());
        this.itens.add(new KatanaGelo());
        this.itens.add(new KatanaFogo());
        this.itens.add(new PeitoralFerro());
        this.itens.add(new CapaceteMalha());
        this.itens.add(new Cerveja());

        this.dialogoAtivo = true;
        this.dialogoCutscene = "Pedraveira, a cidade eternamente marcada pelas cicatrizes de uma batalha antiga entre humanos e demônios, " +
                "onde as ruas silenciosas contam histórias de coragem e resistência entre escombros e sombras.";
        ajustarBotoes();


    }

    @Override
    public void ajustarBotoes() throws PlayerInexistenteException {
        this.botoes = new ArrayList<>();
        this.botoes.add(criarBotaoViajar());
        this.botoes.add(criarBotaoCacar());
        this.botoes.add(criarBotaoLoja());
        this.botoes.add(criarBotaoQuest());
        this.botoes.add(criarBotaoTaverna());
        this.botoes.add(criarBotaoSalvar());

    }
}
