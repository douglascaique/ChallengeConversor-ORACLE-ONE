package service;

import com.google.gson.Gson;
import config.ApiKey;
import model.TaxaDeCambioResposta; //

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// Interagir com API Extended Rate
// Requisitar HTTP e converter resposta JSON em objeto Java
public class HttpConversor {

    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";
    private final HttpClient httpClient;
    private final Gson gson;
    private final String apiKey;

    public HttpConversor() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
        this.apiKey = ApiKey.getApiKey();
    }

    public TaxaDeCambioResposta buscarTaxas(String moedaBase) throws IOException, InterruptedException {
        // Constrói a URL completa da API para obter as taxas da moeda base

        String urlString = BASE_URL + apiKey + "/latest/" + moedaBase;
        URI uri = URI.create(urlString); // Cria um objeto URI a partir da string da URL

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (200 == response.statusCode()) { // Código 200 indica sucesso
            TaxaDeCambioResposta respostaApi = gson.fromJson(response.body(), TaxaDeCambioResposta.class);

            if (respostaApi.result().equals("success")) {
                return respostaApi; // Retorna o objeto com as taxas
            } else {
                throw new RuntimeException("Erro retornado pela API: " + respostaApi.result() + " - Detalhes: " + response.body());
            }
        } else {
            throw new IOException("Falha na requisição HTTP. Status: " + response.statusCode() + " - Resposta: " + response.body());
        }
    }
}