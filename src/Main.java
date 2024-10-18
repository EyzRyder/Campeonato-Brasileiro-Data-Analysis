import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha = -1;
        String menuPrompt = "";
        DataHelper dataHelper = new DataHelper();

        menuPrompt += """
                ╔═══════════════════════════════════════════════════════════════╗
                ║                       MENU PRINCIPAL                          ║
                ╠═══════════════════════════════════════════════════════════════╣
                ║  [1]⇨ O time que mais venceu jogos no ano de 2008;            ║
                ║  [2]⇨ O estado com o menor número de jogos entre 2003 e 2022; ║
                ║  [3]⇨ O jogador que mais fez gols;                            ║
                ║  [4]⇨ O jogador que mais fez gols de pênaltis;                ║
                ║  [5]⇨ O jogador que mais fez gols contra;                     ║
                ║  [6]⇨ O jogador que mais recebeu cartões amarelos;            ║
                ║  [7]⇨ O jogador que mais recebeu cartões vermelhos;           ║
                ║  [8]⇨ O placar da partida com o maior número de gols;         ║
                ║  [0]⇨ Sair                                                    ║
                ╚═══════════════════════════════════════════════════════════════╝
                ╔═══════════════════════════════════════════════════════════════╗
                ║                  Selecione a tarefa desejada...               ║
                ╚═══════════════════════════════════════════════════════════════╝
                """;
            do {
                System.out.println(menuPrompt);
                escolha = getInt(scanner);
                processarEscolha(escolha, dataHelper);
            } while (escolha != 0);

            scanner.close();

    }

    private static int getInt(Scanner scanner) {
        while (true) {
            try {
                System.out.print(">> Input: ");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Input inválido! Por favor, digite um número inteiro.");
                System.out.println("Aperte enter para continuar.");
                scanner.nextLine();
            }
        }
    }

    private static void processarEscolha(int escolha, DataHelper dataHelper) {
        switch (escolha) {
            case 6 -> exibirJogadorComMaisCartoes(dataHelper, "Amarelo");
            case 7 -> exibirJogadorComMaisCartoes(dataHelper, "Vermelho");
            case 0 -> System.out.println("Encerrando...");
            default -> System.out.println("Opção inválida.");
        }
    }

    private static void exibirJogadorComMaisCartoes(DataHelper dataHelper, String tipoCartao) {
        try {
            Map.Entry<String, Long> jogador = encontrarJogadorComMaisCartoes(dataHelper, tipoCartao);
            System.out.printf("Jogador com mais cartões %s: Camisa %s com %d cartões.%n",
                    tipoCartao, jogador.getKey(), jogador.getValue());
        } catch (NoSuchElementException e) {
            System.err.println("Nenhum cartão encontrado do tipo " + tipoCartao + ".");
        }
    }

    private static Map.Entry<String, Long> encontrarJogadorComMaisCartoes(DataHelper dataHelper, String tipoCartao) {
        return dataHelper.getCartoes()
                .stream()
                .filter(cartao -> cartao.cartao.equalsIgnoreCase(tipoCartao))
                .collect(Collectors.groupingBy(cartao -> cartao.num_camisa, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(() -> new NoSuchElementException("Lista de cartões está vazia."));
    }
}