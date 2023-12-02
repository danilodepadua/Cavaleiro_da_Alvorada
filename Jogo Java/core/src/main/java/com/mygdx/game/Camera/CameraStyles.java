package com.mygdx.game.Camera;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

public class CameraStyles {
    // Construtor privado para garantir que a classe não seja instanciada
    private CameraStyles() {
    }

    // Método para limitar a posição da câmera dentro de certos limites
    public static void boundaries(OrthographicCamera camera, float inicioX, float inicioY, float largura, float altura) {
        Vector3 posiçao = camera.position;

        // Limita a posição da câmera no eixo x
        if (posiçao.x < inicioX) {
            posiçao.x = inicioY;
        }
        if (posiçao.x > inicioX + largura) {
            posiçao.x = inicioX + largura;
        }

        // Limita a posição da câmera no eixo y
        if (posiçao.y < inicioY) {
            posiçao.y = inicioY;
        }
        if (posiçao.y > inicioY + altura) {
            posiçao.y = inicioY + altura;
        }

        // Atualiza a posição da câmera e aplica as mudanças
        camera.position.set(posiçao);
        camera.update();
    }
}
