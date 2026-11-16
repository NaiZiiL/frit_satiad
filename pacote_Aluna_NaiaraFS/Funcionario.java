import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    private final String nome;
    private final String cargo;
    // Associação: cada funcionário mantém suas escalas.
    private final List<EscalaTrabalho> escalas = new ArrayList<>();

    public Funcionario(String nome, String cargo) {
        this.nome = nome;
        this.cargo = cargo;
    }

    public String getNome() { return nome; }
    public String getCargo() { return cargo; }
    public List<EscalaTrabalho> getEscalas() { return escalas; }
    public void adicionarEscala(EscalaTrabalho escala) { escalas.add(escala); }
}
