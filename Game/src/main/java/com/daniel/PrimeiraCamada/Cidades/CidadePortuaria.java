package com.daniel.PrimeiraCamada.Cidades;

import com.daniel.PrimeiraCamada.Cidade;
import com.daniel.PrimeiraCamada.Entidades.Inimigos.*;
import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Itens.Armas.EspadaInicial;
import com.daniel.PrimeiraCamada.Itens.Armas.FoiceMagica;
import com.daniel.PrimeiraCamada.Itens.Armas.Machado;
import com.daniel.PrimeiraCamada.Itens.Armas.ManoplaTita;
import com.daniel.PrimeiraCamada.Itens.Comidas.Pao;
import com.daniel.PrimeiraCamada.Itens.Comidas.Soupa;
import com.daniel.PrimeiraCamada.Itens.Pocoes.Cerveja;
import com.daniel.PrimeiraCamada.Itens.Pocoes.PocaoCura;
import com.daniel.PrimeiraCamada.Itens.Pocoes.PocaoMp;

import java.util.ArrayList;

public class CidadePortuaria extends Cidade {

    public CidadePortuaria() throws PlayerInexistenteException{
        super("Cidade Portuária", "/com.daniel.Images/Fundos/CidadePortuaria.jpg", "/com.daniel.Images/Fundos/FundoBatalhaBosque.jpg");

        this.inimigos = new Inimigo[]{new InimigoLadrao(), new InimigoSlimeDeAguaNv2(), new InimigoSlimeDeAguaNv3(), new InimigoCorvoGigante()};

        this.itens.add(new FoiceMagica());
        this.itens.add(new Machado());
        this.itens.add(new ManoplaTita());
        this.itens.add(new EspadaInicial());

        this.itens.add(new PocaoCura());
        this.itens.add(new PocaoMp());

        this.itens.add(new Pao());
        this.itens.add(new Soupa());
        this.itens.add(new Cerveja());

        this.dialogoAtivo = true;
        this.dialogoCutscene = "\"Sou atormentado por uma coceira interminável por coisas distantes. Eu adoro navegar por mares proibidos (Moby Dick)\" - Herman Melville";
        ajustarBotoes();
    }

    @Override
    public void ajustarBotoes() throws PlayerInexistenteException {
        this.botoes = new ArrayList<>();
        this.botoes.add(criarBotaoViajar());
        this.botoes.add(criarBotaoCacar());
        this.botoes.add(criarBotaoLoja());
        this.botoes.add(criarBotaoQuest());
        this.botoes.add(criarBotaoSalvar());
        this.botoes.add(criarBotaoAnciao());
    }
}
