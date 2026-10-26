public class Lanche extends Produto {
    private final String ingredientes;

    public Lanche(String nome, double preco, String ingredientes) {
        super(nome, preco);
        this.ingredientes = ingredientes;
    }

    @Override
    public String getDescricao() { return "Lanche: " + ingredientes; }
}
