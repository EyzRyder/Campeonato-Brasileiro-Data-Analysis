import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataHelper {
    public List<Cartao> cartoes;
    public List<Estatistica> estatisticas;
    public List<Gol> gols;
    public List<Brasileirao> brasileiraoes;

    DataHelper() throws IOException {
        // usar File pra carregar todos
        var rootFolder = Paths.get("./src/database/brasileirao");
        Files.list(rootFolder)
                .filter(path -> path.toString().endsWith(".csv"))
                .forEach(file ->
                        {
                            if (file.toString().contains("gols")) {
                                new Thread(() -> {
                                    try {
                                       gols=Files.lines(file)
                                                .map(line -> {
                                                    String[] row = line.replaceAll("\"", "").split(",");
                                                    if(row.length==6) {
                                                        return new Gol(row[0], row[1], row[2], row[3], row[4], row[5]);
                                                    }else {
                                                        return new Gol(row[0], row[1], row[2], row[3], row[4]);
                                                    }
                                                }).toList();
                                       gols.removeFirst();

                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                }).start();
                            }
                            if (file.toString().contains("brasileiro-full")) {
                                new Thread(() -> {
                                    try {
                                        brasileiraoes=Files.lines(file)
                                                .map(line -> {
                                                    String[] row = line.replaceAll("\"", "").split(",");
                                                        return new Brasileirao(row[0], row[1], row[2], row[3], row[4], row[5],row[6], row[7], row[8], row[9], row[10],row[11], row[12], row[13], row[14], row[15]);
                                                }).toList();
                                        brasileiraoes.removeFirst();

                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                }).start();
                            }
                            if (file.toString().contains("cartoes")) {
                                new Thread(() -> {
                                    try {
                                        cartoes=Files.lines(file)
                                                .map(line -> {
                                                    String[] row = line.replaceAll("\"", "").split(",");
                                                    return new Cartao(row[0], row[1], row[2], row[3], row[4], row[5],row[6], row[7]);
                                                }).toList();
                                        cartoes.removeFirst();

                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                }).start();
                            }
                            if (file.toString().contains("estatisticas")) {
                                new Thread(() -> {
                                    try {
                                       estatisticas= Files.lines(file)
                                                .map(line -> {
                                                    String[] row = line.replaceAll("\"", "").split(",");
                                                    return new Estatistica(row[0], row[1], row[2], row[3], row[4], row[5],row[6], row[7], row[8], row[9], row[10],row[11], row[12]);
                                                }).toList();
                                       estatisticas.removeFirst();

                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                }).start();
                            }

                        }
                );


    }

    public static void main(String[] args) throws IOException {
        DataHelper a = new DataHelper();
    }
}
