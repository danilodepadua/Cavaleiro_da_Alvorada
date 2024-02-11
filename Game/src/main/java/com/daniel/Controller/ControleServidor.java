package com.daniel.Controller;

import com.daniel.game.Main;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class ControleServidor {
    private HttpServer server;
    public ControleServidor(){
    }
    public void ligarServidor(){
        //cria o servidor usando a biblioteca do Http
        server = null;
        try {
            server = HttpServer.create(new InetSocketAddress(4040), 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Cria um contexto pro servidor, ou seja, o que vem depois do localHost: 4040
        server.createContext("/", exchange -> {
            // Obtém o caminho solicitado pelo cliente
            String requestedPath = exchange.getRequestURI().getPath();
            InputStream inputStream = null;

            // Verifica se a pessoa está solicitando o arquivo index.html
            if (requestedPath.equals("/") || requestedPath.equals("/index.html")) {
                // Se sim, retorna o conteúdo do arquivo index.html onde esta presente o teachable machine
                try {
                    inputStream = Main.class.getResourceAsStream("/com/daniel/game/IA/index.html");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (requestedPath.startsWith("/my_model/")) {
                // Se o cliente está solicitando arquivos da pasta my_model, como model.json, weights.bin, etc.
                String resourcePath = requestedPath.substring("/my_model".length());
                try {
                    inputStream = Main.class.getResourceAsStream("/com/daniel/game/IA/my_model" + resourcePath);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // Se o inputStream estiver nulo, significa que o arquivo não foi encontrado, ocasionando erro
            if (inputStream == null) {
                exchange.sendResponseHeaders(404, -1);
                return;
            }
            exchange.sendResponseHeaders(200, 0);

            // Escreve o conteúdo do arquivo no corpo da resposta
            try (OutputStream responseBody = exchange.getResponseBody()) {
                byte[] buffer = new byte[8192];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    responseBody.write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        server.start();
    }

    public void desligarServidor() {
        if (server != null) {
            server.stop(0); // O argumento 0 indica que o desligamento deve ser imediato
            System.out.println("Servidor desligado.");
        }
    }

}
