package com.daniel.PrimeiraCamada.Quests;

import com.daniel.PrimeiraCamada.Quest;

import java.util.ArrayList;
import java.util.List;

public class ManejarQuests {
    public static List<Quest> iniciarQuests() {
        List<Quest> quests = new ArrayList<>();
        quests.add(new QuestAbelha());
        quests.add(new QuestBabySlime());
        quests.add(new QuestSlimeDeEscuridaoNv1());
        quests.add(new QuestCobraGigante());
        quests.add(new QuestSnowMan());
        quests.add(new QuestTRex());
        quests.add(new QuestSlimeRei());
        quests.add(new QuestTigerMan());
        quests.add(new QuestCorvoGigante());
        quests.add(new QuestSlimeNv3());
        return quests;
    }
}
