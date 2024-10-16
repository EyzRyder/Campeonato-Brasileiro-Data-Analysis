import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer escolha = null;
        String menuPrompt = "";

        do {
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

            escolha = null;
            while (escolha == null) {
                try {
                    System.out.println(menuPrompt);
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
                case 1:
                    System.out.println("Opção inválida.");
                break;
                case 0:
                    System.out.println("Opção inválida.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (escolha != 0);

        scanner.close();
    }
}