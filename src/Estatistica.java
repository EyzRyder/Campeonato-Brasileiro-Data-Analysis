public class Estatistica {
    public String partida_ID;
    public String rodadu;
    public String Clube;
    public String chutes;
    public String chutesAGol;
    public String posseDeBola ;
    public String passes ;
    public String precisao_passes ;
    public String faltas ;
    public String cartao_amarelo ;
    public String cartao_vermelho ;
    public String impedimentos ;
    public String escanteios ;

    public Estatistica(String partida_ID, String rodadu, String clube, String chutes, String chutesAGol, String posseDeBola, String passes, String precisao_passes, String faltas, String cartao_amarelo, String cartao_vermelho, String impedimentos, String escanteios) {
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
