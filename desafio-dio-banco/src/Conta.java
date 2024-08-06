public abstract class Conta {
//conta abstrata para garantir a nao implementação de uma "Conta"
    protected int agencia;
    protected int conta;
    protected double saldo;

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 0;
    private Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.conta = SEQUENCIAL++;
        this.saldo = 0;
        this.cliente = cliente;
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
        saldo -= valor;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public abstract void imprimirExtrato();

}
