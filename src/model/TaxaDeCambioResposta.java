package model;

import java.util.Map;

public record TaxaDeCambioResposta(
        String result, // resultado da requisição
        String base_code,  // moeda base da conversão
        Map<String, Double> conversion_rates // mapa de taxas de conversão onde a chave é o código da moeda e o valor é a taxa de conversão
) {

}
