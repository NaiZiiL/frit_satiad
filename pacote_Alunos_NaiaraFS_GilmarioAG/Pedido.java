import java.util.ArrayList;
import java.util.List;

public class Pedido {
    // Associação: o pedido mantém uma coleção de produtos selecionados.
    private final List<Produto> itens = new ArrayList<>();

    public void adicionarItem(Produto produto) {
        itens.add(produto);
    }

    public void exibirResumo() {
        System.out.println("\n=== Resumo do pedido ===");
        if (itens.isEmpty()) {
            System.out.println("Nenhum item foi pedido.");
            return;
        }
        double total = 0;
        for (Produto produto : itens) {
            System.out.printf("- %s (%s): R$ %.2f%n", produto.getNome(), produto.getDescricao(), produto.getPreco());
            total += produto.getPreco();
        }
        System.out.printf("Total: R$ %.2f%n", total);
    }
}
