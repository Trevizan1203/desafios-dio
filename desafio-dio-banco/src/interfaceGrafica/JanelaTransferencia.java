package interfaceGrafica;

import logica.Banco;
import logica.Conta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaTransferencia extends JFrame {

    private Banco banco;

    public JanelaTransferencia(Banco banco){
        this.banco = banco;

        this.setTitle("Transferência entre Contas");
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(7, 1));

        JTextArea campoContaOrigem = new JTextArea();
        JTextArea campoContaDestino = new JTextArea();
        JTextArea campoValor = new JTextArea();
        JButton botaoTransferir = new JButton("Transferir");

        add(new JLabel("Conta Origem:"));
        add(campoContaOrigem);
        add(new JLabel("Conta Destino:"));
        add(campoContaDestino);
        add(new JLabel("Valor:"));
        add(campoValor);
        add(botaoTransferir);

        botaoTransferir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(campoContaOrigem.getText().equals("") || campoContaDestino.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Insira os campos corretamente");
                } else {
                    Conta contaOrigem = banco.pesquisaConta(Integer.parseInt(campoContaOrigem.getText()));
                    Conta contaAlvo = banco.pesquisaConta(Integer.parseInt(campoContaDestino.getText()));
                    if(contaOrigem.equals(contaAlvo)){
                        JOptionPane.showMessageDialog(null, "Não é possivel transferir para a propria conta!");
                        dispose();
                    }
                    if(contaOrigem == null || contaAlvo == null){
                        JOptionPane.showMessageDialog(null, "Alguma das contas não foi encontrada");
                        dispose();
                    }
                    contaOrigem.transferir(Double.parseDouble(campoValor.getText()), contaAlvo);
                    JOptionPane.showMessageDialog(null, "Transação realizada com sucesso!");
                    dispose();
                }

            }
        });

    }

}
