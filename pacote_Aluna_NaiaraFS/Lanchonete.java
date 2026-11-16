import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Lanchonete {
    private final String nome;
    private final List<Produto> produtos = new ArrayList<>();
    private final List<Funcionario> funcionarios = new ArrayList<>();
    private final List<Cliente> clientes = new ArrayList<>();

    public Lanchonete(String nome) { this.nome = nome; }
    public String getNome() { return nome; }
    public List<Produto> getProdutos() { return produtos; }
    public void adicionarProduto(Produto produto) { produtos.add(produto); }
    public List<Funcionario> getFuncionarios() { return funcionarios; }
    public List<Cliente> getClientes() { return clientes; }
    public void adicionarFuncionario(Funcionario funcionario) { funcionarios.add(funcionario); }
    public void adicionarCliente(Cliente cliente) { clientes.add(cliente); }

    // Dependência: usa PrintStream recebido no método, sem mantê-lo como atributo.
    public void mostrarCardapio(java.io.PrintStream saida) {
        saida.println("\nCardápio:");
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            saida.printf(Locale.forLanguageTag("pt-BR"), "%d. %s — %s — R$ %.2f%n", i + 1, produto.getNome(), produto.getDescricao(), produto.getPreco());
        }
    }
}
