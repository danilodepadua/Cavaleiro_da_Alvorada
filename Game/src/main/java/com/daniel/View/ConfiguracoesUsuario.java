package com.daniel.View;

import java.util.Objects;
import java.util.prefs.Preferences;
public class ConfiguracoesUsuario {
    private static final String LARGURA_TELA = "larguraTela";
    private static final String ALTURA_TELA = "alturaTela";
    private static final String VOLUME = "volume";
    private static final String VELOCIDADE_TEXTO_BATALHA = "velTxtBtl";
    private static final String VELOCIDADE_TEXTO_Historia = "velTxtHist";
    private static final String Lingua = "Idioma";

    private static Preferences prefs = Preferences.userNodeForPackage(ConfiguracoesUsuario.class);

    public static void salvarLarguraTela(int largura) {
        prefs.putInt(LARGURA_TELA, largura);
    }

    public static void salvarAlturaTela(int altura) {
        prefs.putInt(ALTURA_TELA, altura);
    }

    public static void salvarVolume(double volume) {
        prefs.putDouble(VOLUME, volume);
    }
    public static void salvarVelelocidadeTextoBatalha(double vel){
        prefs.putDouble(VELOCIDADE_TEXTO_BATALHA, vel+1);
    }
    public static void salvarVelelocidadeTextoHistoria(double vel){
        prefs.putDouble(VELOCIDADE_TEXTO_Historia, vel+1);
    }
    public static void salvarIdioma(String idioma){
        if(!Objects.equals(idioma, "Português") && !Objects.equals(idioma, "English")){
            prefs.put(Lingua, "Português");
        }
        else {
            prefs.put(Lingua, idioma);
        }
    }
    public static int obterLarguraTelaPadrao() {
        return prefs.getInt(LARGURA_TELA, 1200);
    }

    public static int obterAlturaTelaPadrao() {
        return prefs.getInt(ALTURA_TELA, 675);
    }

    public static double obterVolumePadrao() {
        return prefs.getDouble(VOLUME, 1.0); // Configuração padrão como volume máximo (1.0)
    }
    public static double obterVelelocidadeTextoBatalhaPadrao(){
        return prefs.getDouble(VELOCIDADE_TEXTO_BATALHA, 1);
    }
    public static double obterVelelocidadeTextoHistoriaPadrao(){
        return prefs.getDouble(VELOCIDADE_TEXTO_Historia, 1);
    }
    public static String obterIdioma(){
        return prefs.get(Lingua, "Português");
    }
}
