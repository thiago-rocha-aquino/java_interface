package exerc1;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class corBotao extends JFrame implements ActionListener {
	private JPanel painel;
	private JButton botaoVerde;
	private JButton botaoAmarelo;
	private JButton botaoBranco;
	
	public corBotao() {
		super("cor de fundo dos botões");
		botaoVerde = new JButton("verde");
		botaoVerde.setBackground(Color.GREEN);
		botaoVerde.addActionListener(this);
		
		botaoAmarelo = new JButton("amarelo");
		botaoAmarelo.setBackground(Color.YELLOW);
		botaoAmarelo.addActionListener(this);
		
		botaoBranco = new JButton("branco");
		botaoBranco.setBackground(Color.WHITE);
		botaoBranco.addActionListener(this);
		
		
		
		painel = new JPanel(new FlowLayout());
		painel.add(botaoVerde);
		painel.add(botaoAmarelo);
		painel.add(botaoBranco);
		
		this.add(painel);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== botaoVerde) {
			painel.setBackground(Color.GREEN);
		}else if(e.getSource()==botaoAmarelo) {
			painel.setBackground(Color.YELLOW);
		}else if(e.getSource()==botaoBranco) {
			painel.setBackground(Color.WHITE);
		}
	}
	
	
		public static void main(String[] args) {
			corBotao ex = new corBotao();
			ex.setVisible(true);
			ex.setSize(300,300);
			ex.setLocationRelativeTo(null);
		}
	
}
