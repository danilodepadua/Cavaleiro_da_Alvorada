package com.daniel.PrimeiraCamada.Cidades;

import com.daniel.PrimeiraCamada.Cidade;
import com.daniel.PrimeiraCamada.Entidades.Inimigos.*;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Quests.*;


import java.util.ArrayList;

public class CidadeInicial extends Cidade {
    public CidadeInicial() {
        super("Cidade Inicial", "/com.daniel.Images/CidadeNoturna.jpg", "/com.daniel.Images/Fundos/FundoBatalhaBosque.jpg");
        this.inimigos = new Inimigo[]{new InimigoBabySlime(), new InimigoAbelha()};
        // Adiciona quests à lista de quests disponíveis da cidade
        this.quests = new ArrayList<>();
        quests.add(new QuestAbelha());
        quests.add(new QuestBabySlime());
        quests.add(new QuestCobraGigante());
        quests.add(new QuestSnowMan());
        quests.add(new QuestTigerMan());
    }
}
