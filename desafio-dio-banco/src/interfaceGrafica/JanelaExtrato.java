package interfaceGrafica;

import logica.Banco;
import logica.Conta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaExtrato extends JFrame {

    private Banco banco;

    public JanelaExtrato(Banco banco) {
        this.banco = banco;

        this.setTitle("Extrato da Conta");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        JTextArea numConta = new JTextArea();
        JTextArea areaExtrato = new JTextArea();
        areaExtrato.setEditable(false);
        JButton botaoExibeExtrato = new JButton("Extrato");

        JPanel painel = new JPanel();
        painel.add(new JLabel("Conta:"));
        painel.add(numConta);
        painel.add(botaoExibeExtrato);

        add(painel, BorderLayout.NORTH);
        add(new JScrollPane(areaExtrato), BorderLayout.CENTER);

        botaoExibeExtrato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(numConta.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Insira alguma conta válida");
                }
                else {
                    int numeroConta = Integer.parseInt(numConta.getText());
                    Conta conta = banco.pesquisaConta(numeroConta);

                    if (conta != null) {
                        areaExtrato.setText("");
                        areaExtrato.append("Extrato da conta");
                        areaExtrato.append("\n");
                        areaExtrato.append(conta.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Conta não encontrada");
                        dispose();
                    }
                }
            }
        });

    }

}
