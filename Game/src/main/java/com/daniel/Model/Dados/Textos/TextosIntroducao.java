package com.daniel.Model.Dados.Textos;

import java.util.ArrayList;

public class TextosIntroducao {
    private static final TextoNode intro1 = new TextoNode("Há muitas eras, em um mundo ancestral onde humanos e demônios coexistiam no mesmo plano. Conflitos incessantes eclodiam em todos os cantos, alimentados pela incompatibilidade de suas naturezas. O choque entre esses seres era como uma dança sombria, em um ciclo interminável de dor e sofrimento. Os céus testemunhavam silenciosos o embate eterno entre luz e escuridão, entre o bem e o mal.", "Many ages ago, in an ancient world where humans and demons coexisted on the same plane. Incessant conflicts erupted in every corner, fueled by the incompatibility of their natures. The clash between these beings was like a dark dance, in an endless cycle of pain and suffering. The heavens silently witnessed the eternal struggle between light and darkness, between good and evil.");
    private static final TextoNode intro2 = new TextoNode("No entanto, um dia, sem aviso prévio, mas há muito esperado, a guerra irrompeu entre os dois povos. Homens marcharam para o campo de batalha, determinados a enfrentar as criaturas das trevas e proteger suas famílias e sua pátria. A guerra se estendeu por décadas, até que, finalmente, os humanos emergiram vitoriosos, selando os demônios em uma dimensão distante.", "However, one day, without warning but long-awaited, war broke out between the two peoples. Men marched to the battlefield, determined to confront the creatures of darkness and protect their families and homeland. The war stretched for decades until, finally, humans emerged victorious, sealing the demons in a distant dimension.");
    private static final TextoNode intro3 = new TextoNode("O mundo finalmente alcançou uma era de paz, uma paz jamais experimentada antes. Para muitos, os demônios se tornaram meras lendas e folclore. No entanto, essa paz está prestes a ser perturbada. Três selos enfraqueceram, abrindo passagens para a invasão demoníaca. Estamos, mais uma vez, à beira do colapso diante do caos primordial.", "The world finally reached an era of peace, a peace never before experienced. For many, demons became mere legends and folklore. However, this peace is about to be disturbed. Three seals have weakened, opening passages for the demonic invasion. Once again, we stand on the brink of collapse in the face of primordial chaos.");
    private static final TextoNode intro4 = new TextoNode("Como um dos descendentes dos antigos herois que foram responsáveis por selar os demônios no passado, você deverá embarcar em uma jornada para descobrir o que está causando o rompimento dos selos e restaurá-los. O caminho será árduo, repleto de perigos inimagináveis, mas o destino da humanidade depende de sua coragem e determinação.", "As one of the descendants of the ancient heroes who were responsible for sealing the demons in the past, you must embark on a journey to discover what is causing the seals to rupture and restore them. The path will be arduous, filled with unimaginable dangers, but the fate of humanity depends on your courage and determination.");
    private static final TextoNode intro5 = new TextoNode("Contamos com você, nobre guerreiro. Que a sorte esteja ao seu lado em sua missão para impedir o retorno das trevas a este mundo. Que sua espada seja afiada, sua mente clara e seu coração corajoso, pois sobre seus ombros repousa o destino de todos nós.", "We count on you, noble warrior. May luck be on your side in your mission to prevent the return of darkness to this world. May your sword be sharp, your mind clear, and your heart brave, for upon your shoulders rests the destiny of us all.");

    public static String[] getIntroducao(){
        return new String[]{intro1.getTexto(), intro2.getTexto(), intro3.getTexto(), intro4.getTexto(), intro5.getTexto()};
    }

    // Outro textos
    private static final TextoNode DicaCria = new TextoNode(
            "Com seus pontos, distribua-os da forma que preferir entre seus atributos. \n\nNo entanto, lembre-se de que investir \nexclusivamente em um único atributo \npode resultar em situações desfavoráveis no futuro.",
            "With your points, distribute them in the way you prefer among your attributes. \n\nHowever, keep in mind that investing \nexclusively in a single attribute \ncan result in unfavorable situations in the future."
    );
    public static String getDica(){
        return DicaCria.getTexto();
    }
}
