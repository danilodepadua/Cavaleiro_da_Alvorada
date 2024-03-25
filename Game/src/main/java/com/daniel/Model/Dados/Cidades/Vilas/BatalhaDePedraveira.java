package com.daniel.Model.Dados.Cidades.Vilas;

import com.daniel.Model.Dados.Cidades.Cidade;
import com.daniel.Model.Dados.Entidades.Inimigos.CidadeMorta.InimigoCobraGigante;
import com.daniel.Model.Dados.Entidades.Inimigos.CidadePortuaria.InimigoSlimeDeRaioNv3;
import com.daniel.Model.Dados.Entidades.Inimigos.Desapoles.InimigoSlimeDeVentoNv3;
import com.daniel.Model.Dados.Entidades.Inimigos.MonteClaro.InimigoCorvoGigante;
import com.daniel.Model.Dados.Entidades.Inimigos.MonteClaro.InimigoSlimeDeLuzNv3;
import com.daniel.Model.Dados.Entidades.Inimigos.MonteClaro.InimigoSlimeDeTerraNv3;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;

import java.util.ArrayList;

public class BatalhaDePedraveira extends Cidade {
    public BatalhaDePedraveira() throws PlayerInexistenteException{
        super("PEDRAVEIRA", "/com.daniel.Images/Fundos/FundosCidades/RuinasFinais.png", "/com.daniel.Images/Fundos/FundosCidades/RuinasFinais.png",1500, null);
        this.musicPath = "/com.daniel.audios/msc_pedraveira.wav";

        this.inimigos = new Inimigo[]{new InimigoSlimeDeLuzNv3(), new InimigoSlimeDeRaioNv3(), new InimigoSlimeDeTerraNv3(), new InimigoSlimeDeVentoNv3(), new InimigoCobraGigante(), new InimigoCorvoGigante()};


        this.dialogoAtivo = true;
        this.dialogoCutscene = new TextoNode(
                "Pedraveira, a ruine eternamente marcada pelas cicatrizes de uma batalha antiga entre humanos e demônios, " +
                        "ultimo local de seu jornada, onde encontra o ultimo decendente de uma raça antiga que era aliada aos demonios,"+"chegou a hora de por um fim nisso, avante bravo guerreiro.",
                "Pedraveira, the ruin eternally scarred by the scars of an ancient battle between humans and demons, " +
                        "Last place of your journey, where you meet the last descendant of an ancient race that was allied with demons,"+"The time has come to put an end to it, Onward Brave Warrior."
                ).getTexto();
        ajustarBotoes();


    }

    @Override
    public void ajustarBotoes() throws PlayerInexistenteException {
        this.botoes = new ArrayList<>();
        this.botoes.add(criarBotaoViajar());
        this.botoes.add(criarBotaoSalvar());

    }
}
