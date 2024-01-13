package com.daniel.PrimeiraCamada.Quests;

import java.util.ArrayList;
import java.util.List;

public class ManejarQuests {
    private static final ManejarQuests instance = new ManejarQuests();
    private List<Quests> questsDisponiveis;

    private ManejarQuests() {
        questsDisponiveis = new ArrayList<>();
        // Adicione as quests disponíveis aqui
        questsDisponiveis.add(new QuestBabySlime());
        questsDisponiveis.add(new QuestAbelha());
        questsDisponiveis.add(new QuestInimigoSlimeDeEscuridaoNv1());
    }

    public static ManejarQuests getInstance() {
        return instance;
    }

    public List<Quests> getQuestsDisponiveis() {
        return questsDisponiveis;
    }

    public void removerQuestDisponivel(Quests quest) {
        if (questsDisponiveis != null) {
            questsDisponiveis.remove(quest);
        }
    }
}
