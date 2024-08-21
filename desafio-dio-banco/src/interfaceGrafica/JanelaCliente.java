package interfaceGrafica;

import logica.Banco;
import logica.Cliente;
import logica.Conta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaCliente extends JFrame {

    private Banco banco;

    public JanelaCliente(Banco banco){
        this.banco = banco;
        this.setTitle("Criar Cliente");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(300,150);
        this.setLayout(new GridLayout(3,1));
        this.setLocationRelativeTo(null);

        JLabel nome = new JLabel("Nome Cliente:");
        JTextField textoNome = new JTextField();
        JButton cadastrar = new JButton("Cadastrar");

        add(nome);
        add(textoNome);
        add(cadastrar);

        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textoNome.getText();
                if(nome.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencher com algum nome para fazer o cadastro");
                } else {
                    Cliente cliente = new Cliente(nome);
                    Conta conta = new Conta(cliente, banco);
                    banco.addConta(conta);
                    JOptionPane.showMessageDialog(null, "Cliente " + cliente.getNome() + " cadastrado com sucesso!");
                    dispose();
                }
            }
        });
    }
}
