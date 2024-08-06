import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void addConta(Conta conta) {
        contas.add(conta);
    }

    public Conta removeConta(int numeroConta) {
        return contas.remove(numeroConta);
    }

    public void pesquisaConta(int contaAlvo) {
        contas.stream()
                .filter(conta -> conta.getConta() == contaAlvo)
                .forEach(conta -> conta.imprimirExtrato());
    }

    public static void main(String[] args) {

        Banco banco = new Banco("Meu Banco");

        // Criação de clientes
        Cliente cliente1 = new Cliente();
        cliente1.setNome("João Silva");

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Maria Oliveira");

        // Criação de contas
        ContaCorrente cc1 = new ContaCorrente(cliente1);
        ContaPoupanca cp1 = new ContaPoupanca(cliente2);

        // Adicionando contas ao banco
        banco.addConta(cc1);
        banco.addConta(cp1);

        // Operações nas contas
        cc1.depositar(1000);
        cp1.depositar(500);
        cc1.transferir(200, cp1);

        // Pesquisar e imprimir extrato de uma conta específica
        System.out.println("Pesquisando conta corrente de " + cc1.getCliente() + ":");
        banco.pesquisaConta(cc1.getConta());

        System.out.println("\nPesquisando conta poupança de " + cp1.getCliente() + ":");
        banco.pesquisaConta(cp1.getConta());
    }
}