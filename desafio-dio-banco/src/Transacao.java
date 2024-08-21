import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {

    private Conta origem;
    private Conta destino;
    private LocalDateTime dataDaTransacao;
    private static final DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private String tipoTransacao;
    private double valor;
    private int ID;

    private static int GERADOR_ID = 0;

    public Transacao(Conta origem, Conta destino, String tipoTransacao, double valor) {
        this.origem = origem;
        this.destino = destino;
        this.tipoTransacao = tipoTransacao;
        this.ID = ++GERADOR_ID;
        this.dataDaTransacao = LocalDateTime.now();
        this.valor = valor;
    }

    public Conta getOrigem() {
        return origem;
    }

    public Conta getDestino() {
        return destino;
    }

    public LocalDateTime getDataDaTransacao() {
        return dataDaTransacao;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public int getID() {
        return ID;
    }

    public void imprimirDetalhes() {
        System.out.println("Id da transacao: " + this.getID());
        System.out.println("Transação do tipo: " + this.getTipoTransacao());
        if(origem != null) {System.out.println("Conta de Origem: " + origem.getConta());}
        if(destino != null) {System.out.println("Conta de Destino: " + destino.getConta());}
        System.out.println("Data da Transacao: " + dataDaTransacao.format(formatador));
        System.out.println("Valor da Transacao: " + valor);
        System.out.println('\n');
    }

}
