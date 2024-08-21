package interfaceGrafica;

import logica.Banco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaPrincipal extends JFrame {

    private Banco banco;

    public JanelaPrincipal(Banco banco) {
        this.banco = banco;
        this.setTitle("Banco Digital");
        this.setSize(450, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(7, 1));

        JButton botaoCadastrarCliente = new JButton("Cadastrar Cliente");
        JButton opBasicas = new JButton("Deposito/Saque");
        JButton opTransfer = new JButton("Transferencia");
        JButton verificaExtrato = new JButton("Extrato");

        add(new JLabel("Selecione a operação desejada"));
        add(botaoCadastrarCliente);
        add(opBasicas);
        add(opTransfer);
        add(verificaExtrato);

        JTextArea areaClientes = new JTextArea();
        areaClientes.setEditable(false);

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.add(new JLabel("Clientes Ativos"));
        painelPrincipal.add(areaClientes);

        JButton botaoExibeClientes = new JButton("Exibir Clientes");
        painelPrincipal.add(botaoExibeClientes);

        add(painelPrincipal, BorderLayout.NORTH);
        add(new JScrollPane(areaClientes), BorderLayout.CENTER);

        ActionListener acaoListarClientes = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                areaClientes.setText("");
                areaClientes.append(banco.listarInfosClientes());
            }
        };

        botaoExibeClientes.addActionListener(acaoListarClientes);

        botaoCadastrarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                acaoListarClientes.actionPerformed(event);
                new JanelaCliente(banco).setVisible(true);
            }
        });

        opBasicas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                acaoListarClientes.actionPerformed(event);
                new JanelaOperacoes(banco).setVisible(true);
            }
        });

        opTransfer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                acaoListarClientes.actionPerformed(event);
                new JanelaTransferencia(banco).setVisible(true);
            }
        });

        verificaExtrato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                new JanelaExtrato(banco).setVisible(true);
            }
        });

    }

    public static void main(String[] args) {

        Banco banco = new Banco("meuBanco");

        JanelaPrincipal janela = new JanelaPrincipal(banco);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension tamanhoTela = toolkit.getScreenSize();
        Dimension tamanhoJanela = janela.getSize();

        int x = (tamanhoTela.width - tamanhoJanela.width) / 2;
        int y = (tamanhoTela.height - tamanhoJanela.height) / 2;

        // Define a posição da janela
        janela.setLocation(x, y);

        janela.setVisible(true);
    }

}
