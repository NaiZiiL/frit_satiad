import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {
            Lanchonete lanchonete = new Lanchonete("Lanche Rápido");
            lanchonete.adicionarProduto(new Lanche("X-Burger", 18.50, "hambúrguer, queijo e salada"));
            lanchonete.adicionarProduto(new Bebida("Suco de laranja", 7.00, 300));
            lanchonete.adicionarProduto(new Lanche("Misto quente", 12.00, "presunto e queijo"));

            boolean executando = true;
            while (executando) {
                System.out.println("============================================================");
                System.out.println("     Trabalho desenvolvido por: Naiara Fernanada Silva      " );
                System.out.println("============================================================" );
                System.out.println("\n============" + lanchonete.getNome() + " ===================");
                System.out.println("1. Fazer pedido");
                System.out.println("2. Cadastrar cliente");
                System.out.println("3. Listar clientes");
                System.out.println("4. Cadastrar funcionário");
                System.out.println("5. Adicionar escala a funcionário");
                System.out.println("6. Listar funcionários e escalas");
                System.out.println("0. Sair");
                int opcao = lerInteiro(entrada, "Escolha: ");

                switch (opcao) {
                    case 1 -> fazerPedido(entrada, lanchonete);
                    case 2 -> cadastrarCliente(entrada, lanchonete);
                    case 3 -> listarClientes(lanchonete);
                    case 4 -> cadastrarFuncionario(entrada, lanchonete);
                    case 5 -> adicionarEscala(entrada, lanchonete);
                    case 6 -> listarFuncionarios(lanchonete);
                    case 0 -> executando = false;
                    default -> System.out.println("Opção inválida.");
                }
            }
            System.out.println("Sistema encerrado.");
        }
    }

    private static void fazerPedido(Scanner entrada, Lanchonete lanchonete) {
        lanchonete.mostrarCardapio(System.out);
        Pedido pedido = new Pedido();
        while (true) {
            int escolha = lerInteiro(entrada, "Número do produto (0 para finalizar): ");
            if (escolha == 0) break;
            if (escolha < 1 || escolha > lanchonete.getProdutos().size()) {
                System.out.println("Opção fora do cardápio.");
                continue;
            }
            pedido.adicionarItem(lanchonete.getProdutos().get(escolha - 1));
            System.out.println("Item adicionado.");
        }
        pedido.exibirResumo();
    }

    private static void cadastrarCliente(Scanner entrada, Lanchonete lanchonete) {
        System.out.println("\n=== Cadastro de cliente ===");
        String nome = lerTexto(entrada, "Nome: ");
        String telefone = lerTexto(entrada, "Telefone: ");
        lanchonete.adicionarCliente(new Cliente(nome, telefone));
        System.out.println("Cliente cadastrado.");
    }

    private static void listarClientes(Lanchonete lanchonete) {
        System.out.println("\n=== Clientes cadastrados ===");
        if (lanchonete.getClientes().isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        for (int i = 0; i < lanchonete.getClientes().size(); i++) {
            Cliente cliente = lanchonete.getClientes().get(i);
            System.out.printf("%d. %s — telefone: %s%n", i + 1, cliente.getNome(), cliente.getTelefone());
        }
    }

    private static void cadastrarFuncionario(Scanner entrada, Lanchonete lanchonete) {
        System.out.println("\n=== Cadastro de funcionário ===");
        String nome = lerTexto(entrada, "Nome: ");
        String cargo = lerTexto(entrada, "Cargo: ");
        lanchonete.adicionarFuncionario(new Funcionario(nome, cargo));
        System.out.println("Funcionário cadastrado.");
    }

    private static void adicionarEscala(Scanner entrada, Lanchonete lanchonete) {
        if (lanchonete.getFuncionarios().isEmpty()) {
            System.out.println("Cadastre um funcionário antes de criar uma escala.");
            return;
        }
        listarFuncionarios(lanchonete);
        int escolha = lerInteiro(entrada, "Número do funcionário: ");
        if (escolha < 1 || escolha > lanchonete.getFuncionarios().size()) {
            System.out.println("Funcionário não encontrado.");
            return;
        }
        String dia = lerTexto(entrada, "Dia da semana: ");
        String entradaHora = lerTexto(entrada, "Horário de entrada (HH:mm): ");
        String saidaHora = lerTexto(entrada, "Horário de saída (HH:mm): ");
        Funcionario funcionario = lanchonete.getFuncionarios().get(escolha - 1);
        funcionario.adicionarEscala(new EscalaTrabalho(dia, entradaHora, saidaHora));
        System.out.println("Escala adicionada para " + funcionario.getNome() + ".");
    }

    private static void listarFuncionarios(Lanchonete lanchonete) {
        System.out.println("\n=== Funcionários e escalas ===");
        if (lanchonete.getFuncionarios().isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }
        for (int i = 0; i < lanchonete.getFuncionarios().size(); i++) {
            Funcionario funcionario = lanchonete.getFuncionarios().get(i);
            System.out.printf("%d. %s — %s%n", i + 1, funcionario.getNome(), funcionario.getCargo());
            if (funcionario.getEscalas().isEmpty()) {
                System.out.println("   Sem escalas cadastradas.");
            } else {
                for (EscalaTrabalho escala : funcionario.getEscalas()) {
                    System.out.println("   - " + escala);
                }
            }
        }
    }

    private static String lerTexto(Scanner entrada, String mensagem) {
        System.out.print(mensagem);
        return entrada.nextLine().trim();
    }

    private static int lerInteiro(Scanner entrada, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Integer.parseInt(entrada.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }
}
