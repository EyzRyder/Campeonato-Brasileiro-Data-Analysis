public class Cartao {
    public Integer partida_ID;
    public Integer rodada;
    public String clube;
    public String cartao;
    public String atleta ;
    public String num_camisa;
    public String posicao;
    public String minuto;

    public Cartao(Integer partida_ID, Integer rodada, String clube, String cartao, String atleta, String num_camisa, String posicao, String minuto) {
        this.partida_ID = partida_ID;
        this.rodada = rodada;
        this.clube = clube;
        this.cartao = cartao;
        this.atleta = atleta;
        this.num_camisa = num_camisa;
        this.posicao = posicao;
        this.minuto = minuto;
    }

    @Override
    public String toString() {
        return "Cartao{" +
                "partida_ID='" + partida_ID + '\'' +
                ", rodada='" + rodada + '\'' +
                ", clube='" + clube + '\'' +
                ", cartao='" + cartao + '\'' +
                ", atleta='" + atleta + '\'' +
                ", num_camisa='" + num_camisa + '\'' +
                ", posicao='" + posicao + '\'' +
                ", minuto='" + minuto + '\'' +
                '}';
    }
}
