package com.daniel.Model.Dados;

import java.util.prefs.Preferences;
public class ConfiguracoesUsuario {
    private static final String LARGURA_TELA = "larguraTela";
    private static final String ALTURA_TELA = "alturaTela";
    private static final String VOLUME = "volume";

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
    public static int obterLarguraTelaPadrao() {
        return prefs.getInt(LARGURA_TELA, 1136);
    }

    public static int obterAlturaTelaPadrao() {
        return prefs.getInt(ALTURA_TELA, 639);
    }

    public static double obterVolumePadrao() {
        return prefs.getDouble(VOLUME, 1.0); // Configuração padrão como volume máximo (1.0)
    }

}
