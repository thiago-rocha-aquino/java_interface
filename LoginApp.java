package exerc1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginApp extends JFrame implements ActionListener {
    
    private JTextField usuario1;
    private JPasswordField senha1;
    private JButton entrar, cancelar;

    public LoginApp() {
        super("Nome de Usuário e Senha");

       
        JPanel painel = new JPanel(new GridLayout(3, 2, 5, 5));

        
        painel.add(new JLabel("Nome do Usuário:"));
        usuario1 = new JTextField(15);
        painel.add(usuario1);

        painel.add(new JLabel("Senha:"));
        senha1 = new JPasswordField(15);
        painel.add(senha1);

      
        entrar = new JButton("Entrar");
        cancelar = new JButton("Cancelar");

        entrar.addActionListener(this);
        cancelar.addActionListener(this);

        painel.add(entrar);
        painel.add(cancelar);

        
        add(new JLabel("Informe o nome de usuário e Senha", JLabel.CENTER), BorderLayout.NORTH);
        add(painel, BorderLayout.CENTER);

        setSize(350, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == entrar) {
            String usuario = usuario1.getText();
            String senha = new String(senha1.getPassword());

           
            if (usuario.equals("thiago") && senha.equals("123")) {
                abrirJanelaPrincipal();
            } else {
                JOptionPane.showMessageDialog(this, "Dados Incorretos.", "Message", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == cancelar) {
            System.exit(0);
        }
    }

    private void abrirJanelaPrincipal() {
        JFrame janelaPrincipal = new JFrame("Bem-vindo à janela principal do aplicativo");
        janelaPrincipal.setSize(400, 200);
        janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaPrincipal.setLocationRelativeTo(null);

        JLabel mensagem = new JLabel("Bem-vindo à janela principal do aplicativo", JLabel.CENTER);
        janelaPrincipal.add(mensagem);

        janelaPrincipal.setVisible(true);
        dispose(); 
    }

    public static void main(String[] args) {
        new LoginApp();
    }
}
