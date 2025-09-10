package exerc1;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class calculadora extends JFrame implements ActionListener {
	private JPanel botoes;
	private JTextField campo;
	private String Numero1 = "";
	private String Numero2 = "";
	private char operador;
    private boolean limpando = false;
	
	public calculadora() {
		super("Calculadora");
		setLayout(new BorderLayout(10,10));
		
		campo = new JTextField(25);
		campo.setEditable(false);
		add(campo, BorderLayout.NORTH);
		
		
		
		botoes = new JPanel();
		botoes.setLayout(new GridLayout(4,4,5,5));
		botoes.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		String[] botoeslabel = {
				 "7", "8", "9", "/",
	             "4", "5", "6", "*",
	             "1", "2", "3", "-",
	             "C", "0", "=", "+"
		};
		for(String label: botoeslabel) {
			JButton button = new JButton(label);
			button.addActionListener(this);
			botoes.add(button);
			
		}
		
		add(botoes, BorderLayout.CENTER);
		
	}
	
	 private double calcular() {
	        double num1 = Double.parseDouble(Numero1);
	        double num2 = Double.parseDouble(Numero2);
	        double resultado = 0.0;

	        switch (operador) {
	            case '+':
	                resultado = num1 + num2;
	                break;
	            case '-':
	                resultado = num1 - num2;
	                break;
	            case '*':
	                resultado = num1 * num2;
	                break;
	            case '/':
	                if (num2 != 0) {
	                    resultado = num1 / num2;
	                } else {
	                    campo.setText("Erro: Divisão por zero"); 
	                }
	                break;
	        }
	        return resultado;
	    }
	
	
	public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand(); 

       
        if (Character.isDigit(command.charAt(0))) {
            if (limpando) {
                campo.setText("");
                limpando = false;
            }
            campo.setText(campo.getText() + command);
        }
        
        else if (command.equals("C")) {
            campo.setText("");
            Numero1 = "";
            Numero2 = "";
            operador = '\0'; 
        }
       
        else if (command.equals("=")) {
            if (!Numero1.isEmpty() && !campo.getText().isEmpty()) {
                Numero2 = campo.getText();
                double resultado = calcular();
                campo.setText(String.valueOf(resultado));
                Numero1 = String.valueOf(resultado); 
                Numero2 = "";
                operador = '\0';
                limpando = true;
            }
        }
        
        else {
            if (!campo.getText().isEmpty()) {
                Numero1 = campo.getText();
                operador = command.charAt(0);
                limpando = true;
            }
        }
    }

	

	public static void main(String[] args) {
		calculadora t = new calculadora();
		t.setVisible(true);
		t.setSize(300,300);
		t.setResizable(false);
		t.setLocationRelativeTo(null);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
