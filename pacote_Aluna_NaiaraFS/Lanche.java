public class Lanche extends Produto {
    private String ingredientes;

    public Lanche() {
        super(" ", 0.0);
        this.ingredientes = "";
    }
    public Lanche(String nome, double preco, String ingredientes) {
        super(nome, preco);
        this.ingredientes = ingredientes;
    }

    public String getIngredientes() { return ingredientes; }    
    public void setIngredientes(String ingredientes) { this.ingredientes = ingredientes; }

    @Override
    public String getDescricao() { return "Nome do lanche: " + ingredientes; }
}
