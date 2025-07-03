

import service.ConversorDeMoedas; // Importa a classe ConversorDeMoedas
import java.util.InputMismatchException; // Para tratar entradas numéricas inválidas
import java.util.Scanner; // Para ler a entrada do usuário


public class Main {


    private static ConversorDeMoedas conversorDeMoedas = new ConversorDeMoedas();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String opcao = "";


        do {
            exibirMenu(); // Exibe as opções de conversão
            opcao = lerOpcao(scan); // Lê a opção digitada pelo usuário


            if (!opcao.equals("7") && !opcao.equalsIgnoreCase("sair")) {
                executarConversao(opcao, scan); // Executa a conversão baseada na opção
            } else if (opcao.equals("7") || opcao.equalsIgnoreCase("sair")) {

                System.out.println("Saindo do programa. Obrigado por usar o conversor!");
                break; // Sai imediatamente do loop 'do-while
            }

        } while (desejaContinuar(scan));

        scan.close();
        System.out.println("Programa finalizado.");
    }


    public static void exibirMenu() {
        System.out.println("\n**************************************************************");
        System.out.println("Seja bem-vindo ao Conversor de Moedas!\n");
        System.out.println("Escolha uma opção de conversão:");
        System.out.println("1 - Real (BRL) -->> Dólar (USD)");
        System.out.println("2 - Dólar (USD) -->> Real (BRL)");
        System.out.println("3 - Real (BRL) -->> Euro (EUR)");
        System.out.println("4 - Euro (EUR) -->> Real (BRL)");
        System.out.println("5 - Euro (EUR) -->> Dólar (USD)");
        System.out.println("6 - Dólar (USD) -->> Euro (EUR)");
        System.out.println("7 - Sair\n");
        System.out.println("**************************************************************");
    }


    public static String lerOpcao(Scanner scanner) {
        System.out.print("Sua opção: ");
        return scanner.nextLine();
    }


    public static boolean desejaContinuar(Scanner scanner) {
        System.out.print("\nDeseja fazer outra conversão? (sim/nao): ");
        String resposta = scanner.nextLine();
        return resposta.equalsIgnoreCase("sim"); // Compara ignorando maiúsculas/minúsculas
    }


    public static void executarConversao(String opcao, Scanner scanner) {
        String moedaOrigem = "";
        String moedaDestino = "";
        String nomeMoedaEntrada = "";
        double valor = 0;

        // Bloco try-catch para tratar exceções durante a entrada do valor e a conversão
        try {
            // Mapeia a opção do menu para os códigos ISO das moedas
            switch (opcao) {
                case "1":
                    moedaOrigem = "BRL";
                    moedaDestino = "USD";
                    nomeMoedaEntrada = "Reais";
                    break;
                case "2":
                    moedaOrigem = "USD";
                    moedaDestino = "BRL";
                    nomeMoedaEntrada = "Dólares";
                    break;
                case "3":
                    moedaOrigem = "BRL";
                    moedaDestino = "EUR";
                    nomeMoedaEntrada = "Reais";
                    break;
                case "4":
                    moedaOrigem = "EUR";
                    moedaDestino = "BRL";
                    nomeMoedaEntrada = "Euros";
                    break;
                case "5":
                    moedaOrigem = "EUR";
                    moedaDestino = "USD";
                    nomeMoedaEntrada = "Euros";
                    break;
                case "6":
                    moedaOrigem = "USD";
                    moedaDestino = "EUR";
                    nomeMoedaEntrada = "Dólares";
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha um número de 1 a 7.");
                    return;
            }

            // Solicita e lê o valor a ser convertido
            System.out.printf("Digite o valor em %s: ", nomeMoedaEntrada);
            valor = scanner.nextDouble();
            scanner.nextLine(); // Limpa o buffer do scanner após ler o double


            String resultado = conversorDeMoedas.converter(moedaOrigem, moedaDestino, valor);

            System.out.println("\n--- Resultado da Conversão ---");
            System.out.println(resultado);
            System.out.println("------------------------------");

        } catch (InputMismatchException e) {

            System.err.println("Erro: Entrada inválida para o valor. Por favor, digite um número.");
            scanner.nextLine(); // Limpa a entrada inválida do buffer para evitar loop infinito
        } catch (Exception e) {

            System.err.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
}