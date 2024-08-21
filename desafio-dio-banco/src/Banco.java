import java.util.ArrayList;
import java.util.List;

public class Banco implements RegistradorTransacao {

    private String nome;
    private List<Conta> contas;
    private List<Transacao> transacoes;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
        this.transacoes = new ArrayList<>();
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

    public void pesquisaTransacao(int transAlvo) {
        transacoes.stream()
                .filter(trans -> trans.getID() == transAlvo)
                .forEach(trans -> trans.imprimirDetalhes());
    }

    @Override
    public void registrarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    public static void main(String[] args) {
        Banco banco = new Banco("Meu Banco");

        // Criação de clientes
        Cliente cliente1 = new Cliente();
        cliente1.setNome("João Silva");

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Maria Oliveira");

        // Criação de contas, passando o banco como RegistradorTransacao
        Conta conta1 = new Conta(cliente1, banco);
        Conta conta2 = new Conta(cliente2, banco);

        // Adicionando contas ao banco
        banco.addConta(conta1);
        banco.addConta(conta2);

        // Realizando operações nas contas
        conta1.depositar(1000);  // Depósito na conta1
        conta1.transferir(200, conta2);  // Transferência de conta1 para conta2
        conta2.depositar(500);  // Depósito na conta2
        conta2.sacar(100);



        // Imprimindo extratos das contas
        System.out.println("Extrato Conta Corrente de " + conta1.getCliente() + ":");
        conta1.imprimirExtrato();

        System.out.println("\nExtrato Conta Poupança de " + conta2.getCliente() + ":");
        conta2.imprimirExtrato();

        // Listando todas as transações realizadas
        System.out.println("\nTransações realizadas:");
        banco.transacoes.forEach(Transacao::imprimirDetalhes);

    }

}