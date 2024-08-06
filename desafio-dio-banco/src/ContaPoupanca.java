public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public void imprimirExtrato() {
        System.out.println("===== Conta Poupanca =====");
        System.out.println("Agencia: " + this.getAgencia());
        System.out.println("Conta: " + this.getConta());
        System.out.println("Saldo: " + String.format("%.2f", this.getSaldo()));
    }

}
