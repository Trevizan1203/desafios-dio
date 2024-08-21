package interfaceGrafica;

import logica.Banco;
import logica.Conta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaOperacoes extends JFrame {

    private Banco banco;

    public JanelaOperacoes(Banco banco) throws HeadlessException {
        this.banco = banco;
        this.setTitle("Operações de Banco");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(300, 200);
        this.setLayout(new GridLayout(6, 1));
        this.setLocationRelativeTo(null);

        JLabel frase = new JLabel("Insira a conta alvo de alguma das operações");
        JTextArea contaAlvo = new JTextArea();
        JButton depositar = new JButton("Depositar");
        JLabel frase2 = new JLabel("Valor");
        JTextArea valor = new JTextArea();
        JButton sacar = new JButton("Sacar");

        contaAlvo.setSize(150,150);

        add(frase);
        add(contaAlvo);
        add(frase2);
        add(valor);
        add(depositar);
        add(sacar);

        depositar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(contaAlvo.getText().equals("") || valor.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos");
                } else {
                    Conta aux = banco.pesquisaConta(Integer.parseInt(contaAlvo.getText()));
                    if(aux == null) {
                        JOptionPane.showMessageDialog(null, "Conta não encontrada");
                        dispose();} else {
                        aux.depositar(Double.parseDouble(valor.getText()));
                        JOptionPane.showMessageDialog(null, "Deposito realizado com sucesso");
                        dispose();
                    }
                }
            }
        });

        sacar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(contaAlvo.getText().equals("") || valor.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos");
                } else {
                    Conta aux = banco.pesquisaConta(Integer.parseInt(contaAlvo.getText()));
                    if(aux == null) {
                        JOptionPane.showMessageDialog(null, "Conta não encontrada");
                        dispose();} else {
                    aux.sacar(Double.parseDouble(valor.getText()));
                    JOptionPane.showMessageDialog(null, "Saque realizado com sucesso");
                    dispose();
                    }
                }
            }
        });

    }
}
