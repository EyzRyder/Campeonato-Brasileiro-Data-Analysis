import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha = -1;
        DataHelper dataHelper = new DataHelper();
        String menuPrompt = """
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
                System.err.println("Entrada inválida! Por favor, digite um número inteiro.\nAperte Enter pra continuar.");
                scanner.nextLine();
            }
        }
    }

    private static void processarEscolha(int escolha, DataHelper dataHelper) {
        switch (escolha) {
            case 1 -> exibirTimeComMaisVitorias2008(dataHelper);
            case 2 -> exibirEstadoComMenorJogos(dataHelper);
            case 3 -> exibirJogadorComMaisGols(dataHelper);
            case 4 -> exibirJogadorComMaisGolsPenalti(dataHelper);
            case 5 -> exibirJogadoresMaisGolsContra(dataHelper);
            case 6 -> exibirJogadorComMaisCartoes(dataHelper, "Amarelo");
            case 7 -> exibirJogadorComMaisCartoes(dataHelper, "Vermelho");
            case 8 -> exibirPlacarComMaiorNumeroDeGols(dataHelper);
            case 0 -> System.out.println("Encerrando...");
            default -> System.out.println("Opção inválida.");
        }
    }


    private static void exibirJogadorComMaisCartoes(DataHelper dataHelper, String tipoCartao) {
        try {
            Map.Entry<String, Long> jogador = encontrarJogadorComMaisCartoes(dataHelper, tipoCartao);
            System.out.printf("Jogador com mais cartões %s: Jogador %s com %d cartões.%n",
                    tipoCartao, jogador.getKey(), jogador.getValue());
        } catch (NoSuchElementException e) {
            System.err.println("Nenhum cartão encontrado do tipo " + tipoCartao + ".");
        }
    }

    private static Map.Entry<String, Long> encontrarJogadorComMaisCartoes(DataHelper dataHelper, String tipoCartao) {
        return dataHelper.getCartoes()
                .stream()
                .filter(cartao -> cartao.cartao.equalsIgnoreCase(tipoCartao))
                .collect(Collectors.groupingBy(cartao -> cartao.atleta, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(() -> new NoSuchElementException("Lista de cartões está vazia."));
    }

    private static void exibirJogadorComMaisGols(DataHelper dataHelper) {
        Map<String, Long> golsPorJogador = dataHelper.getGols()
                .stream()
                .collect(Collectors.groupingBy(g -> g.atleta, Collectors.counting()));

        if (golsPorJogador.isEmpty()) {
            System.out.println("Nenhum gol registrado.");
        }

        Map.Entry<String, Long> jogadorMaisGols = golsPorJogador.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(() -> new NoSuchElementException("Nenhum jogador encontrado."));

        System.out.printf("O jogador que mais fez gols: %s com %d gols.%n",
                jogadorMaisGols.getKey(), jogadorMaisGols.getValue());
    }

    private static void exibirJogadorComMaisGolsPenalti(DataHelper dataHelper) {
        Map<String, Long> golsDePenaltiPorJogador = dataHelper.getGols()
                .stream()
                .filter(gol -> gol.tipo_de_gol != null && gol.tipo_de_gol.equalsIgnoreCase("penalty"))
                .collect(Collectors.groupingBy(g -> g.atleta, Collectors.counting()));

        if (golsDePenaltiPorJogador.isEmpty()) {
            System.out.println("Nenhum gol de pênalti registrado.");
            return;
        }


        Map.Entry<String, Long> jogadorMaisGolsPenalti = golsDePenaltiPorJogador.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(() -> new NoSuchElementException("Nenhum jogador encontrado."));

        System.out.printf("O jogador que mais fez gols de pênalti: %s com %d gols de pênalti.%n",
                jogadorMaisGolsPenalti.getKey(), jogadorMaisGolsPenalti.getValue());
    }

    private static void exibirTimeComMaisVitorias2008(DataHelper dataHelper) {
        Map<String, Long> vitoriasPorTime = dataHelper.getBrasileiraoes()
                .stream()
                .filter(jogo -> jogo.data != null && jogo.data.matches("\\d{2}/\\d{2}/2008"))
                .filter(jogo -> jogo.vencedor != null && !jogo.vencedor.equals("-"))
                .collect(Collectors.groupingBy(jogo -> jogo.vencedor, Collectors.counting()));

        if (vitoriasPorTime.isEmpty()) {
            System.out.println("Nenhuma vitória registrada em 2008.");
            return;
        }

        Map.Entry<String, Long> timeMaisVitorias = vitoriasPorTime.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(() -> new NoSuchElementException("Nenhum time encontrado."));

        System.out.printf("O time que mais venceu em 2008: %s com %d vitórias.%n",
                timeMaisVitorias.getKey(), timeMaisVitorias.getValue());
    }

    private static void exibirEstadoComMenorJogos(DataHelper dataHelper) {
        Map<String, Long> jogosPorEstado = dataHelper.getBrasileiraoes()
                .stream()
                .filter(jogo -> jogo.data != null && jogo.data.matches("\\d{2}/\\d{2}/(200[3-9]|201\\d|202[0-2])"))
                .flatMap(jogo -> {
                    List<String> estados = new ArrayList<>();
                    if (jogo.estadoMandante != null) estados.add(jogo.estadoMandante);
                    if (jogo.estadoVisitante != null) estados.add(jogo.estadoVisitante);
                    return estados.stream();
                })
                .collect(Collectors.groupingBy(estado -> estado, Collectors.counting()));

        if (jogosPorEstado.isEmpty()) {
            System.out.println("Nenhum jogo registrado entre 2003 e 2022.");
            return;
        }

        Map.Entry<String, Long> estadoMenosJogos = jogosPorEstado.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .orElseThrow(() -> new NoSuchElementException("Nenhum estado encontrado."));

        System.out.printf("O estado com o menor número de jogos entre 2003 e 2022: %s com %d jogos.%n",
                estadoMenosJogos.getKey(), estadoMenosJogos.getValue());
    }

    private static void exibirJogadoresMaisGolsContra(DataHelper dataHelper) {
        Map<String, Long> golsContra = dataHelper.getGols()
                .stream()
                .filter(gol -> gol.tipo_de_gol != null && gol.tipo_de_gol.equalsIgnoreCase("Gol Contra"))
                .collect(Collectors.groupingBy(gol -> gol.atleta, Collectors.counting()));

        if (golsContra.isEmpty()) {
            System.out.println("Nenhum gol contra registrado.");
            return;
        }

        Map.Entry<String, Long> jogadorMaisGolsContra = golsContra.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(() -> new NoSuchElementException("Nenhum jogador encontrado."));

        System.out.printf("O jogador com mais gols contra: %s com %d gols contra.%n",
                jogadorMaisGolsContra.getKey(), jogadorMaisGolsContra.getValue());
    }

    private static void exibirPlacarComMaiorNumeroDeGols(DataHelper dataHelper) {
        Optional<AbstractMap.SimpleEntry<Brasileirao, Integer>> partidaComMaisGols = dataHelper.getBrasileiraoes()
                .stream()
                .filter(jogo -> jogo.mandantePlacar != null && jogo.visitantePlacar != null)
                .map(jogo -> {
                    try {
                        int golsMandante = Integer.parseInt(jogo.mandantePlacar);
                        int golsVisitante = Integer.parseInt(jogo.visitantePlacar);
                        int totalGols = golsMandante + golsVisitante;
                        return new AbstractMap.SimpleEntry<>(jogo, totalGols);
                    } catch (NumberFormatException e) {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .max(Comparator.comparingLong(Map.Entry::getValue));

        if (partidaComMaisGols.isEmpty()) {
            System.out.println("Nenhuma partida com gols registrados.");
            return;
        }

        AbstractMap.SimpleEntry<Brasileirao, Integer> partida = partidaComMaisGols.get();
        int golsMandante = Integer.parseInt(partida.getKey().mandantePlacar);
        int golsVisitante = Integer.parseInt(partida.getKey().visitantePlacar);
        System.out.printf("A partida com o maior número de gols foi: %s (%d x %d).%n",
                partida.getKey().arena, golsMandante, golsVisitante);
    }

}