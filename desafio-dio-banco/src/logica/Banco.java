package logica;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public Conta pesquisaConta(int contaAlvo) {
        for (Conta conta : contas) {
            if (conta.getConta() == contaAlvo) {
                return conta;  // Retorna a conta encontrada
            }
        }
        return null;
    }

    public String listarInfosClientes()  {
        return contas.stream()
                .map(conta -> String.format("Agencia: %d; Nome Cliente: %s; Id Conta: %d; Saldo: R$ %.2f",
                        conta.getAgencia(),
                        conta.getCliente(),
                        conta.getConta(),
                        conta.getSaldo()))
                .collect(Collectors.joining(", \n"));
    }

    public void pesquisaTransacao(int transAlvo) {
        transacoes.stream()
                .filter(trans -> trans.getID() == transAlvo)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void registrarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }}

    /*public static void main(String[] args) {
        Banco banco = new Banco("Meu logica.Banco");

        // Criação de clientes
        Cliente cliente1 = new Cliente();
        cliente1.setNome("João Silva");

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Maria Oliveira");

        // Criação de contas, passando o banco como logica.RegistradorTransacao
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
        System.out.println("Extrato logica.Conta Corrente de " + conta1.getCliente() + ":");
        conta1.imprimirExtrato();

        System.out.println("\nExtrato logica.Conta Poupança de " + conta2.getCliente() + ":");
        conta2.imprimirExtrato();

        // Listando todas as transações realizadas
        System.out.println("\nTransações realizadas:");
        banco.transacoes.forEach(Transacao::imprimirDetalhes);

    }

}*/