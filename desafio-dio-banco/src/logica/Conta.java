package logica;

public class Conta {
//conta abstrata para garantir a nao implementação de uma "logica.Conta"
    private int agencia;
    private int conta;
    private double saldo;
    private RegistradorTransacao registradorTransacao;

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    private Cliente cliente;

    public Conta(Cliente cliente, RegistradorTransacao registradorTransacao) {
        this.agencia = AGENCIA_PADRAO;
        this.conta = SEQUENCIAL++;
        this.saldo = 0;
        this.cliente = cliente;
        this.registradorTransacao = registradorTransacao;
    }

    public String getCliente() {
        return cliente.getNome();
    }

    public int getAgencia() {
        return agencia;
    }

    public int getConta() {
        return conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void sacar(double valor) {
        if(valor <= saldo) {
            saldo -= valor;
            if(registradorTransacao != null) {
                Transacao transacao = new Transacao(this, null, "Saque", valor);
                registradorTransacao.registrarTransacao(transacao);
            }
        }   else    {
            System.out.println("Saldo insuficiente");
        }
    }

    public void depositar(double valor) {
            saldo += valor;
            if(registradorTransacao != null) {
                Transacao transacao = new Transacao(null, this, "Deposito", valor);
                registradorTransacao.registrarTransacao(transacao);
            }
    }

    protected void aumentaSaldo(double valor) {
        this.saldo += valor;
    }

    public void transferir(double valor, Conta contaDestino) {
        if(valor <= saldo) {
            saldo -= valor;
            contaDestino.aumentaSaldo(valor);
            if(registradorTransacao != null) {
                Transacao transacao = new Transacao(this, contaDestino, "Transferencia", valor);
                registradorTransacao.registrarTransacao(transacao);
            }
        }   else    {
            System.out.println("Saldo insuficiente");
        }
    }

    public void imprimirExtrato() {
        System.out.println("Agencia: " + this.getAgencia());
        System.out.println("logica.Conta: " + this.getConta());
        System.out.println("Saldo: " + this.getSaldo());
    };

    @Override
    public String toString() {
        return String.format("Conta [Agencia=%d, Conta=%d, Saldo=%.2f, Cliente=%s]",
                agencia, conta, saldo, cliente.getNome());
    }

}
