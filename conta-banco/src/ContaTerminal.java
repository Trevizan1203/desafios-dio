import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);

        System.out.print("Por favor, digite o numero da sua conta: ");
        int conta = scan.nextInt();
        scan.nextLine();

        System.out.print("Por favor, digite sua agência: ");
        String agencia = scan.nextLine();

        System.out.print("Por favor, digite o seu nome: ");
        String nomeCliente = scan.nextLine();

        System.out.print("Por favor, insira seu saldo: ");
        double saldo = scan.nextDouble();

        System.out.print("Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é " + agencia + ", conta " + conta + " e seu saldo " + saldo + " já está disponível para saque.");
        scan.close();
    }

}
