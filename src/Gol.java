public class Gol {
    public String partida_ID;
    public String rodada;
    public String clube;
    public String atleta;
    public String minuto;
    public String tipo_de_gol;

    @Override
    public String toString() {
        return "Gol{" +
                "partida_ID='" + partida_ID + '\'' +
                ", rodada='" + rodada + '\'' +
                ", clube='" + clube + '\'' +
                ", atleta='" + atleta + '\'' +
                ", minuto='" + minuto + '\'' +
                ", tipo_de_gol='" + tipo_de_gol + '\'' +
                '}';
    }

    public Gol(String partida_ID, String rodada, String clube, String atleta, String minuto, String tipo_de_gol) {
        this.partida_ID = partida_ID;
        this.rodada = rodada;
        this.clube = clube;
        this.atleta = atleta;
        this.minuto = minuto;
        this.tipo_de_gol = tipo_de_gol;
    }

    public Gol(String partida_ID, String rodada, String clube, String atleta, String minuto) {
        this.partida_ID = partida_ID;
        this.rodada = rodada;
        this.clube = clube;
        this.atleta = atleta;
        this.minuto = minuto;
    }
}
