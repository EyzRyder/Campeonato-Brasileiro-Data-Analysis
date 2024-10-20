public class Estatistica {
    public Integer partida_ID;
    public Integer rodadu;
    public String Clube;
    public Integer chutes;
    public Integer chutesAGol;
    public String posseDeBola;
    public Integer passes;
    public String precisao_passes;
    public Integer faltas;
    public Integer cartao_amarelo;
    public Integer cartao_vermelho;
    public Integer impedimentos;
    public Integer escanteios;

    public Estatistica(
            Integer partida_ID, Integer rodadu, String clube, Integer chutes, Integer chutesAGol,
            String posseDeBola, Integer passes, String precisao_passes, Integer faltas,
            Integer cartao_amarelo, Integer cartao_vermelho, Integer impedimentos, Integer escanteios) {
        this.partida_ID = partida_ID;
        this.rodadu = rodadu;
        Clube = clube;
        this.chutes = chutes;
        this.chutesAGol = chutesAGol;
        this.posseDeBola = posseDeBola;
        this.passes = passes;
        this.precisao_passes = precisao_passes;
        this.faltas = faltas;
        this.cartao_amarelo = cartao_amarelo;
        this.cartao_vermelho = cartao_vermelho;
        this.impedimentos = impedimentos;
        this.escanteios = escanteios;
    }

    @Override
    public String toString() {
        return "Estatistica{" +
                "partida_ID='" + partida_ID + '\'' +
                ", rodadu='" + rodadu + '\'' +
                ", Clube='" + Clube + '\'' +
                ", chutes='" + chutes + '\'' +
                ", chutesAGol='" + chutesAGol + '\'' +
                ", posseDeBola='" + posseDeBola + '\'' +
                ", passes='" + passes + '\'' +
                ", precisao_passes='" + precisao_passes + '\'' +
                ", faltas='" + faltas + '\'' +
                ", cartao_amarelo='" + cartao_amarelo + '\'' +
                ", cartao_vermelho='" + cartao_vermelho + '\'' +
                ", impedimentos='" + impedimentos + '\'' +
                ", escanteios='" + escanteios + '\'' +
                '}';
    }
}
