package src.main.aplicacao;

import src.main.interfaces.AparelhoTelefonico;
import src.main.interfaces.Navegador;
import src.main.interfaces.ReprodutorMusical;

public class Celular implements AparelhoTelefonico, Navegador, ReprodutorMusical{
    private String modelo;
    private int memoria;

    //construtor do celular
    public Celular(String modelo, int memoria) {
        this.modelo = modelo;
        this.memoria = memoria;
    }

    //implementação dos métodos
    //AparelhoTelefonico

    @Override
    public void ligar(String numero) {
        System.out.println("ligando para " + numero);
    }

    @Override
    public void atender() {
        System.out.println("atendendo ligacao");
    }

    @Override
    public void iniciarCorreioVoz() {
        System.out.println("seu correio de voz tem as senguintes mensagens...");
    }

    //ReprodutorMusical

    @Override
    public void tocarMusica() {
        System.out.println("a musica esta tocando!");
    }

    @Override
    public void pausarMusica() {
        System.out.println("musica pausada!");
    }

    @Override
    public void selecionarMusica(String musica) {
        System.out.println("a musica " + musica + " foi selecionada para tocar");
    }

    //Navegador
    @Override
    public void exibirPagina() {
        System.out.println("a pagina esta sendo exibida");
    }

    @Override
    public void buscarPagina(String url) {
        System.out.println("buscando a pagina na url " + url);
    }

    @Override
    public void adicionarNovaAba() {
        System.out.println("nova aba criada com sucesso!");
    }

    @Override
    public void atualizarPagina() {
        System.out.println("a pagina esta sendo atualizada, por favor aguarde");
    }
}
