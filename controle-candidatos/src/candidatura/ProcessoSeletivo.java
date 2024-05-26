package candidatura;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String[] lista = selecaoCandidatos();
        imprimirSelecionados(lista);
        ligar(lista);
        
    }

    static void imprimirSelecionados(String[] lista) {

        for(int i = 0; i < lista.length; i++) {
            System.out.println("o candidato de número " + (i+1) + " é o(a): " + lista[i]);
        }
    }

    static String[] selecaoCandidatos() {
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JOAO", "FERNANDO", "VINICIUS"};

        List<String> selecionados = new ArrayList<String>();

        int candidatosSelecionados = 0;
        double salarioBase = 2000.0;
        for(int i = 0; i < candidatos.length; i++) {
            if(candidatosSelecionados == 5)
                break;
            String candidatoAtual = candidatos[i];
            double salarioPretendido = valorPretendido();
            if(salarioPretendido <= salarioBase) {
                selecionados.add(candidatoAtual);
                candidatosSelecionados++;
            }
        }
        return selecionados.toArray(new String[0]);
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1950,2200);
    }

    static void ligar(String[] lista) {
        for (String candidato : lista) {
            for(int i = 0; i < 3; i++){
                if(atender()) {
                    System.out.println("O candidato " + candidato + " atendeu a chamada na " + (i+1) + " tentativa" );
                    break;
                } else if (i == 2){
                    System.out.println("o candidato " + candidato + " nao atendeu a chamada");
                }
            }
        }
    }

    static boolean atender() {
        return new Random().nextInt(2) == 1;
    }

}
