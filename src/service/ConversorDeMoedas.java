package service;

import model.TaxaDeCambioResposta;

import java.io.IOException;
import java.text.DecimalFormat;

public class ConversorDeMoedas {

    private final HttpConversor httpConversor;

    public ConversorDeMoedas() {
        this.httpConversor = new HttpConversor();
    }

    public String converter(String moedaOrigem, String moedaDestino, double valor) {
        try {
            // A API retorna as taxas em relação à moeda base
            // buscar as taxas da moeda de origem
            TaxaDeCambioResposta respostaApi = httpConversor.buscarTaxas(moedaOrigem);

            // Valida se resposta da API é válida e contém as taxas de conversão
            if (respostaApi == null || respostaApi.conversion_rates() == null || respostaApi.conversion_rates().isEmpty()) {
                return "Erro: Não foi possível obter as taxas de conversão para " + moedaOrigem + ". A resposta da API está vazia ou inválida.";
            }

            // Obtém a taxa de câmbio da moeda de destino em relação à moeda de origem
            Double taxaDestino = respostaApi.conversion_rates().get(moedaDestino);

            if (taxaDestino == null) {
                return "Erro: Não foi possível encontrar a taxa para a moeda de destino '" + moedaDestino + "' a partir de '" + moedaOrigem + "'.";
            }

            // Realiza o cálculo da conversão
            double valorConvertido = valor * taxaDestino;

            // Formata o resultado para duas casas decimais
            DecimalFormat df = new DecimalFormat("#,##0.00");
            return String.format("%s %s = %s %s", df.format(valor), moedaOrigem, df.format(valorConvertido), moedaDestino);

        } catch (IOException e) {
            return "Erro de comunicação com a API: Verifique sua conexão com a internet ou a chave da API. Detalhes: " + e.getMessage();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return "A operação de conversão foi interrompida inesperadamente. Por favor, tente novamente.";

        } catch (RuntimeException e) {
            return "Erro interno ao processar a conversão: " + e.getMessage();

        } catch (Exception e) {
            return "Ocorreu um erro inesperado: " + e.getMessage();

        }
    }
}