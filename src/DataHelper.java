import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataHelper {
    private List<Cartao> cartoes;
    private List<Estatistica> estatisticas;
    private List<Gol> gols;
    private List<Brasileirao> brasileiraoes;

    DataHelper() {
        var rootFolder = Paths.get("./src/database/brasileirao");

        try (Stream<Path> files = Files.list(rootFolder)) {
            files.filter(path -> path.toString().endsWith(".csv"))
                    .forEach(this::comecarThreadParaFile);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao listar arquivos no diretório: " + rootFolder, e);
        }
    }

    private void comecarThreadParaFile(Path file) {
        if (file.toString().contains("gols")) {
            new Thread(() -> {
                try {
                    gols = parseGols(file);
                } catch (IOException e) {
                    System.err.println("Erro ao ler gols: " + e.getMessage());
                }
            }).start();
        } else if (file.toString().contains("brasileiro-full")) {
            new Thread(() -> {
                try {
                    brasileiraoes = parseBrasileirao(file);
                } catch (IOException e) {
                    System.err.println("Erro ao ler dados do Brasileirão: " + e.getMessage());
                }
            }).start();
        } else if (file.toString().contains("cartoes")) {
            new Thread(() -> {
                try {
                    cartoes = parseCartoes(file);
                } catch (IOException e) {
                    System.err.println("Erro ao ler cartões: " + e.getMessage());
                }
            }).start();
        } else if (file.toString().contains("estatisticas")) {
            new Thread(() -> {
                try {
                    estatisticas = parseEstatisticas(file);
                } catch (IOException e) {
                    System.err.println("Erro ao ler estatísticas: " + e.getMessage());
                }
            }).start();
        }
    }

    private List<Gol> parseGols(Path file) throws IOException {
        try (Stream<String> lines = Files.lines(file)) {
            return lines.map(line -> {
                        String[] row = line.replaceAll("\"", "").split(",");
                        return row.length == 6
                                ? new Gol(row[0], row[1], row[2], row[3], row[4], row[5])
                                : new Gol(row[0], row[1], row[2], row[3], row[4]);
                    })
                    .collect(Collectors.toList());
        }
    }

    private List<Brasileirao> parseBrasileirao(Path file) throws IOException {
        try (Stream<String> lines = Files.lines(file)) {
            return lines.map(line -> {
                        String[] row = line.replaceAll("\"", "").split(",");
                        return new Brasileirao(row[0], row[1], row[2], row[3], row[4], row[5], row[6],
                                row[7], row[8], row[9], row[10], row[11], row[12], row[13], row[14], row[15]);
                    })
                    .collect(Collectors.toList());
        }
    }

    private List<Cartao> parseCartoes(Path file) throws IOException {
        try (Stream<String> lines = Files.lines(file)) {
            return lines
                    .map(line->line.replaceAll("\"", "").split(","))
                    .filter(row->isInteger(row[0]))
                    .map(row -> {
                        Integer partida_Id = Integer.parseInt(row[0]);
                        Integer rodada = Integer.parseInt(row[1]);
                        return new Cartao(partida_Id, rodada, row[2], row[3], row[4], row[5], row[6], row[7]);
                    })
                    .collect(Collectors.toList());
        }
    }

    private List<Estatistica> parseEstatisticas(Path file) throws IOException {
        try (Stream<String> lines = Files.lines(file)) {
            return lines.map(line -> {
                        String[] row = line.replaceAll("\"", "").split(",");
                        return new Estatistica(row[0], row[1], row[2], row[3], row[4], row[5], row[6],
                                row[7], row[8], row[9], row[10], row[11], row[12]);
                    })
                    .collect(Collectors.toList());
        }
    }

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public List<Cartao> getCartoes() {
        return cartoes;
    }

    public List<Estatistica> getEstatisticas() {
        return estatisticas;
    }

    public List<Gol> getGols() {
        return gols;
    }

    public List<Brasileirao> getBrasileiraoes() {
        return brasileiraoes;
    }
}
