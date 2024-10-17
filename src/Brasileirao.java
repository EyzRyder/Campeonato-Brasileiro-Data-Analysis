public class Brasileirao {
    public String ID;
    public String rodada;// Rodada que aconteceu a partida
    public String data;// Data que ocorreu a partida
    public String horario;//  Horário que ocorreu a partida
    public String dia;// Dia da semana que ocorreu a partida
    public String mandante;// Clube mandante
    public String visitante;// Clube Visitante
    public String formacao_mandante;// Formação do mandante
    public String formacao_visitante;// Formação do visitante
    public String tecnico_mandante;// Técnico do mandante
    public String tecnico_visitante;// Técnico do visitante
    public String vencedor;// Clube vencedor da partida. Quando tiver "-", é um empate
    public String arena;// Arena que ocorreu a partida
    public String mandantePlacar;// Gols que o clube mandante fez na partida
    public String visitantePlacar;// Gols que o clube visitante fez na partida
    public String estadoMandante;// Estado do clube mandatorio
    public String estadoVisitante;// Estado do clube visitante
    public String estadoVencedor;// Estado do clube vencedor. Quando tiver "-", é um empate

    public Brasileirao(String ID, String rodada, String data, String horario,  String mandante, String visitante, String formacao_mandante, String formacao_visitante, String tecnico_mandante, String tecnico_visitante, String vencedor, String arena, String mandantePlacar, String visitantePlacar, String estadoMandante, String estadoVisitante) {
        this.ID = ID;
        this.rodada = rodada;
        this.data = data;
        this.horario = horario;
        this.dia = "Segunda";
        this.mandante = mandante;
        this.visitante = visitante;
        this.formacao_mandante = formacao_mandante;
        this.formacao_visitante = formacao_visitante;
        this.tecnico_mandante = tecnico_mandante;
        this.tecnico_visitante = tecnico_visitante;
        this.vencedor = vencedor;
        this.arena = arena;
        this.mandantePlacar = mandantePlacar;
        this.visitantePlacar = visitantePlacar;
        this.estadoMandante = estadoMandante;
        this.estadoVisitante = estadoVisitante;
        this.estadoVencedor = estadoMandante;
    }

    @Override
    public String toString() {
        return "Brasileirao{" +
                "ID='" + ID + '\'' +
                ", rodada='" + rodada + '\'' +
                ", data='" + data + '\'' +
                ", horario='" + horario + '\'' +
                ", dia='" + dia + '\'' +
                ", mandante='" + mandante + '\'' +
                ", visitante='" + visitante + '\'' +
                ", formacao_mandante='" + formacao_mandante + '\'' +
                ", formacao_visitante='" + formacao_visitante + '\'' +
                ", tecnico_mandante='" + tecnico_mandante + '\'' +
                ", tecnico_visitante='" + tecnico_visitante + '\'' +
                ", vencedor='" + vencedor + '\'' +
                ", arena='" + arena + '\'' +
                ", mandantePlacar='" + mandantePlacar + '\'' +
                ", visitantePlacar='" + visitantePlacar + '\'' +
                ", estadoMandante='" + estadoMandante + '\'' +
                ", estadoVisitante='" + estadoVisitante + '\'' +
                ", estadoVencedor='" + estadoVencedor + '\'' +
                '}';
    }
}
