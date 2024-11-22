package br.edu.fatecpg.main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Excecao extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txt_Nome;
    private JTextField txt_Idade;
    private JTextField txt_Email;

    // Launch the application
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Excecao frame = new Excecao();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Create the frame
    public Excecao() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(41, 12, 70, 15);
        contentPane.add(lblNome);

        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setBounds(41, 61, 70, 15);
        contentPane.add(lblIdade);

        JLabel lblEmail = new JLabel("E-mail:");
        lblEmail.setBounds(41, 118, 70, 15);
        contentPane.add(lblEmail);

        txt_Nome = new JTextField();
        txt_Nome.setBounds(34, 34, 114, 19);
        contentPane.add(txt_Nome);
        txt_Nome.setColumns(10);

        txt_Idade = new JTextField();
        txt_Idade.setBounds(34, 88, 114, 19);
        contentPane.add(txt_Idade);
        txt_Idade.setColumns(10);

        txt_Email = new JTextField();
        txt_Email.setBounds(34, 145, 114, 19);
        contentPane.add(txt_Email);
        txt_Email.setColumns(10);

        JButton btnCadastrar = new JButton("CADASTRAR");
        btnCadastrar.setBounds(282, 199, 117, 25);
        contentPane.add(btnCadastrar);

        // Ação do botão "Cadastrar"
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Validação dos campos
                String nome = txt_Nome.getText().trim();
                String idadeText = txt_Idade.getText().trim();
                String email = txt_Email.getText().trim();

                // Validações
                if (nome.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O campo 'Nome' não pode ser vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int idade = 0;
                try {
                    if (idadeText.isEmpty()) {
                        throw new NumberFormatException();
                    }
                    idade = Integer.parseInt(idadeText);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "O campo 'Idade' deve conter um número inteiro válido!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!email.contains("@")) {
                    JOptionPane.showMessageDialog(null, "O e-mail deve ser válido (contendo '@')!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Exibe a mensagem de sucesso
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}

