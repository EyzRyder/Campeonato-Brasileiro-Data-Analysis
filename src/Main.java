import java.io.IOException;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Integer escolha = null;
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

            escolha = null;
            while (escolha == null) {
                try {
                    System.out.print(">> Input: ");
                    escolha = Integer.parseInt(scanner.nextLine());
                    System.out.println();
                } catch (NumberFormatException ex) {
                    System.err.println("Input Invalid! Por favor digite um numero inteiro");
                    System.out.println("Aperte enter pra continuar");
                    scanner.nextLine();
                }
            }

            switch (escolha) {
                case 6:
                    Map<String, Long> cartaoAmarelaDosJogadores = dataHelper
                            .cartoes
                            .stream()
                            .filter(cartao -> cartao.cartao.equalsIgnoreCase("Amarelo"))
                            .collect(Collectors.groupingBy(cartao -> cartao.num_camisa, Collectors.counting()));
                    Map.Entry<String, Long> jogadorComMaisCartaoAmarela = cartaoAmarelaDosJogadores
                            .entrySet()
                            .stream()
                            .max(Map.Entry.comparingByValue()).orElseThrow(() -> new NoSuchElementException("Lista de cartões está vazia"));

                    System.out.println("Jogador com mais cartões Amarelas: Camisa " + jogadorComMaisCartaoAmarela.getKey() +
                            " com " + jogadorComMaisCartaoAmarela.getValue() + " cartões amarelos.");
                    break;
                case 7:
                    Map<String, Long> cartaoVermelhoDosJogadores = dataHelper
                            .cartoes
                            .stream()
                            .filter(cartao -> cartao.cartao.equalsIgnoreCase("Vermelho"))
                            .collect(Collectors.groupingBy(cartao -> cartao.num_camisa, Collectors.counting()));
                    Map.Entry<String, Long> jogadorComMaisCartaoVermelho = cartaoVermelhoDosJogadores
                            .entrySet()
                            .stream()
                            .max(Map.Entry.comparingByValue()).orElseThrow(() -> new NoSuchElementException("Lista de cartões está vazia"));

                    System.out.println("Jogador com mais cartões Vermelhos: Camisa " + jogadorComMaisCartaoVermelho.getKey() +
                            " com " + jogadorComMaisCartaoVermelho.getValue() + " cartões vermelhos.");
                    break;
                case 0:
                    System.out.println("Saindo ...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (escolha != 0);

        scanner.close();
    }
}