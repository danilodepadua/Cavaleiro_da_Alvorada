package com.daniel.Modelo.Quests;

import java.util.ArrayList;
import java.util.List;

public class ManejarQuests {
    public static List<Quest> iniciarQuests() {
        List<Quest> quests = new ArrayList<>();
        quests.add(new QuestAbelha());
        quests.add(new QuestBabySlime());
        quests.add(new QuestCobraGigante());
        quests.add(new QuestSnowMan());
        quests.add(new QuestTRex());
        quests.add(new QuestSlimeRei());
        quests.add(new QuestTigerMan());
        quests.add(new QuestCorvoGigante());
        quests.add(new QuestSlimeNv3());

        quests.add(new QuestSlimeDeAguaNv2());
        quests.add(new QuestSlimeDeAguaNv1());
        quests.add(new QuestSlimeDeAguaNv3());

        quests.add(new QuestSlimeDeLuzNv1());
        quests.add(new QuestSlimeDeLuzNv2());
        quests.add(new QuestSlimeDeLuzNv3());

        quests.add(new QuestSlimeDeFogoNv1());
        quests.add(new QuestSlimeDeFogoNv2());
        quests.add(new QuestSlimeDeFogoNv3());

        quests.add(new QuestSlimeDeTerraNv1());
        quests.add(new QuestSlimeDeTerraNv2());
        quests.add(new QuestSlimeDeTerraNv3());

        quests.add(new QuestSlimeDeEscuridaoNv1());
        quests.add(new QuestSlimeDeEscuridaoNv2());
        quests.add(new QuestSlimeDeEscuridaoNv3());

        quests.add(new QuestSlimeDeRaioNv1());
        quests.add(new QuestSlimeDeRaioNv2());
        quests.add(new QuestSlimeDeRaioNv3());

        quests.add(new QuestSlimeDeGeloNv1());
        quests.add(new QuestSlimeDeGeloNv2());
        quests.add(new QuestSlimeDeGeloNv3());




        return quests;
    }
}
