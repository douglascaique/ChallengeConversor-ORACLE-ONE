---

# 🚀 Conversor de Moedas - Desafio Oracle ONE G8 (Java + Spring + IA)

Olá! Este é um projeto desenvolvido como parte do **Programa ONE (Oracle Next Education)**, na **Turma G8 Back-end - JAVA + Spring + IA**. O objetivo principal foi colocar em prática conceitos fundamentais de Java, explorando a integração com APIs externas e a manipulação de dados para construir uma aplicação funcional de console.

---

## 🎯 Sobre o Desafio

O desafio consistiu em criar um **Conversor de Moedas** simples, mas robusto, que permite ao usuário realizar conversões entre diferentes moedas em tempo real, através de um menu interativo no console.

**Pontos principais e objetivos do projeto:**

1.  **Interação com o Usuário via Console:** Desenvolver uma interface de linha de comando clara e amigável para que o usuário possa escolher as opções de conversão e inserir valores.
2.  **Consumo de API Externa (Extended Rate API):** Implementar a lógica para fazer requisições HTTP para uma API de cotações em tempo real, demonstrando a capacidade de integrar aplicações com serviços externos.
3.  **Processamento de JSON (com Gson):** Utilizar a biblioteca **Gson** para desserializar (converter) os dados recebidos em formato JSON da API em objetos Java, tornando-os fáceis de manipular.
4.  **Cálculo de Conversão:** Realizar os cálculos matemáticos para converter o valor fornecido pelo usuário com base nas taxas de câmbio obtidas da API.
5.  **Tratamento de Erros e Boas Práticas:** Implementar um robusto tratamento de exceções para garantir que o programa lide gracefully com possíveis erros (como problemas de conexão, API fora do ar ou entrada inválida do usuário), além de aplicar princípios de **Orientação a Objetos (POO)** para um código limpo e modular.

---

## 💻 Tecnologias Utilizadas

Como estudante de programação, este projeto me proporcionou um contato aprofundado com as seguintes tecnologias e conceitos:

* **Java (JDK 21):** A linguagem principal de desenvolvimento, utilizando funcionalidades modernas como **Records** para modelagem de dados concisa e a API `HttpClient` para requisições HTTP.
* **Gson:** Uma biblioteca Java do Google para serializar e desserializar objetos Java para JSON e vice-versa. Essencial para processar a resposta da API de forma eficiente.
* **Extended Rate API:** A API de terceiros utilizada para obter as cotações de moedas em tempo real, demonstrando a importância de trabalhar com serviços RESTful.
* **Controle de Versão (Git/GitHub):** Utilização do Git para versionamento do código e do GitHub para hospedagem do repositório, gerenciando o histórico de desenvolvimento e colaboração.
* **IntelliJ IDEA:** A IDE (Ambiente de Desenvolvimento Integrado) utilizada para desenvolvimento e depuração do projeto, otimizando o fluxo de trabalho.

---

## 🧠 Aprendizados Mobilizados

Durante o desenvolvimento deste desafio, pude consolidar e mobilizar os seguintes aprendizados:

* **Fundamentos de Java:** Reforço em estruturas de controle de fluxo (`do-while`, `switch`), tipos de dados, métodos e classes.
* **Programação Orientada a Objetos (POO):** Prática de conceitos como **encapsulamento**, **delegação de responsabilidades** e **separação de preocupações** através da criação de classes dedicadas (`ApiKey`, `TaxaDeCambioResposta`, `HttpConversor`, `ConversorDeMoedas`, `Main`).
* **Consumo de APIs:** Entendimento do ciclo de vida de uma requisição HTTP (construção da URL, envio da requisição, leitura da resposta e tratamento de status codes).
* **Parseamento de JSON:** Habilidade em utilizar bibliotecas externas para transformar dados JSON em objetos Java e vice-versa, um requisito comum em aplicações modernas.
* **Tratamento de Exceções:** Implementação robusta de `try-catch` para garantir a resiliência do programa frente a erros de rede, API ou entrada do usuário.
* **Modularização de Código:** A importância de dividir o projeto em módulos lógicos, cada um com sua responsabilidade, para facilitar a manutenção e escalabilidade.

Este projeto foi significativo na minha jornada de aprendizado em Back-end com Java, consolidando conhecimentos essenciais para futuros desafios no desenvolvimento de software.

---

**Como rodar o projeto:**

1.  Clone este repositório.
2.  Abra o projeto no IntelliJ IDEA.
3.  Certifique-se de ter o **JDK 21** configurado.
4.  Adicione a biblioteca **Gson** como uma dependência externa (o arquivo JAR).
5.  Obtenha uma **chave de API** da [Extended Rate API](https://www.exchangerate-api.com/) e insira-a no arquivo `ApiKey.java`.
6.  Execute a classe `Main`.

---
