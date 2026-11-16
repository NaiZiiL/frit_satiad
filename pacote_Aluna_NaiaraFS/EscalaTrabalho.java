public class EscalaTrabalho {
    private final String dia;
    private final String horaEntrada;
    private final String horaSaida;

    public EscalaTrabalho(String dia, String horaEntrada, String horaSaida) {
        this.dia = dia;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
    }

    public String getDia() { return dia; }
    public String getHoraEntrada() { return horaEntrada; }
    public String getHoraSaida() { return horaSaida; }

    @Override
    public String toString() {
        return dia + ": " + horaEntrada + " às " + horaSaida;
    }


}
