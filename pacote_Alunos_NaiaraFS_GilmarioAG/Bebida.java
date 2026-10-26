public class Bebida extends Produto {
    private final int volumeMl;

    public Bebida(String nome, double preco, int volumeMl) {
        super(nome, preco);
        this.volumeMl = volumeMl;
    }

    @Override
    public String getDescricao() { return "Bebida: " + volumeMl + " ml"; }
}
