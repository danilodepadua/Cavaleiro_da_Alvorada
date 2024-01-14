package com.daniel.PrimeiraCamada.Cidades;

import com.daniel.PrimeiraCamada.Cidade;
import com.daniel.PrimeiraCamada.Entidades.Inimigos.InimigoAbelha;
import com.daniel.PrimeiraCamada.Entidades.Inimigos.InimigoBabySlime;
import com.daniel.PrimeiraCamada.Entidades.Inimigos.InimigoSlimeDeEscuridaoNv1;
import com.daniel.PrimeiraCamada.Inimigo;
import com.daniel.PrimeiraCamada.Quests.QuestSlimeDeEscuridaoNv1;

import java.util.ArrayList;

public class MontanhaDoNorte extends Cidade {
    public MontanhaDoNorte(){
        super("MontanhaDoNorte","/com.daniel.Images/montanhadonorte.jpg", "/com.daniel.Images/montanhadonorte.jpg");
        this.inimigos = new Inimigo[]{new InimigoBabySlime(), new InimigoAbelha(), new InimigoSlimeDeEscuridaoNv1()};
        // Adiciona quests à lista de quests disponíveis da cidade
        this.quests = new ArrayList<>();
        quests.add(new QuestSlimeDeEscuridaoNv1());
    }
}
