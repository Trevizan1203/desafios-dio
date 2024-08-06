public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    public void imprimirExtrato() {
        System.out.println("===== Conta Corrente =====");
        System.out.println("Agencia: " + this.getAgencia());
        System.out.println("Conta: " + this.getConta());
        System.out.println("Saldo: " + String.format("%.2f", this.getSaldo()));
    }
}
